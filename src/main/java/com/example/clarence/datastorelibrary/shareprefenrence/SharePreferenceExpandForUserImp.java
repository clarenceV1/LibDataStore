package com.example.clarence.datastorelibrary.shareprefenrence;

import java.util.List;
import java.util.Set;

/**
 * Created by clarence on 16/4/8.
 */
public class SharePreferenceExpandForUserImp implements ISharePrefrenceExpandForUser {

    String spName;
    ISharePreference sharePreferenceImp;

    public SharePreferenceExpandForUserImp(ISharePreference sharePreferenceImp, String userId) {
        this.sharePreferenceImp = sharePreferenceImp;
        this.spName = getSpName(userId);
    }

    public String getSpName(String userId) {
        return "sp_" + userId;
    }

    @Override
    public void setUserId(String userId) {
        this.spName = "sp_" + userId;
    }

    @Override
    public boolean setIntValueForUser(String key, int value) {
        return sharePreferenceImp.setIntValue(key, value, spName);
    }

    @Override
    public boolean setLongValueForUser(String key, long value) {
        return sharePreferenceImp.setLongValue(key, value, spName);
    }

    @Override
    public boolean setStringValueForUser(String key, String value) {
        return sharePreferenceImp.setStringValue(key, value, spName);
    }

    @Override
    public boolean setFloatValueForUser(String key, float value) {
        return sharePreferenceImp.setFloatValue(key, value, spName);
    }

    @Override
    public boolean setBooleanValueForUser(String key, boolean value) {
        return sharePreferenceImp.setBooleanValue(key, value, spName);
    }

    @Override
    public boolean setSetValueForUser(String key, Set<String> value) {
        return sharePreferenceImp.setSetValue(key, value, spName);
    }

    @Override
    public boolean setJsonValueForUser(String key, Object entity) {
        return sharePreferenceImp.setJsonValue(key, entity, spName);
    }

    @Override
    public int getIntValueForUser(String key, int defValue) {
        return sharePreferenceImp.getIntValue(key, defValue, spName);
    }

    @Override
    public long getLongValueForUser(String key, long defValue) {
        return sharePreferenceImp.getLongValue(key, defValue, spName);
    }

    @Override
    public String getStringValueForUser(String key, String defValue) {
        return sharePreferenceImp.getStringValue(key, defValue, spName);
    }

    @Override
    public float getFloatValueForUser(String key, float defValue) {
        return sharePreferenceImp.getFloatValue(key, defValue, spName);
    }

    @Override
    public boolean getBooleanValueForUser(String key, boolean defValue) {
        return sharePreferenceImp.getBooleanValue(key, defValue, spName);
    }

    @Override
    public Set<String> getSetValueForUser(String key, Set<String> defValue) {
        return sharePreferenceImp.getSetValue(key, defValue, spName);
    }

    @Override
    public <T> T getJsonObjectValueForUser(String key, T defValue, Class<T> entityType) {
        return sharePreferenceImp.getJsonObjectValue(key, defValue, entityType, spName);
    }

    @Override
    public <T> List<T> getJsonArrayValueForUser(String key, List<T> defValue, Class<T> entityType) {
        return sharePreferenceImp.getJsonArrayValue(key, defValue, entityType, spName);
    }

    @Override
    public boolean clearForUser() {
        return sharePreferenceImp.clear(spName);
    }

    @Override
    public boolean removeForUser() {
        return sharePreferenceImp.remove(spName);
    }
}
