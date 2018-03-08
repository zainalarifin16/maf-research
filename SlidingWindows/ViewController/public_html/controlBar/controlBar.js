(function()
{
  /**
   * No operation function
   */
  function noOp() {}

  function resizeWindows(offsetValue)
  {
    try
    {
      var headerHeight = document.querySelector(".amx-panelPage-header").offsetHeight;

      // Call to resize the height of the sliding window using headerHeight
      adf.mf.api.amx.invokeEl("#{SlidingDrawerBean.resizeRemoteUrlWindows}", [ headerHeight ], null, [ "int" ],
        noOp, noOp);
    }
    catch (problem)
    {
      alert("Problem with controlBar.amx script: " + problem);
    }
  }

  // If the control bar height should not be calculated in the bean, but instead driven from the actual HTML size,
  // uncomment this:
  adf.mf.api.amx.addBubbleEventListener(window, "mafcontentoffsettop", resizeWindows);
  adf.mf.api.amx.addBubbleEventListener(document, "showpagecomplete", resizeWindows);
  adf.mf.api.amx.addBubbleEventListener(document, "mafviewvisible", resizeWindows);

  if (/Android/.test(window.navigator.userAgent))
  {
    // For Android, the window will be resized after the orientation change event:
    var orientationChanged = false;

    adf.mf.api.amx.addBubbleEventListener(
      window,
      "orientationchange",
      function ()
      {
        orientationChanged = true;
      });

    adf.mf.api.amx.addBubbleEventListener(
      window,
      "resize",
      function ()
      {
        if (orientationChanged)
        {
          orientationChanged = false;
          resizeWindows(0);
        }
      });
  }
  else
  {
    // For iOS, resize the windows right after the orientation change, but on a small delay for the window to resize
    // and the container to update the screen
    adf.mf.api.amx.addBubbleEventListener(
      window,
      "orientationchange",
      function ()
      {
        window.setTimeout(
          function ()
          {
            resizeWindows(0);
          },
          100);
      });
  }
})();