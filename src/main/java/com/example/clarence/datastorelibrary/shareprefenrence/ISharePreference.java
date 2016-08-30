package com.example.clarence.datastorelibrary.shareprefenrence;

import android.content.Context;

import java.util.List;
import java.util.Set;

/**
 * Created by clarence on 16/4/8.
 */
public interface ISharePreference {

    public void init(Context context, String defaultSpName);

    public String getDefaultSpName();

    public boolean setIntValue(String key, int value, String spName);

    public boolean setLongValue(String key, long value, String spName);

    public boolean setStringValue(String key, String value, String spName);

    public boolean setFloatValue(String key, float value, String spName);

    public boolean setBooleanValue(String key, boolean value, String spName);

    public boolean setSetValue(String key, Set<String> value, String spName);

    public boolean setJsonValue(String key, Object entity, String newSp);

    public int getIntValue(String key, int defValue, String spName);

    public long getLongValue(String key, long defValue, String spName);

    public String getStringValue(String key, String defValue, String spName);

    public float getFloatValue(String key, float defValue, String spName);

    public boolean getBooleanValue(String key, boolean defValue, String spName);

    public Set<String> getSetValue(String key, Set<String> defValue, String spName);

    public <T> T getJsonObjectValue(String key, T defValue, Class<T> entityType, String spName);

    public <T> List<T> getJsonArrayValue(String key, List<T> defValue, Class<T> entityType, String spName);

    public boolean clear(String spName);

    public boolean remove(String spName);
}
