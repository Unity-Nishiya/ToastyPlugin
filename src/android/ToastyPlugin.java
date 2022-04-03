package com.stanleyidesis.cordova.plugin;

// Cordova-required packages
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
// The native Toast API
import android.widget.Toast;

public class ToastyPlugin extends CordovaPlugin {
  private static final String DURATION_LONG = "long";

  @Override
  public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) {
    switch (action) {
      case "show": {
        String message;
        String duration;

        try {
          JSONObject options = args.getJSONObject(0);
          message = "show " + options.getString("message");
          duration = options.getString("duration");
        } catch (JSONException e) {
          callbackContext.error("Error encountered: " + e.getMessage());
          return false;
        }

        // Create the toast
        Toast toast = Toast.makeText(cordova.getActivity(), message,
            DURATION_LONG.equals(duration) ? Toast.LENGTH_LONG : Toast.LENGTH_SHORT);
        // Display toast
        toast.show();
        break;
      }

      case "start": {
        String message;
        String duration;

        try {
          JSONObject options = args.getJSONObject(0);
          message = "start " + options.getString("message");
          duration = options.getString("duration");
        } catch (JSONException e) {
          callbackContext.error("Error encountered: " + e.getMessage());
          return false;
        }

        // Create the toast
        Toast toast = Toast.makeText(cordova.getActivity(), message,
            DURATION_LONG.equals(duration) ? Toast.LENGTH_LONG : Toast.LENGTH_SHORT);
        // Display toast
        toast.show();
        break;
      }

      default: {
        callbackContext.error("\"" + action + "\" is not a recognized action.");
        return false;
      }
    }
    // Send a positive result to the callbackContext
    PluginResult pluginResult = new PluginResult(PluginResult.Status.OK);
    callbackContext.sendPluginResult(pluginResult);
    return true;
  }
}
