package io.flutter.plugins;

import android.widget.Toast;

import com.example.flutterapp.MyApplcation;

import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

public class Myplugins implements MethodChannel.MethodCallHandler {


    public static void reginster(BinaryMessenger messenger) {
        final MethodChannel channel = new MethodChannel(messenger, "getToastPlugins");
        channel.setMethodCallHandler(new Myplugins());

    }

    @Override
    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        if (methodCall.method.equals("getToast")) {
            Toast.makeText(MyApplcation.getContext(), "myToast", Toast.LENGTH_SHORT).show();
        } else {
            result.notImplemented();
        }
    }
}
