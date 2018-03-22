package com.example.clarence.datastorelibrary.shareprefenrence;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;

import java.io.File;

/**
 * Created by clarence on 16/4/7.
 */
 class BaseSharePreferences {
    private static final String sTAG = "FileSharePreferences";
    /**
     * 默认的SharedPreferences 文件名
     */
    private String defaultSpName = "default";
    private Context context;

    public BaseSharePreferences(Context context) {
        this.context = context;
    }

    public BaseSharePreferences(Context context, String defaultSpName) {
        this.context = context;
        setDefaultSpName(defaultSpName);
    }

    private void setDefaultSpName(String defaultSpName) {
        if (!TextUtils.isEmpty(defaultSpName)) {
            this.defaultSpName = defaultSpName;
        }
    }

    public String getDefaultSpName() {
        return defaultSpName;
    }

    /**
     * 获取SharedPreferences根据指定的SharedPreferences Name
     */
    @SuppressLint("WrongConstant")
    public SharedPreferences loadSP(String newSp) {
        String spName = newSp;
        if (TextUtils.isEmpty(spName)) {
            spName = defaultSpName;
        }
        try {
            int sdkLevel = Build.VERSION.SDK_INT;
            return context.getSharedPreferences(spName, (sdkLevel > 8) ? 4 : 0);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean remove(String spName) {
        if (TextUtils.isEmpty(spName)) {
            return false;
        }
        File file = context.getDatabasePath(spName + ".xml");
        if (file.exists()) {
            return file.delete();
        }
        return false;
    }
}
