package com.example.clarence.datastorelibrary;

import android.content.Context;

import com.example.clarence.datastorelibrary.shareprefenrence.ISharePreference;
import com.example.clarence.datastorelibrary.shareprefenrence.ISharePrefrenceExpand;
import com.example.clarence.datastorelibrary.shareprefenrence.ISharePrefrenceExpandForUser;
import com.example.clarence.datastorelibrary.shareprefenrence.SharePreferenceExpandForUserImp;
import com.example.clarence.datastorelibrary.shareprefenrence.SharePreferenceExpandImp;
import com.example.clarence.datastorelibrary.shareprefenrence.SharePreferenceImp;

import java.util.List;
import java.util.Set;

public class StoreSharePreference implements ISharePreference, ISharePrefrenceExpand, ISharePrefrenceExpandForUser {
    private ISharePreference sharePreferenceImp;
    private ISharePrefrenceExpand sharePreferenceExpandImp;
    private ISharePrefrenceExpandForUser sharePreferenceExpandForUserImp;

    private StoreSharePreference() {

    }

    public static class Holder {
        static StoreSharePreference sp = new StoreSharePreference();
    }

    public static StoreSharePreference getInstance() {
        return Holder.sp;
    }

    public void init(Context context) {
        init(context, null, null);
    }

    @Override
    public void init(Context context, String defaultSpName) {
        init(context, defaultSpName, null);
    }

    public void init(Context context, String defaultSpName, String userId) {
        sharePreferenceImp = SharePreferenceImp.getInstance();
        sharePreferenceImp.init(context, defaultSpName);
        sharePreferenceExpandImp = new SharePreferenceExpandImp(sharePreferenceImp);
        sharePreferenceExpandForUserImp = new SharePreferenceExpandForUserImp(sharePreferenceImp, userId);
    }

    public void setUserId(String userId) {
        sharePreferenceExpandForUserImp.setUserId(userId);
    }

    @Override
    public String getDefaultSpName() {
        return sharePreferenceImp.getDefaultSpName();
    }

    @Override
    public boolean setIntValue(String key, int value, String spName) {
        return sharePreferenceImp.setIntValue(key, value, spName);
    }

    @Override
    public boolean setLongValue(String key, long value, String spName) {
        return sharePreferenceImp.setLongValue(key, value, spName);
    }

    @Override
    public boolean setStringValue(String key, String value, String spName) {
        return sharePreferenceImp.setStringValue(key, value, spName);
    }

    @Override
    public boolean setFloatValue(String key, float value, String spName) {
        return sharePreferenceImp.setFloatValue(key, value, spName);
    }

    @Override
    public boolean setBooleanValue(String key, boolean value, String spName) {
        return sharePreferenceImp.setBooleanValue(key, value, spName);
    }

    @Override
    public boolean setSetValue(String key, Set<String> value, String spName) {
        return sharePreferenceImp.setSetValue(key, value, spName);
    }

    @Override
    public boolean setJsonValue(String key, Object entity, String spName) {
        return sharePreferenceImp.setJsonValue(key, entity, spName);
    }

    @Override
    public int getIntValue(String key, int defValue, String spName) {
        return sharePreferenceImp.getIntValue(key, defValue, spName);
    }

    @Override
    public long getLongValue(String key, long defValue, String spName) {
        return sharePreferenceImp.getLongValue(key, defValue, spName);
    }

    @Override
    public String getStringValue(String key, String defValue, String spName) {
        return sharePreferenceImp.getStringValue(key, defValue, spName);
    }

    @Override
    public float getFloatValue(String key, float defValue, String spName) {
        return sharePreferenceImp.getFloatValue(key, defValue, spName);
    }

    @Override
    public boolean getBooleanValue(String key, boolean defValue, String spName) {
        return sharePreferenceImp.getBooleanValue(key, defValue, spName);
    }

    @Override
    public Set<String> getSetValue(String key, Set<String> defValue, String spName) {
        return sharePreferenceImp.getSetValue(key, defValue, spName);
    }

    @Override
    public <T> T getJsonObjectValue(String key, T defValue, Class<T> entityType, String spName) {
        return sharePreferenceImp.getJsonObjectValue(key, defValue, entityType, spName);
    }

    @Override
    public <T> List<T> getJsonArrayValue(String key, List<T> defValue, Class<T> entityType, String spName) {
        return sharePreferenceImp.getJsonArrayValue(key, defValue, entityType, spName);
    }

    @Override
    public boolean clear(String spName) {
        return sharePreferenceImp.clear(spName);
    }

    @Override
    public boolean remove(String spName) {
        return sharePreferenceImp.remove(spName);
    }

    @Override
    public boolean setIntValueForUser(String key, int value) {
        return sharePreferenceExpandForUserImp.setIntValueForUser(key, value);
    }

    @Override
    public boolean setLongValueForUser(String key, long value) {
        return sharePreferenceExpandForUserImp.setLongValueForUser(key, value);
    }

