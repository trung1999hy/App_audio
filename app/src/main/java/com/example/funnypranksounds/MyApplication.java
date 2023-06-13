package com.example.funnypranksounds;

import android.app.Application;

import com.example.funnypranksounds.utils.SharePrefHelper;


public class MyApplication extends Application {

    private SharePrefHelper preference;
    private static MyApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        preference = SharePrefHelper.getInstance(this);

    }

    public SharePrefHelper getPreference() {
       return preference;
    }

    public static MyApplication newInstance() {
        return instance;
    }

}