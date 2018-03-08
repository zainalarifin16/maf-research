window.propertiesApi = (function()
{
  function noOp() {}

  function getLocalValue(el)
  {
    var value = adf.mf.el.getLocalValue(el);

    return (value != null && value[".null"] === true) ? null : value;
  }

  function getSourceEl(componentName)
  {
    return "#{GlobalProperties['componentProperties']['" + componentName + "']}";
  }

  function getDestinationEl(property)
  {
    if (property == null)
    {
      return "#{pageFlowScope.componentProperties}";
    }
    else
    {
      return "#{pageFlowScope.componentProperties['" + property + "']}";
    }
  }

  function setupHostedProperties(componentName, action)
  {
    // In hosted mode, there is no embedded side, so make all changes as local values

    // Get the map from which to copy the values
    var el = getSourceEl(componentName);
    adf.mf.el.getValue(
      el,
      function(req, res)
      {
        var obj = res[0].value;

        // Push the value into a page flow scope object for the test page to use. This
        // prevents the real values from changing in hosted mode so that we can reset the values
        // back to the originals. setLocalValue used as the hosted mode will not be able to set
        // the value.
        adf.mf.el.setLocalValue(
          { name: getDestinationEl(), value: obj },
          function()
          {
            // Navigate to the component demo page for the component
            adf.mf.api.amx.doNavigation(action ? action : componentName);
          },
          noOp);
      },
      noOp);
  }

  function setupDeviceProperties(componentName, action)
  {
    function afterClear()
    {
      var el = getSourceEl(componentName);

      adf.mf.el.getValue(
        el,
        function(req, res)
        {
          var obj = res[0].value;
          var setArgs = [];

          // For each property on the object, set it on the copy (so to keep an unmodified
          // version)
          for (var prop in obj)
          {
            var propValue = obj[prop];
            setArgs.push(
              {
                "name": getDestinationEl(prop),
                "value": propValue
              });
          }

          adf.mf.el.setValue(
            setArgs,
            function()
            {
              // Work-around for Bug 19833711
              delete adf.mf.el.getLocalValue("#{pageFlowScope.componentProperties}")['.null'];

              // Navigate to the component demo page for the component
              adf.mf.api.amx.doNavigation(action ? action : componentName);
            },
            noOp);
        },
        noOp);
    }

    function clearLocalValue()
    {
      // If the clear function is called, the bean is cleared, but not the JS cache, so set the
      // JS cache value to an object with no properties
      adf.mf.el.setLocalValue(
        {
          "name": "#{pageFlowScope.componentProperties}",
          "value": {}
        },
        afterClear,
        noOp);
    }

    // In case the map has been used for a different component, clear the current values
    adf.mf.el.invoke("#{pageFlowScope.componentProperties.clear}",
      [], "void", [], clearLocalValue, noOp);
  }

  function isHostedMode()
  {
    return !!adf.mf.el.getLocalValue("#{GlobalProperties.hostedMode eq true}");
  }

  var api =
  {
    setupProperties: function(evt)
    {
      var amxNode = evt.amxNode;

      if (!adf.mf.api.amx.isValueTrue(amxNode.getAttribute("showLinkIcon")))
      {
        return;
      }

      // Work-around until an amx:clientAttribute tag is available
      var componentName = amxNode.getAttribute("data-component-name");
      var action = amxNode.getAttribute("data-component-properties-key");

      // The get value call will not work during the clientListener callback (reason unknown at this
      // time). As a work-around, make the EL call off of the current call-stack using a timeout
      var hosted = isHostedMode();
      window.setTimeout((hosted ? setupHostedProperties : setupDeviceProperties),
        1, componentName, action);
    }
  };

  return api;
})();
