(function () {

    function initialise() {
        // Nothing to initialise
    }
    
    function onSuccess(result) {
        adf.mf.api.setValue( { "name": "#{viewScope.BarcodeBean.barcodeError}", 
                               "value": ""}, 
                               function() {}, 
                               function() {});

        adf.mf.api.setValue( { "name": "#{viewScope.BarcodeBean.barcodeResult}", 
                               "value": result.text}, 
                               function() {}, 
                               function() {});

        adf.mf.api.setValue( { "name": "#{viewScope.BarcodeBean.barcodeFormat}", 
                               "value": result.format}, 
                               function() {}, 
                               function() {});

        adf.mf.api.setValue( { "name": "#{viewScope.BarcodeBean.barcodeCancelled}", 
                               "value": result.cancelled == 1 ? "Yes" : "No"}, 
                               function() {}, 
                               function() {});
    }
    
    function onError(error) {
        adf.mf.api.setValue( { "name": "#{viewScope.BarcodeBean.barcodeError}", 
                               "value": "ERROR: " + error.text}, 
                               function() {}, 
                               function() {});
    }
    
    // Callable externally
    scanBarcodeFromJavaBean = function() {
        cordova.plugins.barcodeScanner.scan(onSuccess, onError);
    }

    document.addEventListener("showpagecomplete", initialise, false);
    
}) ();