    @Override
    public boolean setStringValueForUser(String key, String value) {
        return sharePreferenceExpandForUserImp.setStringValueForUser(key, value);
    }

    @Override
    public boolean setFloatValueForUser(String key, float value) {
        return sharePreferenceExpandForUserImp.setFloatValueForUser(key, value);
    }

    @Override
    public boolean setBooleanValueForUser(String key, boolean value) {
        return sharePreferenceExpandForUserImp.setBooleanValueForUser(key, value);
    }

    @Override
    public boolean setSetValueForUser(String key, Set<String> value) {
        return sharePreferenceExpandForUserImp.setSetValueForUser(key, value);
    }

    @Override
    public boolean setJsonValueForUser(String key, Object entity) {
        return sharePreferenceExpandForUserImp.setJsonValueForUser(key, entity);
    }

    @Override
    public int getIntValueForUser(String key, int defValue) {
        return sharePreferenceExpandForUserImp.getIntValueForUser(key, defValue);
    }

    @Override
    public long getLongValueForUser(String key, long defValue) {
        return sharePreferenceExpandForUserImp.getLongValueForUser(key, defValue);
    }

    @Override
    public String getStringValueForUser(String key, String defValue) {
        return sharePreferenceExpandForUserImp.getStringValueForUser(key, defValue);
    }

    @Override
    public float getFloatValueForUser(String key, float defValue) {
        return sharePreferenceExpandForUserImp.getFloatValueForUser(key, defValue);
    }

    @Override
    public boolean getBooleanValueForUser(String key, boolean defValue) {
        return sharePreferenceExpandForUserImp.getBooleanValueForUser(key, defValue);
    }

    @Override
    public Set<String> getSetValueForUser(String key, Set<String> defValue) {
        return sharePreferenceExpandForUserImp.getSetValueForUser(key, defValue);
    }

    @Override
    public <T> T getJsonObjectValueForUser(String key, T defValue, Class<T> entityType) {
        return sharePreferenceExpandForUserImp.getJsonObjectValueForUser(key, defValue, entityType);
    }

    @Override
    public <T> List<T> getJsonArrayValueForUser(String key, List<T> defValue, Class<T> entityType) {
        return sharePreferenceExpandForUserImp.getJsonArrayValueForUser(key, defValue, entityType);
    }

    @Override
    public boolean clearForUser() {
        return sharePreferenceExpandForUserImp.clearForUser();
    }

    @Override
    public boolean removeForUser() {
        return sharePreferenceExpandForUserImp.removeForUser();
    }

    @Override
    public boolean setIntValue(String key, int value) {
        return sharePreferenceExpandImp.setIntValue(key, value);
    }

    @Override
    public boolean setLongValue(String key, long value) {
        return sharePreferenceExpandImp.setLongValue(key, value);
    }

    @Override
    public boolean setStringValue(String key, String value) {
        return sharePreferenceExpandImp.setStringValue(key, value);
    }

    @Override
    public boolean setFloatValue(String key, float value) {
        return sharePreferenceExpandImp.setFloatValue(key, value);
    }

    @Override
    public boolean setBooleanValue(String key, boolean value) {
        return sharePreferenceExpandImp.setBooleanValue(key, value);
    }

    @Override
    public boolean setSetValue(String key, Set<String> value) {
        return sharePreferenceExpandImp.setSetValue(key, value);
    }

    @Override
    public boolean setJsonValue(String key, Object entity) {
        return sharePreferenceExpandImp.setJsonValue(key, entity);
    }

    @Override
    public int getIntValue(String key, int defValue) {
        return sharePreferenceExpandImp.getIntValue(key, defValue);
    }

    @Override
    public long getLongValue(String key, long defValue) {
        return sharePreferenceExpandImp.getLongValue(key, defValue);
    }

    @Override
    public String getStringValue(String key, String defValue) {
        return sharePreferenceExpandImp.getStringValue(key, defValue);
    }

    @Override
    public float getFloatValue(String key, float defValue) {
        return sharePreferenceExpandImp.getFloatValue(key, defValue);
    }

    @Override
    public boolean getBooleanValue(String key, boolean defValue) {
        return sharePreferenceExpandImp.getBooleanValue(key, defValue);
    }

    @Override
    public Set<String> getSetValue(String key, Set<String> defValue) {
        return sharePreferenceExpandImp.getSetValue(key, defValue);
    }

    @Override
    public <T> T getJsonObjectValue(String key, T defValue, Class<T> entityType) {
        return sharePreferenceExpandImp.getJsonObjectValue(key, defValue, entityType);
    }

    @Override
    public <T> List<T> getJsonArrayValue(String key, List<T> defValue, Class<T> entityType) {
        return sharePreferenceExpandImp.getJsonArrayValue(key, defValue, entityType);
    }

    @Override
    public boolean clear() {
        return sharePreferenceExpandImp.clear();
    }

    @Override
    public boolean remove() {
        return sharePreferenceExpandImp.remove();
    }


}
