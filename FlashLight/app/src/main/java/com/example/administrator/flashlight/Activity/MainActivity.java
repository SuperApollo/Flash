package com.example.administrator.flashlight.Activity;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

import com.example.administrator.flashlight.Base.MyApplication;
import com.example.administrator.flashlight.Utils.Flash;
import com.example.administrator.flashlight.Utils.FlashLightManager;
import com.example.administrator.flashlight.R;

public class MainActivity extends Activity {

    private FlashLightManager mFlashLightManager;
    private Flash mFlash;
    private boolean mUpper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        init();
    }

    private void init() {

        mUpper = isVersion21Upper();
        if (mUpper) {
            mFlashLightManager = new FlashLightManager(this);
        } else {
            mFlash = Flash.getInstance();
            mFlash.open();
        }

    }

    //判断版本是否是5.0以上
    private boolean isVersion21Upper() {
        int version = Build.VERSION.SDK_INT;
        if (version >= 21) {
            return true;
        }
        return false;
    }

    private void initView() {
        ToggleButton btn_flash_switch = (ToggleButton) findViewById(R.id.btn_flash_switch);
        btn_flash_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (mUpper) {
                    mFlashLightManager.setFlashlight(b);
                } else {
                    mFlash.setLight(b);
                }

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mUpper) {
            if (null == mFlashLightManager) {
                init();
            }
        } else {
            if (null == mFlash) {
                init();
            }
        }

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mFlashLightManager != null) {
            mFlashLightManager.killFlashlight();
            mFlashLightManager = null;
        }
        if (mFlash != null) {
            mFlash.close();
            mFlash = null;
        }
    }
}
