package application;

import java.util.Objects;

import javax.el.ValueExpression;

import oracle.adfmf.amx.event.ActionEvent;
import oracle.adfmf.framework.api.AdfmfContainerUtilities;
import oracle.adfmf.framework.api.AdfmfJavaUtilities;
import oracle.adfmf.framework.api.AdfmfSlidingWindowOptions;
import oracle.adfmf.framework.api.AdfmfSlidingWindowUtilities;
import oracle.adfmf.java.beans.PropertyChangeListener;
import oracle.adfmf.java.beans.PropertyChangeSupport;

/**
 * Application scoped bean that handles the showing and window sizing of the sliding window drawer for examples.amx
 * as well as the remote URL feature with controlBar.amx.
 */
public class SlidingDrawerBean
{
  private enum Platform
  {
    IOS,
    ANDROID,
    OTHER
  }

  public SlidingDrawerBean()
  {
  }

  public boolean isShowTopAndBottomFacets()
  {
    return _showTopAndBottomFacets;
  }

  public void addPropertyChangeListener(PropertyChangeListener l)
  {
    _propertyChangeSupport.addPropertyChangeListener(l);
  }

  public void removePropertyChangeListener(PropertyChangeListener l)
  {
    _propertyChangeSupport.removePropertyChangeListener(l);
  }

  public void leftOverlay(@SuppressWarnings("unused") ActionEvent actionEvent)
  {
    _setShowTopAndBottomFacets(false);
    _slidingDrawerWindowSize = _getSlidingDrawerWindowSize();
    _setWindowOptions(AdfmfSlidingWindowOptions.DIRECTION_LEFT, AdfmfSlidingWindowOptions.STYLE_OVERLAID,
      _slidingDrawerWindowSize);
  }

  public void rightOverlay(@SuppressWarnings("unused") ActionEvent actionEvent)
  {
    _setShowTopAndBottomFacets(false);
    _slidingDrawerWindowSize = _getSlidingDrawerWindowSize();
    _setWindowOptions(AdfmfSlidingWindowOptions.DIRECTION_RIGHT, AdfmfSlidingWindowOptions.STYLE_OVERLAID,
      _slidingDrawerWindowSize);
  }

  public void topOverlay(@SuppressWarnings("unused") ActionEvent actionEvent)
  {
    _setShowTopAndBottomFacets(true);
    _slidingDrawerWindowSize = _getSlidingDrawerWindowSize();
    _setWindowOptions(AdfmfSlidingWindowOptions.DIRECTION_TOP, AdfmfSlidingWindowOptions.STYLE_OVERLAID,
      _slidingDrawerWindowSize);
  }

  public void bottomOverlay(@SuppressWarnings("unused") ActionEvent actionEvent)
  {
    _setShowTopAndBottomFacets(true);
    _slidingDrawerWindowSize = _getSlidingDrawerWindowSize();
    _setWindowOptions(AdfmfSlidingWindowOptions.DIRECTION_BOTTOM, AdfmfSlidingWindowOptions.STYLE_OVERLAID,
      _slidingDrawerWindowSize);
  }

  public void leftPin(@SuppressWarnings("unused") ActionEvent actionEvent)
  {
    _setShowTopAndBottomFacets(false);
    _slidingDrawerWindowSize = _getSlidingDrawerWindowSize();
    _setWindowOptions(AdfmfSlidingWindowOptions.DIRECTION_LEFT, AdfmfSlidingWindowOptions.STYLE_PINNED,
      _slidingDrawerWindowSize);
  }

  public void rightPin(@SuppressWarnings("unused") ActionEvent actionEvent)
  {
    _setShowTopAndBottomFacets(false);
    _slidingDrawerWindowSize = _getSlidingDrawerWindowSize();
    _setWindowOptions(AdfmfSlidingWindowOptions.DIRECTION_RIGHT, AdfmfSlidingWindowOptions.STYLE_PINNED,
      _slidingDrawerWindowSize);
  }

  public void topPin(@SuppressWarnings("unused") ActionEvent actionEvent)
  {
    _slidingDrawerWindowSize = _getSlidingDrawerWindowSize();
    _setWindowOptions(AdfmfSlidingWindowOptions.DIRECTION_TOP, AdfmfSlidingWindowOptions.STYLE_PINNED,
      _slidingDrawerWindowSize);
    _setShowTopAndBottomFacets(true);
  }

