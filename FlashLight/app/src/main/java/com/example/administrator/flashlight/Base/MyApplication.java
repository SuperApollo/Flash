package com.example.administrator.flashlight.Base;

import android.app.Application;
import android.content.Context;

/**
 * Created by Administrator on 2016/8/26.
 */
public class MyApplication extends Application {
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }

    public static Context getContext() {
        return mContext;
    }
}
