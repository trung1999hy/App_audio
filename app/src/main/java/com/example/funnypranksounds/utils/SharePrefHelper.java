package com.example.funnypranksounds.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SharePrefHelper {
    private String PREFS_ACCOUNT = "PREFS_ACCOUNT";
    public static SharePrefHelper instance;
    private SharedPreferences sharePrefHelper;


    public SharePrefHelper(Context context) {
        sharePrefHelper = context.getSharedPreferences(PREFS_ACCOUNT, Context.MODE_PRIVATE);
    }

    public void setValueCoin(int value) {
        sharePrefHelper.edit().putInt(Constant.KEY_TOTAL_COIN, value).apply();
    }

    public int getValueCoin() {
        return sharePrefHelper.getInt(Constant.KEY_TOTAL_COIN, Constant.INT_ZERO);
    }

    public static SharePrefHelper getInstance(Context context) {
        if (instance == null) {
            instance = new SharePrefHelper(context);
        }
        return instance;
    }
}
