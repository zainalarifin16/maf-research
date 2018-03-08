(function() {

  // Our region identifiers
  var uuid = "0AC59CA4-DFA6-442C-8C65-22247851344C";
  var major = 1;
  var minor = 100;

  function initialise() {
    // This is required because we only want to initialise the plugin's native code once
    cordova.plugins.locationManager.initialize();
    
    // Create and setup the delegate
    var delegate = new cordova.plugins.locationManager.Delegate();

    // Event when advertising starts (there may be a short delay after the request)
    delegate.peripheralManagerDidStartAdvertising = function(pluginResult) {
      console.log('StartAdvertising: ' + JSON.stringify(pluginResult.region));
    };

    // Event when bluetooth transmission state changes 
    delegate.peripheralManagerDidUpdateState = function(pluginResult) {
      console.log('UpdateState: ' + JSON.stringify(pluginResult.region));
    };

    // Set delegate
    cordova.plugins.locationManager.setDelegate(delegate);

    // Set initial beacon identifiers in EL
    adf.mf.api.setValue({"name": "#{applicationScope.uuid}", "value": uuid}, function() {}, function() {});
    adf.mf.api.setValue({"name": "#{applicationScope.major}", "value": major}, function() {}, function() {});
    adf.mf.api.setValue({"name": "#{applicationScope.minor}", "value": minor}, function() {}, function() {});
  }

  function createRegion() {
    // Read the values input by the user
    adf.mf.el.getValue("#{applicationScope.major}", function(req, res) { major = res[0]['value'] }, function() {});
    adf.mf.el.getValue("#{applicationScope.minor}", function(req, res) { minor = res[0]['value'] }, function() {});
    return new cordova.plugins.locationManager.BeaconRegion("FakeBeacon", uuid, major, minor);
  }

  // Callable externally
  startAdvertising = function() {
    // Verify the platform supports transmitting as a beacon
    cordova.plugins.locationManager.isAdvertisingAvailable().then(function(isSupported) {
      if (isSupported) {
        cordova.plugins.locationManager.startAdvertising(createRegion()).fail(console.error).done();
      } else {
        alert("Advertising not supported");
      }
    }).fail(console.error).done();
  }

  // Callable externally
  stopAdvertising = function() {
    cordova.plugins.locationManager.stopAdvertising().fail(console.error).done();
  }

  document.addEventListener("showpagecomplete", initialise, false);

}) ();