  public void bottomPin(@SuppressWarnings("unused") ActionEvent actionEvent)
  {
    _slidingDrawerWindowSize = _getSlidingDrawerWindowSize();
    _setWindowOptions(AdfmfSlidingWindowOptions.DIRECTION_BOTTOM, AdfmfSlidingWindowOptions.STYLE_PINNED,
      _slidingDrawerWindowSize);
    _setShowTopAndBottomFacets(true);
  }

  /**
   * Called
   * @param controlBarHeight
   */
  public void resizeRemoteUrlWindows(int controlBarHeight)
  {
    _controlBarHeight = controlBarHeight;

    if (_getPlatform() == Platform.ANDROID)
    {
      _controlBarHeight *= _getDeviceScaleFactor();
    }

    if (_remoteURLShown)
    {
      _setRemoteUrlSizes();
    }
  }

  public void hideWindow(@SuppressWarnings("unused") ActionEvent actionEvent)
  {
    _hideSlidingWindow();
  }

  public void gotoExamplesFeature(@SuppressWarnings("unused") ActionEvent actionEvent)
  {
    _hideSlidingWindow();
    _closeRemoteUrl();
    AdfmfContainerUtilities.gotoFeature("Examples");
  }

  public void gotoAboutFeature(@SuppressWarnings("unused") ActionEvent actionEvent)
  {
    _hideSlidingWindow();
    _closeRemoteUrl();
    AdfmfContainerUtilities.gotoFeature("About");
  }

  public void launchRemoteURL(@SuppressWarnings("unused") ActionEvent actionEvent)
  {
    try
    {
      _hideSlidingWindow();
      _calculateDefaultControlBarHeight();

      if (_controlFeatureWindowId == null)
      {
        _controlFeatureWindowId = AdfmfSlidingWindowUtilities.create("controlBar");
      }

      if (_remoteFeatureWindowId == null)
      {
        _remoteFeatureWindowId = AdfmfSlidingWindowUtilities.create("RemoteURL");
      }

      _setRemoteUrlSizes();
      _remoteURLShown = true;
    }
    catch (Exception ex)
    {
      ex.printStackTrace();
    }
  }

  public void closeRemoteURL(@SuppressWarnings("unused") ActionEvent actionEvent)
  {
    _closeRemoteUrl();
  }

  private void _closeRemoteUrl()
  {
    if (_remoteURLShown)
    {
      AdfmfSlidingWindowUtilities.destroy(_remoteFeatureWindowId);
      _remoteFeatureWindowId = null;
      AdfmfSlidingWindowUtilities.hide(_controlFeatureWindowId);
      _remoteURLShown = false;
    }
  }

