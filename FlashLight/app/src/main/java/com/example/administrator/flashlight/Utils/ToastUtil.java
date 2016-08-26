package com.example.administrator.flashlight.Utils;

import android.widget.Toast;

import com.example.administrator.flashlight.Base.MyApplication;

/**
 * Created by Administrator on 2016/8/26.
 */
public class ToastUtil {
    public static void toaster(String msg) {
        Toast.makeText(MyApplication.getContext(), msg, Toast.LENGTH_SHORT).show();
    }

    public static void toaster(String msg, int duration) {
        Toast.makeText(MyApplication.getContext(), msg, duration).show();
    }
}
