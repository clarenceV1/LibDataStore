package com.example.clarence.datastorelibrary.shareprefenrence;

import android.content.Context;

import java.util.List;
import java.util.Set;

/**
 * 扩展类----直接使用默认文件名
 * Created by clarence on 16/4/8.
 */
public class SharePreferenceExpandImp implements ISharePrefrenceExpand {
    String defaultSpName;
    ISharePreference sharePreferenceImp;

    public SharePreferenceExpandImp(ISharePreference sharePreferenceImp) {
        this.sharePreferenceImp = sharePreferenceImp;
        this.defaultSpName = sharePreferenceImp.getDefaultSpName();
    }

    @Override
    public boolean setIntValue(String key, int value) {
        return sharePreferenceImp.setIntValue(key, value, defaultSpName);
    }

    @Override
    public boolean setLongValue(String key, long value) {
        return sharePreferenceImp.setLongValue(key, value, defaultSpName);
    }

    @Override
    public boolean setStringValue(String key, String value) {
        return sharePreferenceImp.setStringValue(key, value, defaultSpName);
    }

    @Override
    public boolean setFloatValue(String key, float value) {
        return sharePreferenceImp.setFloatValue(key, value, defaultSpName);
    }

    @Override
    public boolean setBooleanValue(String key, boolean value) {
        return sharePreferenceImp.setBooleanValue(key, value, defaultSpName);
    }

    @Override
    public boolean setSetValue(String key, Set<String> value) {
        return sharePreferenceImp.setSetValue(key, value, defaultSpName);
    }

    @Override
    public boolean setJsonValue(String key, Object entity) {
        return sharePreferenceImp.setJsonValue(key, entity, defaultSpName);
    }

    @Override
    public int getIntValue(String key, int defValue) {
        return sharePreferenceImp.getIntValue(key, defValue, defaultSpName);
    }

    @Override
    public long getLongValue(String key, long defValue) {
        return sharePreferenceImp.getLongValue(key, defValue, defaultSpName);
    }

    @Override
    public String getStringValue(String key, String defValue) {
        return sharePreferenceImp.getStringValue(key, defValue, defaultSpName);
    }

    @Override
    public float getFloatValue(String key, float defValue) {
        return sharePreferenceImp.getFloatValue(key, defValue, defaultSpName);
    }

    @Override
    public boolean getBooleanValue(String key, boolean defValue) {
        return sharePreferenceImp.getBooleanValue(key, defValue, defaultSpName);
    }

    @Override
    public Set<String> getSetValue(String key, Set<String> defValue) {
        return sharePreferenceImp.getSetValue(key, defValue, defaultSpName);
    }

    @Override
    public <T> T getJsonObjectValue(String key, T defValue, Class<T> entityType) {
        return sharePreferenceImp.getJsonObjectValue(key, defValue, entityType, defaultSpName);
    }


    @Override
    public <T> List<T> getJsonArrayValue(String key, List<T> defValue, Class<T> entityType) {
        return sharePreferenceImp.getJsonArrayValue(key, defValue, entityType, defaultSpName);
    }

    @Override
    public boolean clear() {
        return sharePreferenceImp.clear(defaultSpName);
    }

    @Override
    public boolean remove() {
        return sharePreferenceImp.remove(defaultSpName);
    }
}