  private void _setWindowOptions(String windowDirection, String windowStyle, int windowSize)
  {
    try
    {
      _closeRemoteUrl();

      AdfmfSlidingWindowOptions windowOptions = new AdfmfSlidingWindowOptions();
      windowOptions.setDirection(windowDirection);
      windowOptions.setStyle(windowStyle);
      windowOptions.setSize(Integer.toString(windowSize));

      if (_slidingDrawerWindow == null)
      {
        _slidingDrawerWindow = AdfmfSlidingWindowUtilities.create("SlidingDrawer");
      }

      AdfmfSlidingWindowUtilities.show(_slidingDrawerWindow, windowOptions);
      _slidingDrawerShown = true;
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }

  private void _hideSlidingWindow()
  {
    if (_slidingDrawerShown)
    {
      _slidingDrawerShown = false;
      AdfmfSlidingWindowUtilities.hide(_slidingDrawerWindow);
    }
  }

  private boolean _isOrientationPortrait()
  {
    ValueExpression ve = AdfmfJavaUtilities.getValueExpression(
      "#{deviceScope.hardware.screen.width lt deviceScope.hardware.screen.height}", Boolean.class);
    return (Boolean)ve.getValue(AdfmfJavaUtilities.getELContext());
  }

  /**
   * Method used for the initial control bar height. The value will be overidden by the JavaScript in controlBar.js
   * with the actual value calculated from the HTML
   */
  private void _calculateDefaultControlBarHeight()
  {
    switch (_getPlatform())
    {
      case IOS:
        // Check if the device is in landscape or portrait mode
        _controlBarHeight = _isOrientationPortrait() ? 64 : 54;
        break;

      case ANDROID:
        int scaleFactor = _getDeviceScaleFactor();

        _controlBarHeight = 56 * scaleFactor;
        break;
    }
  }

  private void _setRemoteUrlSizes()
  {
    int availableHeight = _getDeviceAvailableHeight();

    if (_getPlatform() == Platform.ANDROID)
    {
      availableHeight *= _getDeviceScaleFactor();
    }

    int remoteFeatureHeight = availableHeight - _controlBarHeight;

    // Show the features
    AdfmfSlidingWindowOptions remoteOptions = new AdfmfSlidingWindowOptions();
    remoteOptions.setDirection(AdfmfSlidingWindowOptions.DIRECTION_BOTTOM);
    // Use overlaid, not pinned as pinned will affect the available height calculations
    remoteOptions.setStyle(AdfmfSlidingWindowOptions.STYLE_OVERLAID);
    remoteOptions.setSize(Integer.toString(remoteFeatureHeight));
    AdfmfSlidingWindowUtilities.show(_remoteFeatureWindowId, remoteOptions);

    AdfmfSlidingWindowOptions controlOptions = new AdfmfSlidingWindowOptions();
    controlOptions.setDirection(AdfmfSlidingWindowOptions.DIRECTION_TOP);
    controlOptions.setStyle(AdfmfSlidingWindowOptions.STYLE_OVERLAID);
    controlOptions.setSize(Integer.toString(_controlBarHeight));
    AdfmfSlidingWindowUtilities.show(_controlFeatureWindowId, controlOptions);
  }

  private Platform _getPlatform()
  {
    if (_platform == null)
    {
      ValueExpression ve = AdfmfJavaUtilities.getValueExpression("#{deviceScope.device.os}", String.class);
      String deviceOS = (String) ve.getValue(AdfmfJavaUtilities.getELContext());

      if (Objects.equals(deviceOS, "iOS"))
      {
        _platform = Platform.IOS;
      }
      else if (Objects.equals(deviceOS, "Android"))
      {
        _platform = Platform.ANDROID;
      }
      else
      {
        _platform = Platform.OTHER;
      }
    }

    return _platform;
  }

  private int _getDeviceScaleFactor()
  {
    if (_scaleFactor == -1)
    {
      ValueExpression ve =
        AdfmfJavaUtilities.getValueExpression("#{deviceScope.hardware.screen.scaleFactor}", Float.class);
      Float scaleFactorFloat = (Float)ve.getValue(AdfmfJavaUtilities.getELContext());

      _scaleFactor = Math.round(scaleFactorFloat);
    }

    return _scaleFactor;
  }

  private Integer _getDeviceAvailableHeight()
  {
    ValueExpression ve =
      AdfmfJavaUtilities.getValueExpression("#{deviceScope.hardware.screen.availableHeight}", Integer.class);
    Integer deviceAvailableHeight = (Integer)ve.getValue(AdfmfJavaUtilities.getELContext());

    return deviceAvailableHeight;
  }

  private int _getSlidingDrawerWindowSize()
  {
    switch (_getPlatform())
    {
      case IOS:
        _slidingDrawerWindowSize = _isOrientationPortrait() ? 64 : 44;
        break;

      case ANDROID:
        int scaleFactor = _getDeviceScaleFactor();

        _slidingDrawerWindowSize = scaleFactor <= 2 ? 126 : 252;
        break;
    }

    return _slidingDrawerWindowSize;
  }

  private void _setShowTopAndBottomFacets(boolean showTopAndBottomFacets)
  {
    boolean oldShowTopAndBottomFacets = this._showTopAndBottomFacets;

    this._showTopAndBottomFacets = showTopAndBottomFacets;
    _propertyChangeSupport.firePropertyChange("showTopAndBottomFacets", oldShowTopAndBottomFacets,
      showTopAndBottomFacets);
  }

  private int _slidingDrawerWindowSize = 0;
  private PropertyChangeSupport _propertyChangeSupport = new PropertyChangeSupport(this);
  private String _remoteFeatureWindowId = null;
  private String _controlFeatureWindowId = null;
  private String _slidingDrawerWindow;
  private boolean _slidingDrawerShown;
  private boolean _showTopAndBottomFacets;
  private boolean _remoteURLShown = false;
  private int _controlBarHeight = 0;
  private Platform _platform = null;
  private int _scaleFactor = -1;
}
