(function () {

    // This method shows you how to use variable args and prints out the results
    doAlert = function () {
        var args = arguments;

        var str = "doAlert, argCount:" + args.length + ", arguments:";

        for (x = 0;x < args.length;x++) {
            if (x > 0) {
                str += ", ";
            }
            str += arguments[x];
        }

        adf.mf.api.setValue( { "name": "#{applicationScope.alertMessage}", 
                                           "value": str}, 
                                           onAlertMessageSuccess, 
                                           onAlertFail()); 
    };
    
    function onAlertMessageSuccess(){
    
    };
    
    function onAlertFail(){
    
    };
    

    // This method uses PhoneGap and calls the getPicture method to get a picture from the photo library
    fetchPic = function () {
        navigator.camera.getPicture(onSuccess, onFail,{quality : 50, destinationType : navigator.camera.DestinationType.FILE_URI, sourceType : navigator.camera.PictureSourceType.PHOTOLIBRARY});
    };

    // Once a valid picture returns, it calls back to java with the result
    function onSuccess(URI) {
        adf.mf.api.invokeMethod("mobile.ManagedBean", "FetchCallback", URI, onInvokeSuccess, onFail);
    };

    function onFail() {
        adf.mf.api.setValue( { "name": "#{applicationScope.alertMessage}", 
                                           "value": "No photo selected"}, 
                                           onAlertMessageSuccess, 
                                           onAlertFail()); 
    };
    

    function onInvokeSuccess(param) {
    };

    // This method uses PhoneGap and calls the getPicture method to get a picture from the photo library
    fetchVideo = function () {
        navigator.device.capture.captureVideo(captureSuccess, captureFail, {limit : 1});
    };

    function captureSuccess(mediaFiles) {
        var i, len;
        for (i=0, len=mediaFiles.length; i<len; i++) {
            adf.mf.api.invokeMethod("mobile.ManagedBean", "FetchCallback", mediaFiles[i].fullPath, onInvokeSuccess, onFail);
        }
    };

    function captureFail() {
        adf.mf.api.setValue( { "name": "#{applicationScope.alertMessage}", 
                                           "value": "No video captured.  Note: This is not supported on the simulator"}, 
                                           onAlertMessageSuccess, 
                                           onAlertFail()); 
    };


})();