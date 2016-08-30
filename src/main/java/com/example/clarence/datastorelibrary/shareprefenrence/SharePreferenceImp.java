package com.example.clarence.datastorelibrary.shareprefenrence;


import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;

import com.alibaba.fastjson.JSON;

import java.util.List;
import java.util.Set;

/**
 * 普通封装
 */
public class SharePreferenceImp implements ISharePreference {
    public Context context;
    public BaseSharePreferences baseSharePreferences;

    public SharePreferenceImp() {

    }

    public static class Holder {
        static SharePreferenceImp sp = new SharePreferenceImp();
    }

    public static SharePreferenceImp getInstance() {
        return Holder.sp;
    }

    @Override
    public void init(Context context, String defaultSpName) {
        if (this.context == null)
            this.context = context;
        if (this.baseSharePreferences == null) {
            baseSharePreferences = new BaseSharePreferences(context, defaultSpName);
        }
    }

    @Override
    public String getDefaultSpName() {
        return baseSharePreferences.getDefaultSpName();
    }


    @Override
    public boolean setIntValue(String key, int value, String spName) {
        if (TextUtils.isEmpty(key)) {
            return false;
        }
        SharedPreferences sp = baseSharePreferences.loadSP(spName);
        if (sp != null) {
            return sp.edit().putInt(key, value).commit();
        }
        return false;
    }

    @Override
    public boolean setLongValue(String key, long value, String spName) {
        if (TextUtils.isEmpty(key)) {
            return false;
        }
        SharedPreferences sp = baseSharePreferences.loadSP(spName);
        if (sp != null) {
            return sp.edit().putLong(key, value).commit();
        }
        return false;
    }

    @Override
    public boolean setStringValue(String key, String value, String spName) {
        if (TextUtils.isEmpty(key) || TextUtils.isEmpty(value)) {
            return false;
        }
        SharedPreferences sp = baseSharePreferences.loadSP(spName);
        if (sp != null) {
            return sp.edit().putString(key, value).commit();
        }
        return false;
    }

    @Override
    public boolean setFloatValue(String key, float value, String spName) {
        if (TextUtils.isEmpty(key)) {
            return false;
        }
        SharedPreferences sp = baseSharePreferences.loadSP(spName);
        if (sp != null) {
            return sp.edit().putFloat(key, value).commit();
        }
        return false;
    }

    @Override
    public boolean setBooleanValue(String key, boolean value, String spName) {
        if (TextUtils.isEmpty(key)) {
            return false;
        }
        SharedPreferences sp = baseSharePreferences.loadSP(spName);
        if (sp != null) {
            return sp.edit().putBoolean(key, value).commit();
        }
        return false;
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public boolean setSetValue(String key, Set<String> value, String spName) {
        if (TextUtils.isEmpty(key) || value == null || value.size() == 0) {
            return false;
        }
        SharedPreferences sp = baseSharePreferences.loadSP(spName);
        if (sp != null) {
            return sp.edit().putStringSet(key, value).commit();
        }
        return false;
    }

    @Override
    public boolean setJsonValue(String key, Object entity, String newSp) {
        if (TextUtils.isEmpty(key) || entity == null) {
            return false;
        }
        String jsonString = JSON.toJSONString(entity);
        if (!TextUtils.isEmpty(jsonString)) {
            return SharePreferenceImp.getInstance().setStringValue(key, jsonString, newSp);
        }
        return false;
    }

    @Override
    public int getIntValue(String key, int defValue, String spName) {
        if (TextUtils.isEmpty(key)) {
            return defValue;
        }
        SharedPreferences sp = baseSharePreferences.loadSP(spName);
        if (sp != null) {
            return sp.getInt(key, defValue);
        }
        return defValue;
    }

    @Override
    public long getLongValue(String key, long defValue, String spName) {
        if (TextUtils.isEmpty(key)) {
            return defValue;
        }
        SharedPreferences sp = baseSharePreferences.loadSP(spName);
        if (sp != null) {
            return sp.getLong(key, defValue);
        }
        return defValue;
    }

    @Override
    public String getStringValue(String key, String defValue, String spName) {
        if (TextUtils.isEmpty(key)) {
            return defValue;
        }
        SharedPreferences sp = baseSharePreferences.loadSP(spName);
        if (sp != null) {
            return sp.getString(key, defValue);
        }
        return defValue;
    }

    @Override
    public float getFloatValue(String key, float defValue, String spName) {
        if (TextUtils.isEmpty(key)) {
            return defValue;
        }
        SharedPreferences sp = baseSharePreferences.loadSP(spName);
        if (sp != null) {
            return sp.getFloat(key, defValue);
        }
        return defValue;
    }

    @Override
    public boolean getBooleanValue(String key, boolean defValue, String spName) {
        if (TextUtils.isEmpty(key)) {
            return defValue;
        }
        SharedPreferences sp = baseSharePreferences.loadSP(spName);
        if (sp != null) {
            return sp.getBoolean(key, defValue);
        }
        return defValue;
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public Set<String> getSetValue(String key, Set<String> defValue, String spName) {
        if (TextUtils.isEmpty(key)) {
            return defValue;
        }
        SharedPreferences sp = baseSharePreferences.loadSP(spName);
        if (sp != null) {
            return sp.getStringSet(key, defValue);
        }
        return defValue;
    }


    @Override
    public <T> T getJsonObjectValue(String key, T defValue, Class<T> entityType, String newSp) {
        if (TextUtils.isEmpty(key)) {
            return defValue;
        }
        String jsonString = getStringValue(key, null, newSp);
        if (!TextUtils.isEmpty(jsonString)) {
            T object = JSON.parseObject(jsonString, entityType);
            return object == null ? defValue : object;
        }
        return defValue;
    }

    @Override
    public <T> List<T> getJsonArrayValue(String key, List<T> defValue, Class<T> entityType, String newSp) {
        if (TextUtils.isEmpty(key)) {
            return defValue;
        }
        String jsonString = getStringValue(key, null, newSp);
        if (!TextUtils.isEmpty(jsonString)) {
            List<T> object = JSON.parseArray(jsonString, entityType);
            return object == null ? defValue : object;
        }
        return defValue;
    }

    @Override
    public boolean clear(String spName) {
        SharedPreferences sp = baseSharePreferences.loadSP(spName);
        if (sp != null) {
            return sp.edit().clear().commit();
        }
        return false;
    }

    public boolean remove(String spName) {
        return baseSharePreferences.remove(spName);
    }
}
