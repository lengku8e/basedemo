package com.example.flutterapp;

import android.content.Context;

import io.flutter.app.FlutterApplication;

public class MyApplcation extends FlutterApplication {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }
    public static Context getContext() {
        return context;
    }
}
