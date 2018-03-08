/* Copyright (c) 2011, 2017, Oracle and/or its affiliates. All rights reserved. */
(function()
{
  try
  {
    // --------------------------------------------------------------------------------------------------------
    // This section of code is for the custom:example tag seen under General - Custom Component
    // --------------------------------------------------------------------------------------------------------

    var example = adf.mf.api.amx.TypeHandler.register("http://xmlns.example.com/custom", "example");

    example.prototype.render = function(amxNode, id)
    {
      var rootElement = document.createElement("div");
      try
      {
        rootElement.className = "custom-example";

        var imgElement = document.createElement("img");
        var source = amx.getTextValue(amxNode.getAttribute("source"));
        imgElement.setAttribute("src", adf.mf.api.amx.buildRelativePath(source));
        imgElement.setAttribute("class", "custom-example-img");

        // This is a decorative image
        imgElement.setAttribute("role", "presentation");
        imgElement.setAttribute("aria-hidden", "true");
        imgElement.setAttribute("alt", "");

        rootElement.appendChild(imgElement);

        var labelElement = document.createElement("label");
        labelElement.className = "custom-example-label";
        var label = _customEnsureValidString(amxNode.getAttribute("label"), "");
        labelElement.appendChild(document.createTextNode(label));
        rootElement.appendChild(labelElement);

        var descendants = amxNode.renderDescendants();
        for (var i=0, size=descendants.length; i<size; ++i)
        {
          var elem = descendants[i];
          var wrapper = document.createElement("div");
          wrapper.className = "custom-example-wrapper";
          wrapper.appendChild(elem);
          rootElement.appendChild(wrapper);
        }
      }
      catch (problem)
      {
        adf.mf.log.Framework.logp(
          adf.mf.log.level.SEVERE,
          "example",
          "render",
          "Problem with custom component creation: " + problem);
      }
      return rootElement;
    };

    // --------------------------------------------------------------------------------------------------------
    // This section of code is for the custom:example tag seen under General - Custom Component - Other
    // Examples - Example Events
    // --------------------------------------------------------------------------------------------------------

    var exampleEvents = adf.mf.api.amx.TypeHandler.register("http://xmlns.example.com/custom", "exampleEvents");

    exampleEvents.prototype.render = function(amxNode, id)
    {
      var rootElement = document.createElement("div");
      try
      {
        rootElement.className = "custom-exampleEvents";
        var statusElementId = id + "_status";

        // Add a DIV for demonstrating a bubble event listener:
        var bubbleEventElement = document.createElement("div");
        bubbleEventElement.id = id + "_tapBubbleEvent";
        bubbleEventElement.className = "custom-exampleEvents_tapBubbleEvent";
        bubbleEventElement.textContent = "Tap Toggle";
        adf.mf.api.amx.addBubbleEventListener(
          bubbleEventElement,
          "tap",
          this._handleBubbleEvent,
          {
            "statusId": statusElementId,
            "buttonId": id + "_tapBubbleEvent",
            "status": "Handled tap bubble event"
          });
        rootElement.appendChild(bubbleEventElement);

        // Add a DIV for demonstrating removal of the bubble event listener from the bubbleEventElement:
        var removeBubbleEventElement = document.createElement("div");
        removeBubbleEventElement.id = id + "_removeBubbleEvent";
        removeBubbleEventElement.className = "custom-exampleEvents_removeBubbleEvent";
        removeBubbleEventElement.textContent = "Remove Toggle";
        adf.mf.api.amx.addBubbleEventListener(
          removeBubbleEventElement,
          "tap",
          this._handleRemove,
          {
            "statusId": statusElementId,
            "buttonId": id + "_tapBubbleEvent",
            "listenerToRemove": this._handleBubbleEvent,
            "status": "Removing the tap bubble event"
          });
        rootElement.appendChild(removeBubbleEventElement);

        // Add a DIV for demonstrating a "taphold" bubble event listener:
        var tapHoldBubbleEventElement = document.createElement("div");
        tapHoldBubbleEventElement.id = id + "_tapHoldBubbleEvent";
        tapHoldBubbleEventElement.className = "custom-exampleEvents_tapHoldBubbleEvent";
        tapHoldBubbleEventElement.textContent = "Tap Hold Toggle";
        adf.mf.api.amx.addBubbleEventListener(
          tapHoldBubbleEventElement,
          "taphold",
          this._handleBubbleEvent,
          {
            "statusId": statusElementId,
            "buttonId": id + "_tapHoldBubbleEvent",
            "status": "Handled taphold bubble event"
          });
        rootElement.appendChild(tapHoldBubbleEventElement);

        // Add a DIV for demonstrating a "tap" showPopupBehavior trigger:
        var tapHoldTriggerElement = document.createElement("div");
        tapHoldTriggerElement.id = id + "_tapHoldTrigger";
        tapHoldTriggerElement.className = "custom-exampleEvents_tapHoldTrigger";
        tapHoldTriggerElement.textContent = "Tap Hold Trigger";
        adf.mf.api.amx.enableAmxEvent(amxNode, tapHoldTriggerElement, "tapHold");
        rootElement.appendChild(tapHoldTriggerElement);

        // Add a DIV for demonstrating various swipe showPopupBehavior triggers:
        var swipeTriggerElement = document.createElement("div");
        swipeTriggerElement.id = id + "_swipeTrigger";
        swipeTriggerElement.className = "custom-exampleEvents_swipeTrigger";
        swipeTriggerElement.textContent = "Swipe Trigger";
        adf.mf.api.amx.enableAmxEvent(amxNode, swipeTriggerElement, "swipe");
        rootElement.appendChild(swipeTriggerElement);

        // Add a DIV for demonstrating a "drag" listener:
        var dragElement = document.createElement("div");
        dragElement.id = id + "_dragEvent";
        dragElement.className = "custom-exampleEvents_dragEvents";
        dragElement.textContent = "Drag";
        adf.mf.api.amx.addDragListener(dragElement,
          {
            "start": this._handleDragStart,
            "drag": this._handleDrag,
            "end": this._handleDragEnd
          },
          {
            "statusId": statusElementId
          });
        rootElement.appendChild(dragElement);

        // Add a "status message" DIV:
        var statusElement = document.createElement("div");
        statusElement.id = statusElementId;
        statusElement.className = "custom-exampleEvents_status";
        statusElement.textContent = "No events yet";
        rootElement.appendChild(statusElement);
      }
      catch (problem)
      {
        adf.mf.log.Framework.logp(
          adf.mf.log.level.SEVERE,
          "exampleEvents",
          "render",
          "Problem with custom component creation: " + problem);
      }
      return rootElement;
    };

    exampleEvents.prototype._handleBubbleEvent = function(event)
    {
      try
      {
        // Update the status text with a message that we are handling a tap:
        var statusElement = document.getElementById(event.data["statusId"]);
        statusElement.textContent = event.data["status"];

        // Toggle a style class on the bubble event element so that we can see a visual change each time we tap:
        var buttonElement = document.getElementById(event.data["buttonId"]);
        if (buttonElement.className.indexOf("custom-exampleEvents_orange") == -1)
          buttonElement.className += " custom-exampleEvents_orange";
        else
          buttonElement.className = buttonElement.className.replace("custom-exampleEvents_orange", "");
      }
      catch (problem)
      {
        adf.mf.log.Framework.logp(
          adf.mf.log.level.SEVERE,
          "exampleEvents",
          "_handleBubbleEvent",
          "Problem in exampleEvents.prototype._handleBubbleEvent: " + problem);
      }
    };

    exampleEvents.prototype._handleRemove = function(event)
    {
      try
      {
        // Update the status text with a message that we are handling the remove:
        var statusElement = document.getElementById(event.data["statusId"]);
        statusElement.textContent = event.data["status"];

        // Remove the tap bubble event listener from the bubble event element and give it a line-through style:
        var bubbleEventElement = document.getElementById(event.data["buttonId"]);
        adf.mf.api.amx.removeBubbleEventListener(bubbleEventElement, "tap", event.data["listenerToRemove"]);
        bubbleEventElement.style.textDecoration = "line-through";
      }
      catch (problem)
      {
        adf.mf.log.Framework.logp(
          adf.mf.log.level.SEVERE,
          "exampleEvents",
          "_handleRemove",
          "Problem in exampleEvents.prototype._handleRemove: " + problem);
      }
    };

    exampleEvents.prototype._handleDragStart = function(event, dragExtra)
    {
      var elementId = event.data["statusId"];
      var element = document.getElementById(elementId);

      // Declare this element as the one that is currently handling drag events:
      dragExtra.requestDragLock(element, true, true);

      event.preventDefault();
      event.stopPropagation();
      dragExtra.preventDefault = true;
      dragExtra.stopPropagation = true;

      element.style.fontStyle = "italic";
      element.textContent = "Handled drag start";
    };

    exampleEvents.prototype._handleDrag = function(event, dragExtra)
    {
      event.preventDefault();
      event.stopPropagation();
      dragExtra.preventDefault = true;
      dragExtra.stopPropagation = true;

      var startPageX = dragExtra["startPageX"];
      var startPageY = dragExtra["startPageY"];
      var originalAngle = dragExtra["originalAngle"];
      var pageX = dragExtra["pageX"];
      var pageY = dragExtra["pageY"];
      var deltaPageX = dragExtra["deltaPageX"];
      var deltaPageY = dragExtra["deltaPageY"];
      var elementId = event.data["statusId"];
      var element = document.getElementById(elementId);
      element.textContent =
        "Handled drag with delta: x0=" + startPageX +
        ", y0=" + startPageY +
        ", deg=" + originalAngle +
        ", x=" + pageX +
        ", y=" + pageY +
        ", dx=" + deltaPageX +
        ", dy=" + deltaPageY;
    };

    exampleEvents.prototype._handleDragEnd = function(event, dragExtra)
    {
      event.preventDefault();
      event.stopPropagation();
      dragExtra.preventDefault = true;
      dragExtra.stopPropagation = true;
      var elementId = event.data["statusId"];
      var element = document.getElementById(elementId);
      element.style.fontStyle = "normal";
      element.textContent = "Handled drag end";
    };

    // --------------------------------------------------------------------------------------------------------
    // This section of code is for the custom:exampleList tag seen under General - Custom Component - Other
    // Examples - Example List
    // --------------------------------------------------------------------------------------------------------

    var exampleList = adf.mf.api.amx.TypeHandler.register("http://xmlns.example.com/custom", "exampleList");

    exampleList.prototype.createChildrenNodes = function(amxNode)
    {
      // See if the exampleList is bound to a collection
      if (!amxNode.isAttributeDefined("value"))
      {
        // Let the default behavior occur of building the child nodes
        return false;
      }

      var dataItems;
      if (adf.mf.environment.profile.dtMode)
      {
        // If in DT mode, create 3 dummy children so that something is displayed
        // on the page
        dataItems = [ {}, {}, {} ];
        amxNode.setAttributeResolvedValue("value", dataItems);
      }
      else
      {
        dataItems = amxNode.getAttribute("value");
        if (dataItems === undefined)
        {
          // Mark it so the framework knows that the children nodes cannot be
          // created until the collection model has been loaded
          amxNode.setState(adf.mf.api.amx.AmxNodeStates["INITIAL"]);
          return true;
        }
        else if (dataItems == null)
        {
          // No items, nothing to do
          return true;
        }
      }

      var fetchSize = Infinity;
      var maxRows = null;
      var fetchSizeAttribute = amxNode.getAttribute("fetchSize");
      if (fetchSizeAttribute != null && _customIsFiniteNumber(parseInt(fetchSizeAttribute, 10)))
      {
        fetchSize = parseInt(fetchSizeAttribute, 10);
        if (fetchSize < 0)
        {
          fetchSize = Infinity;
        }
        else if (fetchSize == 0)
        {
          fetchSize = 25;
        }
      }
      amxNode.setAttributeResolvedValue("fetchSize", fetchSize);

      // See if there is a stored max rows in the client state
      var clientState = amxNode.getClientState();
      if (clientState != null)
      {
        maxRows = clientState.maxRows;
        if (maxRows != null)
        {
          amxNode.setAttributeResolvedValue("maxRows", maxRows);
        }
      }

      if (maxRows == null)
      {
        if (amxNode.isAttributeDefined("maxRows") == false)
        {
          maxRows = fetchSize;
          amxNode.setAttributeResolvedValue("maxRows", fetchSize);
        }
        else
        {
          maxRows = parseInt(amxNode.getAttribute("maxRows"), 10);
          if (isNaN(maxRows))
          {
            maxRows = fetchSize;
            amxNode.setAttributeResolvedValue("maxRows", fetchSize);
          }
        }
      }
      amxNode.setAttributeResolvedValue("_oldMaxRows", maxRows);

      var iter = adf.mf.api.amx.createIterator(dataItems);

      // See if all the rows have been loaded, if not, force the necessary
      // number of rows to load and then build this node's children
      if (iter.getTotalCount() > iter.getAvailableCount() &&
        iter.getAvailableCount() < maxRows)
      {
        adf.mf.api.amx.showLoadingIndicator();
        adf.mf.api.amx.bulkLoadProviders(dataItems, 0, maxRows,
          function()
          {
            try
            {
              // Call the framework to have the new children nodes constructed.
              var args = new adf.mf.api.amx.AmxNodeUpdateArguments();
              args.setAffectedAttribute(amxNode, "value");
              adf.mf.api.amx.markNodeForUpdate(args);
            }
            finally
            {
              adf.mf.api.amx.hideLoadingIndicator();
            }
          },
          function(message)
          {
            adf.mf.log.Framework.logp(
              adf.mf.log.level.SEVERE,
              "exampleList",
              "createChildrenNodes",
              "Error while doing first/next on iterator " + message);
            adf.mf.api.amx.hideLoadingIndicator();
          });

        amxNode.setState(adf.mf.api.amx.AmxNodeStates["INITIAL"]);
        return true;
      }

      // Create the children for the facets outside of the stamps
      amxNode.createStampedChildren(null, [ "header" ]);

      // Now create the stamped children
      var variableName = amxNode.getAttribute("var");
      for (var i = 0; i < maxRows && iter.hasNext(); ++i)
      {
        var item = iter.next();
        adf.mf.el.addVariable(variableName, item);
        amxNode.createStampedChildren(iter.getRowKey(), [ null ]);
        adf.mf.el.removeVariable(variableName);
      }

      amxNode.setState(adf.mf.api.amx.AmxNodeStates["ABLE_TO_RENDER"]);
      return true;
    };

    exampleList.prototype.attributeChangeResult = function(
      amxNode,
      attributeName,
      attributeChanges)
    {
      var embeddedMaintained = this.isEmbeddedSideMaintainingHierarchy();

      switch (attributeName)
      {
        case "value":
          if (embeddedMaintained)
          {
            return adf.mf.api.amx.AmxNodeChangeResult["REFRESH"];
          }
          else
          {
            var collectionChange = attributeChanges.getCollectionChange("value");
            if (collectionChange != null && collectionChange.isItemized())
            {
              return this._updateChildrenForCollectionChange(
                amxNode,
                attributeChanges,
                collectionChange);
            }
            else
            {
              return adf.mf.api.amx.AmxNodeChangeResult["REPLACE"];
            }
          }
          break;

        case "maxRows":
          if (embeddedMaintained)
          {
            return adf.mf.api.amx.AmxNodeChangeResult["REFRESH"];
          }
          else
          {
            return this._updateChildrenForCollectionChange(
              amxNode,
              attributeChanges,
              attributeChanges.getCollectionChange("value"));
          }

          break;

        default:
          return exampleList.superclass.attributeChangeResult.call(this,
            amxNode, attributeName, attributeChanges);
      }
    };

    exampleList.prototype.visitChildren = function(amxNode, visitContext, callback)
    {
      var dataItems = amxNode.getAttribute("value");

      if (dataItems === undefined)
      {
        // If the children are not being stamped
        return amxNode.visitStampedChildren(null, null, null,
          visitContext, callback);
      }

      // Visit the header first
      if (amxNode.visitStampedChildren(null, [ "header" ], null, visitContext, callback))
      {
        return true;
      }

      // Now visit the stamped children
      var iter = adf.mf.api.amx.createIterator(dataItems);
      var variableName = amxNode.getAttribute("var");
      var embeddedMaintained = this.isEmbeddedSideMaintainingHierarchy();

      while (iter.hasNext())
      {
        var item = iter.next();

        if (!embeddedMaintained)
        {
          adf.mf.el.addVariable(variableName, item);
        }

        try
        {
          if (amxNode.visitStampedChildren(iter.getRowKey(), [ null ], null,
            visitContext, callback))
          {
            return true;
          }
        }
        finally
        {
          if (!embeddedMaintained)
          {
            adf.mf.el.removeVariable(variableName);
          }
        }
      }

      return false;
    };

    exampleList.prototype.render = function(amxNode, id)
    {
      var exampleListElement = document.createElement("div");
      var i;

      // Adding WAI-ARIA role of list
      exampleListElement.setAttribute("role", "list");

      exampleListElement.setAttribute("class", "custom-exampleList");
      adf.mf.api.amx.enableScrolling(exampleListElement);

      var selectedRowKey = _customGetSelectedRowKey(amxNode);
      var maxRows = amxNode.getAttribute("maxRows");

      this._renderHeaderFacet(amxNode, exampleListElement);

      var dataItems = amxNode.getAttribute("value");

      if (dataItems !== undefined)
      {
        var iter = adf.mf.api.amx.createIterator(dataItems);

        for (i = 0; i < maxRows && iter.hasNext(); ++i)
        {
          var item = iter.next();

          this._renderItem(amxNode, selectedRowKey, iter, exampleListElement, item, i, {});
        }

        // Add or remove the load more rows link after all the data has been loaded
        this._addOrRemoveLoadMoreRowsDom(amxNode, id, exampleListElement, iter.getTotalCount() > maxRows);
      }
      else
      {
        // If there is no value attribute, just render the children
        var descendants = amxNode.renderDescendants();

        for (i = 0, size = descendants.length; i < size; ++i)
        {
          var childDomNode = descendants[i];

          // Store the row key so it can be used in selection management
          var rowKeyString = "" + i;

          if (selectedRowKey == rowKeyString)
            _customMarkRowAsSelected(childDomNode);

          childDomNode.setAttribute("data-exampleListRk", rowKeyString);

          exampleListElement.appendChild(childDomNode);
        }
      }

      return exampleListElement;
    };

    exampleList.prototype.postDisplay = function(exampleListElement, amxNode)
    {
      // Restore the old scroll position in case this view instance already had one:
      this._restoreScrollPosition(amxNode, exampleListElement);
    };

    exampleList.prototype.refresh = function(amxNode, attributeChanges)
    {
      var exampleListElement = document.getElementById(amxNode.getId());
      var i;

      // The updateChildren function already checked that we can refresh, so no
      // checks need to be performed here. We need to only check if this is
      // a change to the max rows

      // Note: to get the value, make sure to get it from newAmxNode
      if (attributeChanges.hasChanged("value"))
      {
        this._refreshCollectionChanges(amxNode, attributeChanges);
      }
      
      if (attributeChanges.hasChanged("maxRows"))
      {
        // Store the new client state so that the new maxRows are stored
        this._storeClientState(amxNode, exampleListElement);

        // This is the case when the user clicks the load more rows item. At this
        // point only the new rows need to be rendered.
        var lastIndexRendered = amxNode.getAttribute("_lastIndexRendered");

        if (lastIndexRendered == null)
        {
          lastIndexRendered = -1;
        }

        var dataItems = amxNode.getAttribute("value");
        var iter = adf.mf.api.amx.createIterator(dataItems);

        // Position the iterator to before the new row
        if (lastIndexRendered >= 0)
        {
          iter.setCurrentIndex(lastIndexRendered);
        }

        var maxRows = amxNode.getAttribute("maxRows");
        var selectedRowKey = _customGetSelectedRowKey(amxNode);

        // Get the element for the last list item rendered:
        var lastListItem = null;
        var exampleListChildren = exampleListElement.childNodes;

        for (i = exampleListChildren.length - 1; i >= 0; --i)
        {
          var child = exampleListChildren[i];

          if (_customGetCSSClassNameIndex(child.className, "custom-exampleListItem") != -1 &&
              _customGetCSSClassNameIndex(child.className, "custom-exampleList-loadMoreRows") == -1)
          {
            lastListItem = child;
            break;
          }
        }

        // Structure to allow _renderItem to "pass back" multiple values
        var byRefParams =
        {
          "lastListItem": lastListItem
        };

        for (i = lastIndexRendered + 1; i < maxRows && iter.hasNext(); ++i)
        {
          var item = iter.next();
          this._renderItem(amxNode, selectedRowKey, iter, exampleListElement, item, i, byRefParams);
        }

        // Add or remove the load more rows link after all the data has been loaded
        this._addOrRemoveLoadMoreRowsDom(amxNode, exampleListElement.id, exampleListElement, iter.getTotalCount() > maxRows);
      }
    };

    exampleList.prototype.preDestroy = function(rootElement, amxNode)
    {
      // Store off the current scroll position in case this view instance is ever revisited:
      this._storeClientState(amxNode, rootElement);
    };

    exampleList.prototype._refreshCollectionChanges = function(amxNode, attributeChanges)
    {
      var collectionChange = attributeChanges.getCollectionChange("value");

      if (collectionChange != null)
      {
        var updatedKeys = collectionChange.getUpdatedKeys();
        var dataItems = amxNode.getAttribute("value");
        var iter = adf.mf.api.amx.createIterator(dataItems);
  
        for (var i = 0, size = updatedKeys.length; i < size; ++i)
        {
          var key = updatedKeys[i];
          if (iter.setCurrentRowKey(key))
          {
            var children = amxNode.getChildren(null, key);

            // The updateChildren verified that a child was created, so no need to check here
            var child = children[0];
            child.rerender();
          }
        }
      }
    };

    /**
     * Stores the client state of the exampleList
     * @param {HTMLElement} exampleListElement the root element of this exampleList
     * @param {Object} amxNode the unique identifier for this exampleList instance
     */
    exampleList.prototype._storeClientState = function(amxNode, exampleListElement)
    {
      // Store off the current scroll position in case this view instance is ever revisited:
      var scrollLeft = exampleListElement.scrollLeft;
      var scrollTop = exampleListElement.scrollTop;

      var storedData = amxNode.getClientState();
      if (storedData == null)
      {
        storedData = {};
      }

      if (scrollLeft != null || scrollTop != null)
      {
        storedData.scrollLeft = scrollLeft;
        storedData.scrollTop  = scrollTop;
      }

      storedData.maxRows = amxNode.getAttribute("maxRows");

      amxNode.setClientState(storedData);
    };

    exampleList.prototype._restoreScrollPosition = function(amxNode, exampleListElement)
    {
      var storedData = amxNode.getClientState();
      if (storedData != null)
      {
        var scrollLeft = storedData.scrollLeft;
        if (scrollLeft != null)
        {
          exampleListElement.scrollLeft = scrollLeft;
        }
        var scrollTop = storedData.scrollTop;
        if (scrollTop != null)
        {
          exampleListElement.scrollTop = scrollTop;
        }
      }
    };

    exampleList.prototype._renderItem = function(
      exampleListAmxNode,
      selectedRowKey,
      iter,
      exampleListElement,
      item,
      index,
      byRefParams)
    {
      exampleListAmxNode.setAttributeResolvedValue("_lastIndexRendered", index);

      // we set the variable
      var variableName = exampleListAmxNode.getAttribute("var");
      var embeddedMaintained = this.isEmbeddedSideMaintainingHierarchy();

      if (!embeddedMaintained)
      {
        adf.mf.el.addVariable(variableName, item);
      }

      var rowKey = iter.getRowKey();
      var children = exampleListAmxNode.getChildren(null, rowKey);

      for (var i = 0, size = children.length; i < size; ++i)
      {
        var listItemAmxNode = children[i];
        var tag = listItemAmxNode.getTag();

        if (tag.getNamespace() == "http://xmlns.example.com/custom" && tag.getName() == "exampleListItem")
        {
          var listItemElement = listItemAmxNode.render();
          if (listItemElement != null)
          {
            var oldValue = exampleListAmxNode.getAttribute("_oldValue");
            if (oldValue == null)
            {
              exampleListAmxNode.setAttributeResolvedValue("_oldValue", listItemAmxNode.getStampKey());
            }

            // Since this may be called after the next rows element has been added to the exampleList,
            // insert the rows after the last list item if it exists
            this._appendToExampleList(
              exampleListElement,
              listItemElement,
              byRefParams["lastListItem"]);

            byRefParams["lastListItem"] = listItemElement;
          }
          break;
        }
      }

      if (!embeddedMaintained)
      {
        adf.mf.el.removeVariable(variableName);
      }
    };

    exampleList.prototype._renderHeaderFacet = function(amxNode, exampleListElement)
    {
      var headerFacetChildren = amxNode.getRenderedChildren("header");

      if (headerFacetChildren.length)
      {
        var header = document.createElement("div");

        header.className = "custom-exampleList-header";
        exampleListElement.appendChild(header);

        var div = document.createElement("div");

        div.className = "custom-exampleList-facet-header";
        header.appendChild(div);

        for (var i = 0, size = headerFacetChildren.length; i < size; ++i)
        {
          var childElement = headerFacetChildren[i].render();

          if (childElement)
            div.appendChild(childElement);
        }
      }
    };

    exampleList.prototype._appendToExampleList = function(exampleListElement, listItemElement, lastListItemElement)
    {
      // Since this may be called after the next rows elements has been added to the exampleList,
      // insert the rows after the last list item if it exists
      if (lastListItemElement)
      {
        this._insertAfter(exampleListElement, lastListItemElement, listItemElement);
      }
      else
      {
        exampleListElement.appendChild(listItemElement);
      }
    };

    /**
     * Creates the load more rows item in the list for the user to be
     * able to load the next block of rows.
     */
    exampleList.prototype._createAndAppendTheMoreRowsDom = function(amxNode, rootId, exampleListElement)
    {
      var moreRowsElem = document.createElement("div");

      moreRowsElem.id = rootId + "_loadMoreRows";
      moreRowsElem.setAttribute("role", "button");
      moreRowsElem.setAttribute("tabindex", "0");
      moreRowsElem.className = "custom-exampleListItem custom-exampleList-loadMoreRows";

      var loadMoreRowsString = amxNode.getAttribute("loadMoreRowsText");
      //var loadMoreRowsString = adf.mf.resource.getInfoString(bundleName, bundleKey);

      var span = document.createElement("span");

      span.className = "custom-exampleList-rowText";
      span.appendChild(document.createTextNode(loadMoreRowsString));
      moreRowsElem.appendChild(span);
      exampleListElement.appendChild(moreRowsElem);

      adf.mf.api.amx.addBubbleEventListener(moreRowsElem, "tap", this._handleMoreRowsTap, amxNode);
    };

    /**
     * Adds or removes the DOM for the user to be able to load more rows.
     * @param {bool} moreRows true if there are more rows that can be loaded
     */
    exampleList.prototype._addOrRemoveLoadMoreRowsDom = function(amxNode, rootId, exampleListElement, moreRows)
    {
      var moreRowsElement = document.getElementById(rootId + "_loadMoreRows");

      if (moreRows && moreRowsElement == null)
      {
        // There are more rows that can be loaded, but we have not yet added
        // the DOM to have the user load the rows
        this._createAndAppendTheMoreRowsDom(amxNode, rootId, exampleListElement);
      }
      else if (!moreRows && moreRowsElement != null)
      {
        // There are no more rows (neither locally or ones that need fetching),
        // but the more rows DOM is still present, so we need to remove it
        // including all event listeners and data:
        adf.mf.api.amx.removeDomNode(moreRowsElement);
      }
    };

    exampleList.prototype._handleMoreRowsTap = function(event)
    {
      var amxNode = event.data;
      var typeHandler = amxNode.getTypeHandler();
      typeHandler._handleMoreRowsAction(amxNode);
    };

    exampleList.prototype._handleMoreRowsAction = function(amxNode)
    {
      var quantityToLoad = amxNode.getAttribute("fetchSize");
      var maxRows = amxNode.getAttribute("maxRows");
      var currentRows = maxRows;

      adf.mf.api.amx.showLoadingIndicator();

      // First update the maximum number of rows to show if applicable
      if (maxRows != Infinity && quantityToLoad > 0)
      {
        amxNode.setAttributeResolvedValue("_oldMaxRows", currentRows);
        maxRows = maxRows + quantityToLoad;
        amxNode.setAttributeResolvedValue("maxRows", maxRows);

        var dataItems = amxNode.getAttribute("value");
        var iter = adf.mf.api.amx.createIterator(dataItems);

        // See if the cache actually has the needed rows, if not then we should
        // force the new rows to load into the cache before attempting to rerender
        if (iter.getTotalCount() > iter.getAvailableCount() &&
          iter.getAvailableCount() < maxRows)
        {
          var embeddedMaintained = this.isEmbeddedSideMaintainingHierarchy();

          if (embeddedMaintained)
          {
            this._queueRangeChangeListener(amxNode, iter, iter.getAvailableCount(), quantityToLoad);
            adf.mf.api.amx.hideLoadingIndicator();

            return;
          }

          adf.mf.api.amx.bulkLoadProviders(dataItems, currentRows, maxRows,
            function()
            {
              try
              {
                // Call the framework to have the new children nodes constructed and
                // use the maxRows attribute as the changed attribute so that the refresh
                // function knows to only render the new rows.
                var args = new adf.mf.api.amx.AmxNodeUpdateArguments();
                args.setAffectedAttribute(amxNode, "maxRows");
                adf.mf.api.amx.markNodeForUpdate(args);
              }
              finally
              {
                adf.mf.api.amx.hideLoadingIndicator();
              }
            },
            function(message)
            {
              adf.mf.log.Framework.logp(
                adf.mf.log.level.SEVERE,
                "exampleList",
                "_handleMoreRowsAction",
                "Error while doing first/next on iterator " + message);
              adf.mf.api.amx.hideLoadingIndicator();
            });
        }
        else // The rows are actually in the cache
        {
          // Notify the framework so that the new children nodes are created
          // and we are called back with the refresh method. We record that the
          // changed attribute is the generated maxRows attribute so that the
          // refresh function knows to only render the new rows and not rerender
          // the entire exampleList
          var args = new adf.mf.api.amx.AmxNodeUpdateArguments();

          args.setAffectedAttribute(amxNode, "maxRows");
          adf.mf.api.amx.markNodeForUpdate(args);
          adf.mf.api.amx.hideLoadingIndicator();
        }
      }
    };

    /**
     * Function that notifies the embedded side that the range of rows to be displayed has changed
     *
     * @param {adf.mf.api.amx.AmxNode} amxNode the AmxNode that has been updated
     * @param {Object} iterator iterator returned by adf.mf.api.amx.createIterator
     * @param {Number} availableCount the number in the collection currently
     * @param {Number} fetchSize the number to fetch
     */
    exampleList.prototype._queueRangeChangeListener = function(
      amxNode,
      iter,
      availableCount,
      fetchSize)
    {
      var eventSourceId = amxNode.getId();

      // Figure out what the last loaded row key was:
      var lastLoadedRowKey = null;

      if (iter != null)
      {
        lastLoadedRowKey = iter.getRowKey();

        if (availableCount > 0)
        {
          var rowKeyToRestore = iter.getRowKey();

          iter.setCurrentIndex(availableCount - 1);
          lastLoadedRowKey = iter.getRowKey();

          if (rowKeyToRestore != null)
            iter.setCurrentRowKey(rowKeyToRestore);
        }
      }

      var rce = new adf.mf.api.amx.RangeChangeEvent(eventSourceId, null, lastLoadedRowKey, fetchSize);

      adf.mf.api.amx.processAmxEvent(amxNode, "rangeChange", undefined, undefined, rce);
    };

    /**
     * Function used by the exampleList to process the updateChildren response to collection
     * model changes
     * @param {adf.mf.api.amx.AmxNode} amxNode the AmxNode that has been updated
     * @param {adf.mf.api.amx.AmxAttributeChange} attributeChanges the information regarding what attributes
     *        were changed and how they changed
     * @param {adf.mf.api.amx.AmxCollectionChange} collectionChange the information regarding what
     *        collections changes there were. This may be null if this is being called as a result of
     *        bulkLoadProviders being called to fetch more data.
     * @return {int} REFRESH if successful or REPLACE if the function could not apply the updates
     *         to the AmxNode hierarchy
     */
    exampleList.prototype._updateChildrenForCollectionChange = function(
      amxNode,
      attributeChanges,
      collectionChange)
    {
      var dataItems = amxNode.getAttribute("value");
      var embeddedMaintained = this.isEmbeddedSideMaintainingHierarchy();

      if (dataItems === undefined)
      {
        // We went from having a model to not having one, recreate
        return adf.mf.api.amx.AmxNodeChangeResult[embeddedMaintained ? "RERENDER" : "REPLACE"];
      }

      // See if there are itemized changes that can be handled. Currently we only support updates to the
      // providers and do not consume created or deleted providers.
      if (collectionChange != null &&
        collectionChange.isItemized() &&
        collectionChange.getCreatedKeys().length == 0 &&
        collectionChange.getDeletedKeys().length == 0 &&
        collectionChange.getDirtiedKeys().length == 0 &&
        collectionChange.getUpdatedKeys().length > 0)
      {
        if (embeddedMaintained)
        {
          // The embedded code will already have created the necessary nodes, the list only needs to be re-rendered
          return adf.mf.api.amx.AmxNodeChangeResult["RERENDER"];
        }

        var iter = adf.mf.api.amx.createIterator(dataItems);
        var updatedKeys = collectionChange.getUpdatedKeys();
        var numberToFind = updatedKeys.length;

        for (var i = 0; i < numberToFind; ++i)
        {
          // Get the key
          var key = updatedKeys[i];

          if (iter.setCurrentRowKey(key))
          {
            var children = amxNode.getChildren(null, key);

            if (children.length != 1)
            {
              // We will only update list items that were rendered and the exampleList
              // only supports rendering one item per row key.
              return adf.mf.api.amx.AmxNodeChangeResult["REPLACE"];
            }

            var oldAmxNode = children[0];

            // Remove the old list item:
            amxNode.removeChild(oldAmxNode);

            // Create the new list item:
            amxNode.createStampedChildren(key, [ null ]);

            // Ensure a child was created
            if (amxNode.getChildren(null, key).length != 1)
            {
              return adf.mf.api.amx.AmxNodeChangeResult["REPLACE"];
            }
          }
          else
          {
            return adf.mf.api.amx.AmxNodeChangeResult["REPLACE"];
          }
        }

        return adf.mf.api.amx.AmxNodeChangeResult["REFRESH"]; // success application of update
      }

      return adf.mf.api.amx.AmxNodeChangeResult[embeddedMaintained ? "RERENDER" : "REPLACE"];
    };

    exampleList.prototype._insertAfter = function(parentElement, referenceChild, childToInsert)
    {
      var nodeAfterInsert = referenceChild.nextSibling;
      if (nodeAfterInsert == null)
      {
        parentElement.appendChild(childToInsert);
      }
      else
      {
        parentElement.insertBefore(childToInsert, nodeAfterInsert);
      }
    };

    // --------------------------------------------------------------------------------------------------------
    // This section of code is for the custom:exampleListItem tag seen under General - Custom Component - Other
    // Examples - Example List
    // --------------------------------------------------------------------------------------------------------

    var exampleListItem = adf.mf.api.amx.TypeHandler.register("http://xmlns.example.com/custom", "exampleListItem");

    exampleListItem.prototype.render = function(amxNode, id)
    {
      var listItemElement = document.createElement("div");

      listItemElement.className = "custom-exampleListItem";
      listItemElement.setAttribute("tabindex", "0");

      // If item is a button, add WAI-ARIA roles of listitem and button, note that voiceover only
      // announces item as a button if "button" is first in the role string.
      listItemElement.setAttribute("role", "button listitem");

      var caret = document.createElement("div");

      caret.className = "custom-exampleListItem-caret";
      listItemElement.appendChild(caret);

      var descendants = amxNode.renderDescendants();

      for (var i=0, size=descendants.length; i<size; ++i)
      {
        listItemElement.appendChild(descendants[i]);
      }

      adf.mf.api.amx.enableAmxEvent(amxNode, listItemElement, "swipe");
      adf.mf.api.amx.enableAmxEvent(amxNode, listItemElement, "tapHold");

      var selectedRowKey = _customGetSelectedRowKey(amxNode.getParent());

      if (selectedRowKey !== null && selectedRowKey == amxNode.getStampKey())
      {
        _customMarkRowAsSelected(listItemElement);
      }

      listItemElement.setAttribute("data-listViewRk", amxNode.getStampKey());

      var storedState = amxNode.getClientState();

      if (storedState != null && storedState.isHidden == true)
      {
        listItemElement.style.display = "none";
      }

      adf.mf.api.amx.addBubbleEventListener(listItemElement, "tap", this._handleTap,
        {
          "elementId": id,
          "itemAmxNode": amxNode
        });

      return listItemElement;
    };

    exampleListItem.prototype._handleTap = function(event)
    {
      var listItemElementId = event.data["elementId"];
      var listItem = document.getElementById(listItemElementId);
      var exampleListElement = listItem.parentNode;
      var listItemAmxNode = event.data["itemAmxNode"];
      var exampleListAmxNode = listItemAmxNode.getParent();

      // Removed the old selected state (max 1 item should be selected at a time).
      // In the future we could consider an option to allow multiple selection.
      var oldSelection = _getChildrenByClassNames(exampleListElement, ["custom-exampleListItem-selected"])[0];

      if (oldSelection != null)
        _customRemoveCSSClassName(oldSelection, "custom-exampleListItem-selected");

      // Added a new style for the listItem that is tapped
      _customMarkRowAsSelected(listItem);

      var newSelectedRowKey = listItem.getAttribute("data-exampleListRk");

      _customStoreSelectedRowKey(exampleListAmxNode, newSelectedRowKey);

      adf.mf.api.amx.validate(listItem, function()
        {
          if (adf.mf.api.amx.acceptEvent())
          {
            var actionEvent = new adf.mf.api.amx.ActionEvent();
            adf.mf.api.amx.processAmxEvent(listItemAmxNode, "action", undefined, undefined, actionEvent, function()
              {
                var action = listItemAmxNode.getTag().getAttribute("action");
                if (action != null)
                {
                  adf.mf.api.amx.doNavigation(action);
                }
              });
          }
        });

      if (adf.mf.api.amx.acceptEvent())
      {
        var newValue = undefined;
        var amxNode = event.data["itemAmxNode"];

        if (amxNode != null)
        {
          newValue = amxNode.getStampKey();
        }

        var oldValue = exampleListAmxNode.getAttribute("_oldValue");
        var se = new adf.mf.api.amx.SelectionEvent(oldValue);

        adf.mf.api.amx.processAmxEvent(exampleListAmxNode, "selection", undefined, undefined, se);
        exampleListAmxNode.setAttributeResolvedValue("_oldValue", newValue);
      }
    };

    // --------------------------------------------------------------------------------------------------------
    // This section of code is for the custom:overflow tag seen on the Overflow page
    // General - Custom Component - Overflow
    // --------------------------------------------------------------------------------------------------------

    var overflow = adf.mf.api.amx.TypeHandler.register("http://xmlns.example.com/custom", "overflow");

    overflow.prototype.render = function(amxNode, id)
    {
      // This component can be used to limit a number of stamped children by setting the
      // "limit" attribute to for example 3. This means if there are 3 or fewer children,
      // then you'll see exactly that number of children. However, if there are more than
      // that limit then the limit minus one stamps will be rendered and instead the
      // content of the "more" facet will be rendered.
      // This facet should be used to show a popup where another instance of this
      // overflow component exists where instead of defining "limit" and the "more" facet,
      // you define the "start" attribute which should be set to match the "limit" value
      // of the original overflow instance. This allows you to make a popup menu of
      // "adfmf-commandButton-actionSheet" buttons for the items that didn't fit within
      // the original instance.
      // One example of where this might be useful in an accessoryLayout where space is
      // very limited (particularly on phones).
      var rootElement = document.createElement("div");
      try
      {
        rootElement.className = "custom-overflow";

        var limit = parseInt(_customEnsureValidString(amxNode.getAttribute("limit")), 10);
        if (isNaN(limit))
          limit = Number.MAX_VALUE;

        var start = parseInt(_customEnsureValidString(amxNode.getAttribute("start")), 10);
        if (isNaN(start))
          start = 1;
        start = Math.max(0, --start);

        // Add the children
        var descendants = amxNode.renderDescendants();
        var descendantCount = descendants.length;
        var limitedStampCount = Math.max(1, Math.min(limit, descendantCount));
        if (descendantCount > limit)
          --limitedStampCount; // subtract 1 to leave room for the "More" item
        for (var i = start; i < limitedStampCount; ++i)
        {
          var item = descendants[i];
          rootElement.appendChild(item);
        }

        // If there are any items being overflown then append the "more" content
        if (descendantCount > limit)
        {
          var facetChildren = amxNode.getRenderedChildren("more");
          if (facetChildren.length)
          {
            for (var i in facetChildren)
            {
              var facetChild = facetChildren[i].render();
              if (facetChild)
                rootElement.appendChild(facetChild);
            }
          }
        }
      }
      catch (problem)
      {
        rootElement.textContent = problem;
        adf.mf.log.Framework.logp(
          adf.mf.log.level.SEVERE,
          "revealer",
          "render",
          "Problem with overflow custom component creation: " + problem);
      }
      return rootElement;
    };

    // --------------------------------------------------------------------------------------------------------
    // This section of code is for the custom:resizable tag seen under Layout - Popup and also under General -
    // General - Custom Component - Resizable
    // --------------------------------------------------------------------------------------------------------

    var resizable = adf.mf.api.amx.TypeHandler.register("http://xmlns.example.com/custom", "resizable");

    resizable.prototype.render = function(amxNode, id)
    {
      var rootElement = document.createElement("div");
      try
      {
        rootElement.className = "custom-resizable";

        var start = _customEnsureValidString(amxNode.getAttribute("start"), "10");
        if (document.documentElement.dir == "rtl")
          rootElement.style.marginRight = start + "px";
        else
          rootElement.style.marginLeft = start + "px";
        var top = _customEnsureValidString(amxNode.getAttribute("top"), "10");
        rootElement.style.marginTop = top + "px";

        var textElement = document.createElement("div");
        textElement.className = "custom-resizable-text";
        var textId = id + "_txt";
        textElement.id = textId;
        rootElement.appendChild(textElement);
        adf.mf.api.amx.addDragListener(textElement,
          {
            "start": this._handleDragStart,
            "drag": this._handleDrag,
            "end": this._handleDragEnd
          },
          {
            "textId": textId,
            "dragId": textId
          });

        var width = _customEnsureValidString(amxNode.getAttribute("width"), "10");
        textElement.style.width = width + "px";
        var height = _customEnsureValidString(amxNode.getAttribute("height"), "10");
        textElement.style.height = height + "px";

        // Right now we only support 1 child, e.g. an outputText
        var descendants = amxNode.renderDescendants();
        for (var i=0, size=descendants.length; i<size; ++i)
        {
          var childDomNode = descendants[i];
          textElement.appendChild(childDomNode);
        }

        var tl = document.createElement("div");
        tl.className = "custom-resizable-tl";
        tl.id = id + "_tl";
        rootElement.appendChild(tl);
        adf.mf.api.amx.addDragListener(tl,
          {
            "start": this._handleDragStart,
            "drag": this._handleDrag,
            "end": this._handleDragEnd
          },
          {
            "textId": textId,
            "dragId": id + "_tl"
          });

        var tr = document.createElement("div");
        tr.className = "custom-resizable-tr";
        tr.id = id + "_tr";
        rootElement.appendChild(tr);
        adf.mf.api.amx.addDragListener(tr,
          {
            "start": this._handleDragStart,
            "drag": this._handleDrag,
            "end": this._handleDragEnd
          },
          {
            "textId": textId,
            "dragId": id + "_tr"
          });

        var bl = document.createElement("div");
        bl.className = "custom-resizable-bl";
        bl.id = id + "_bl";
        rootElement.appendChild(bl);
        adf.mf.api.amx.addDragListener(bl,
          {
            "start": this._handleDragStart,
            "drag": this._handleDrag,
            "end": this._handleDragEnd
          },
          {
            "textId": textId,
            "dragId": id + "_bl"
          });

        var br = document.createElement("div");
        br.className = "custom-resizable-br";
        br.id = id + "_br";
        rootElement.appendChild(br);
        adf.mf.api.amx.addDragListener(br,
          {
            "start": this._handleDragStart,
            "drag": this._handleDrag,
            "end": this._handleDragEnd
          },
          {
            "textId": textId,
            "dragId": id + "_br"
          });

      }
      catch (problem)
      {
        adf.mf.log.Framework.logp(
          adf.mf.log.level.SEVERE,
          "resizable",
          "render",
          "Problem with resizable custom component creation: " + problem);
      }
      return rootElement;
    };

    resizable.prototype.updateChildren = function(amxNode, attributeChanges)
    {
      var changedSize = attributeChanges.getSize();
      var changesWeCanHandle = 0;
      if (attributeChanges.hasChanged("start"))
        ++changesWeCanHandle;
      if (attributeChanges.hasChanged("top"))
        ++changesWeCanHandle;
      if (attributeChanges.hasChanged("width"))
        ++changesWeCanHandle;
      if (attributeChanges.hasChanged("height"))
        ++changesWeCanHandle;
      if (changesWeCanHandle == changedSize)
      {
        // Only stuff we know how to update easily have been changed:
        return adf.mf.api.amx.AmxNodeChangeResult["REFRESH"];
      }

      // Re-render from scratch:
      return adf.mf.api.amx.AmxNodeChangeResult["RERENDER"];
    };

    resizable.prototype.refresh = function(amxNode, attributeChanges)
    {
      var rootElement = document.getElementById(amxNode.getId());

      if (attributeChanges.hasChanged("start"))
      {
        var start = _customEnsureValidString(amxNode.getAttribute("start"), "10");
        if (document.documentElement.dir == "rtl")
          rootElement.style.marginRight = start + "px";
        else
          rootElement.style.marginLeft = start + "px";
      }

      if (attributeChanges.hasChanged("top"))
      {
        var top = _customEnsureValidString(amxNode.getAttribute("top"), "10");
        rootElement.style.marginTop = top + "px";
      }

      var textElement = rootElement.firstChild;

      if (attributeChanges.hasChanged("width"))
      {
        var width = _customEnsureValidString(amxNode.getAttribute("width"), "10");
        textElement.style.width = width + "px";
      }

      if (attributeChanges.hasChanged("height"))
      {
        var height = _customEnsureValidString(amxNode.getAttribute("height"), "10");
        textElement.style.height = height + "px";
      }
    };

    resizable.prototype._handleDragStart = function(event, dragExtra)
    {
      var dragId = event.data["dragId"];
      var dragElement = document.getElementById(dragId);

      // Declare this element as the one that is currently handling drag events:
      dragExtra.requestDragLock(dragElement, true, true);
      event.preventDefault();
      event.stopPropagation();
      dragExtra.preventDefault = true;
      dragExtra.stopPropagation = true;

      _customAddCSSClassName(dragElement, "custom-resizable-dragging");
    };

    resizable.prototype._handleDrag = function(event, dragExtra)
    {
      event.preventDefault();
      event.stopPropagation();
      dragExtra.preventDefault = true;
      dragExtra.stopPropagation = true;

      var textId = event.data["textId"];
      var textElement = document.getElementById(textId);
      var rootElement = textElement.parentNode;

      var dragId = event.data["dragId"];
      var lastUnderscore = dragId.lastIndexOf("_");
      var dragType = dragId.substring(lastUnderscore+1);
      var isRtl = (document.documentElement.dir == "rtl");
      var deltaPageX = dragExtra["deltaPageX"];
      var deltaPageY = dragExtra["deltaPageY"];
      var minSize = 15;
      resizeInvolved = true;

      // Move and/or resize text element:
      switch (dragType)
      {
        case "txt":
          resizeInvolved = false;
          if (deltaPageX != 0)
          {
            if (isRtl)
              rootElement.style.marginRight = parseInt(rootElement.style.marginRight, 10) - deltaPageX + "px";
            else
              rootElement.style.marginLeft = parseInt(rootElement.style.marginLeft, 10) + deltaPageX + "px";
          }
          if (deltaPageY != 0)
            rootElement.style.marginTop = parseInt(rootElement.style.marginTop, 10) + deltaPageY + "px";
          break;
        case "tl":
          if (deltaPageX != 0)
          {
            if (isRtl)
            {
              var widthDelta = Math.max(minSize, parseInt(textElement.style.width, 10) - deltaPageX);
              if (widthDelta == minSize)
              {
                rootElement.style.marginRight = parseInt(rootElement.style.marginRight, 10) - deltaPageX + "px";
                textElement.style.width = minSize + "px";
              }
              else
              {
                textElement.style.width = widthDelta + "px";
              }
            }
            else
            {
              rootElement.style.marginLeft = parseInt(rootElement.style.marginLeft, 10) + deltaPageX + "px";
              textElement.style.width = Math.max(minSize, parseInt(textElement.style.width, 10) - deltaPageX) + "px";
            }
          }
          if (deltaPageY != 0)
          {
            rootElement.style.marginTop = parseInt(rootElement.style.marginTop, 10) + deltaPageY + "px";
            textElement.style.height = Math.max(minSize, parseInt(textElement.style.height, 10) - deltaPageY) + "px";
          }
          break;
        case "tr":
          if (deltaPageX != 0)
          {
            if (isRtl)
            {
              rootElement.style.marginRight = parseInt(rootElement.style.marginRight, 10) - deltaPageX + "px";
              textElement.style.width = Math.max(minSize, parseInt(textElement.style.width, 10) + deltaPageX) + "px";
            }
            else
            {
              var widthDelta = Math.max(minSize, parseInt(textElement.style.width, 10) + deltaPageX);
              if (widthDelta == minSize)
              {
                rootElement.style.marginLeft = parseInt(rootElement.style.marginLeft, 10) + deltaPageX + "px";
                textElement.style.width = minSize + "px";
              }
              else
              {
                textElement.style.width = widthDelta + "px";
              }
            }
          }
          if (deltaPageY != 0)
          {
            rootElement.style.marginTop = parseInt(rootElement.style.marginTop, 10) + deltaPageY + "px";
            textElement.style.height = Math.max(minSize, parseInt(textElement.style.height, 10) - deltaPageY) + "px";
          }
          break;
        case "bl":
          if (deltaPageX != 0)
          {
            if (isRtl)
            {
              var widthDelta = Math.max(minSize, parseInt(textElement.style.width, 10) - deltaPageX);
              if (widthDelta == minSize)
              {
                rootElement.style.marginRight = parseInt(rootElement.style.marginRight, 10) - deltaPageX + "px";
                textElement.style.width = minSize + "px";
              }
              else
              {
                textElement.style.width = widthDelta + "px";
              }
            }
            else
            {
              rootElement.style.marginLeft = parseInt(rootElement.style.marginLeft, 10) + deltaPageX + "px";
              textElement.style.width = Math.max(minSize, parseInt(textElement.style.width, 10) - deltaPageX) + "px";
            }
          }
          if (deltaPageY != 0)
          {
            var heightDelta = Math.max(minSize, parseInt(textElement.style.height, 10) + deltaPageY);
            if (heightDelta == minSize)
            {
              rootElement.style.marginTop = parseInt(rootElement.style.marginTop, 10) + deltaPageY + "px";
              textElement.style.height = minSize + "px";
            }
            else
            {
              textElement.style.height = heightDelta + "px";
            }
          }
          break;
        case "br":
          if (deltaPageX != 0)
          {
            if (isRtl)
            {
              rootElement.style.marginRight = parseInt(rootElement.style.marginRight, 10) - deltaPageX + "px";
              textElement.style.width = Math.max(minSize, parseInt(textElement.style.width, 10) + deltaPageX) + "px";
            }
            else
            {
              var widthDelta = Math.max(minSize, parseInt(textElement.style.width, 10) + deltaPageX);
              if (widthDelta == minSize)
              {
                rootElement.style.marginLeft = parseInt(rootElement.style.marginLeft, 10) + deltaPageX + "px";
                textElement.style.width = minSize + "px";
              }
              else
              {
                textElement.style.width = widthDelta + "px";
              }
            }
          }
          if (deltaPageY != 0)
          {
            var heightDelta = Math.max(minSize, parseInt(textElement.style.height, 10) + deltaPageY);
            if (heightDelta == minSize)
            {
              rootElement.style.marginTop = parseInt(rootElement.style.marginTop, 10) + deltaPageY + "px";
              textElement.style.height = minSize + "px";
            }
            else
            {
              textElement.style.height = heightDelta + "px";
            }
          }
          break;
      }

      if (resizeInvolved)
      {
        var textChildren = textElement.childNodes;
        if (textChildren && textChildren.length == 1)
          adf.mf.api.amx.triggerBubbleEventListener(textChildren[0], "resize");
      }
    };

    resizable.prototype._handleDragEnd = function(event, dragExtra)
    {
      event.preventDefault();
      event.stopPropagation();
      dragExtra.preventDefault = true;
      dragExtra.stopPropagation = true;

      var dragId = event.data["dragId"];
      var dragElement = document.getElementById(dragId);
      _customRemoveCSSClassName(dragElement, "custom-resizable-dragging");
    };

    // --------------------------------------------------------------------------------------------------------
    // This section of code is for the things shared among the custom components.
    // --------------------------------------------------------------------------------------------------------

    /**
     * Retrieves the raw value or the default value if the raw value is null or undefined.
     * @param {Object} rawValue the raw value
     * @param {Object} defaultValue the alternative if rawValue is null or undefined
     * @return {Object} the rawValue or if it is null or undefined, the defaultValue is returned.
     */
    function _customEnsureValidString(rawValue, defaultValue)
    {
      if (rawValue == null)
        return defaultValue;
      return rawValue;
    };

    /**
     * Determine whether the parameter is a finite number.
     * @param {Object} n is the object to check
     * @return {Boolean} whether the given object is a finite number
     */
    function _customIsFiniteNumber(n)
    {
      return !isNaN(parseFloat(n)) && isFinite(n);
    }

    /**
     * Stores the rowKey of the selected list item.
     * @param {Object} amxNode the amxNode for this exampleList instance
     * @param {String} selectedRowKey null or the rowKey
     */
    function _customStoreSelectedRowKey(amxNode, selectedRowKey)
    {
      var storedData = amxNode.getVolatileState();
      if (storedData == null)
      {
        storedData = {};
      }
      storedData.selectedRowKey = selectedRowKey;
      amxNode.setVolatileState(storedData);
    }

    /**
     * Retrieves null or the rowKey of the selected list item.
     * @param {Object} amxNode the amxNode for this exampleList instance
     * @return {String} null or the rowKey
     */
    function _customGetSelectedRowKey(amxNode)
    {
      var storedData = amxNode.getVolatileState();
      if (storedData != null)
      {
        return storedData.selectedRowKey;
      }
      return null;
    }

    /**
     * Adds the marker class to the specified listItem element to make it selected.
     * @param {Object} listItemElement the list item element that should be selected
     */
    function _customMarkRowAsSelected(listItemElement)
    {
      _customAddCSSClassName(listItemElement, "custom-exampleListItem-selected");
    }

    /**
     * Adds a CSS className to the dom node if it doesn't already exist in the classNames list and
     * returns <code>true</code> if the class name was added.
     * @param {HTMLElement} domElement DOM Element to add style class name to
     * @param {String:null} className Name of style class to add
     * @return {Boolean} <code>true</code> if the style class was added
     */
    function _customAddCSSClassName(domElement, className)
    {
      var added = false;

      if (className != null)
      {
        var currentClassName = domElement.className;

        // get the current location of the className to add in the classNames list
        var classNameIndex = _customGetCSSClassNameIndex(currentClassName, className);

        // the className doesn't exist so add it
        if (classNameIndex == -1)
        {
          var newClassName = (currentClassName)
                                   ? className + " " + currentClassName
                                   : className;

          domElement.className = newClassName;

          added = true;
        }
      }

      return added;
    }

    /**
     * Removes a CSS className to the dom node if it existd in the classNames list and
     * returns <code>true</code> if the class name was removed.
     * @param {HTMLElement} domElement DOM Element to remove style class name from
     * @param {String:null} className Name of style class to remove
     * @return {Boolean} <code>true</code> if the style class was removed
     */
    function _customRemoveCSSClassName(domElement, className)
    {
      var removed = false;

      if (className != null)
      {
        var currentClassName = domElement.className;

        var classNameIndex = _customGetCSSClassNameIndex(currentClassName, className);

        // only need to do work if CSS class name is present
        if (classNameIndex != -1)
        {
          var classNameEndIndex = classNameIndex + className.length;

          // the new classNames string is the string before our className and leading whitespace plus
          // the string after our className and trailing whitespace
          var beforeString = (classNameIndex == 0)
                               ? null
                               : currentClassName.substring(0, classNameIndex);
          var afterString =  (classNameEndIndex == currentClassName.length)
                               ? null
                               : currentClassName.substring(classNameEndIndex + 1); // skip space

          var newClassName;

          if (beforeString == null)
          {
            if (afterString == null)
            {
              newClassName = "";
            }
            else
            {
              newClassName = afterString;
            }
          }
          else
          {
            if (afterString == null)
            {
              newClassName = beforeString;
            }
            else
            {
              newClassName = beforeString + afterString;
            }
          }

          domElement.className = newClassName;

          removed = true;
        }
      }

      return removed;
    }

    /**
     * Returns the index at which <code>className</code> appears within <code>currentClassName</code>
     * with either a space or the beginning or end of <code>currentClassName</code> on either side.
     * This function optimizes the runtime speed by not creating objects in most cases and assuming
     * 1) It is OK to only check for spaces as whitespace characters
     * 2) It is rare for the searched className to be a substring of another className, therefore
     *    if we get a hit on indexOf, we have almost certainly found our className
     * 3) It is even rarer for the searched className to be a substring of more than one className,
     *    therefore, repeating the search from the end of the string should almost always either return
     *    our className or the original search hit from indexOf
     * @param {String} currentClassName Space-separated class name string to search
     * @param {String} className String to search for within currentClassName
     * @return {Number} index of className in currentClassName, or -1 if it doesn't exist
     */
    function _customGetCSSClassNameIndex(currentClassName, className)
    {
      // if no current class
      if (!currentClassName)
        return -1;
      else
      {
        // if the strings are equivalent, then the start index is the beginning of the string
        if (className === currentClassName)
          return 0;
        else
        {
          var classNameLength = className.length;
          var currentClassNameLength = currentClassName.length;

          // check if our substring exists in the string at all
          var nameIndex = currentClassName.indexOf(className);

          // if our substring exists then our class exists if either:
          // 1) It is at the beginning of the classNames String and has a following space
          // 2) It is at the end of the classNames String and has a leading space
          // 3) It has a space on either side
          if (nameIndex >= 0)
          {
            var hasStart = (nameIndex == 0) || (currentClassName.charAt(nameIndex - 1) == " ");
            var endIndex = nameIndex + classNameLength;
            var hasEnd = (endIndex == currentClassNameLength) || (currentClassName.charAt(endIndex) == " ");

            //one of the three condition above has been met so our string is in the parent string
            if (hasStart && hasEnd)
              return nameIndex;
            else
            {
              // our substring exists in the parent string but didn't meet the above conditions,  Were
              // going to be lazy and retest, searchig for our substring from the back of the classNames
              // string
              var lastNameIndex = currentClassName.lastIndexOf(className);

              // if we got the same index as the search from the beginning then we aren't in here
              if (lastNameIndex != nameIndex)
              {
                // recheck the three match cases
                hasStart = currentClassName.charAt(lastNameIndex - 1);
                endIndex = lastNameIndex + classNameLength;
                hasEnd =  (endIndex == currentClassNameLength) || (currentClassName.charAt(endIndex) == " ");

                if (hasStart && hasEnd)
                  return lastNameIndex;
                else
                {
                  // this should only happen if the searched for className is a substring of more
                  // than one className in the classNames list, so it is OK for this to be slow.  We
                  // also know at this point that we definitely didn't get a match at either the very
                  // beginning or very end of the classNames string, so we can safely append spaces
                  // at either end
                  return currentClassName.indexOf(" " + className + " ");
                }
              }
            }
          }

          // no match
          return -1;
        }
      }
    }

    /**
     * Get the child elements that have the specified class names.
     * @param {HTMLElement} parentElement the element whose children will be traversed
     * @param {Array<String>} classNames the class names to search for
     * @return {Array} an array of found elements whose entries match the specified classNames order
     */
    function _getChildrenByClassNames(parentElement, classNames)
    {
      var childNodes = parentElement.childNodes;
      var childNodeCount = childNodes.length;
      var classNameCount = classNames.length;
      var foundChildren = [];
      var foundCount = 0;
      for (var i=0; i<childNodeCount && foundCount<classNameCount; ++i)
      {
        var child = childNodes[i];
        for (var j=0; j<classNameCount; ++j)
        {
          if (_customGetCSSClassNameIndex(child.className, classNames[j]) != -1)
          {
            foundChildren[j] = child;
            ++foundCount;
            break; // done with this specific child
          }
        }
      }
      return foundChildren;
    }

    // --------------------------------------------------------------------------------------------------------
    // This section of code is for handling a special build of this app that is hosted on OTN
    // for use in web browsers. It is not used when this app deployed as a MAF application.
    // --------------------------------------------------------------------------------------------------------

    /**
     * When in hosted mode, this script assists with its special springboard.
     */
    window.customHandleMockSpringboard = function(featureName)
    {
      var href = window.location.href;
      href = href.replace(/(=About)|(=Gallery)/g, "="+featureName);
      var bookmarkParamEquals = href.indexOf("&p=");
      if (bookmarkParamEquals != -1)
      {
        lastAnd = href.lastIndexOf("&");
        if (lastAnd == bookmarkParamEquals)
          href = href.substring(0, bookmarkParamEquals); // simple trim
        else // need to preserve the last section
          href = href.substring(0, bookmarkParamEquals) + href.substring(lastAnd);
      }
      http://localhost/MyWork/maf/trunk/QA/built/hosted/CompGalleryDemo/bootstrap.html?file=Gallery/task-flow.xml%23task-flow&featureRoot=./&feature=Gallery&p=textselect/selectBooleanCheckbox&amx_skin_override=css/amx-mobileFusionFx-1.1.css
      window.location.href = href;
    };

    // --------------------------------------------------------------------------------------------------------
  }
  catch (problem)
  {
    adf.mf.log.Framework.logp(
      adf.mf.log.level.SEVERE,
      "custom.js",
      "*",
      "Problem with custom code: " + problem);
  }

})();