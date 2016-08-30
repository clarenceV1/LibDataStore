package com.example.clarence.datastorelibrary.shareprefenrence;

import java.util.List;
import java.util.Set;

/**
 * Created by clarence on 16/4/8.
 */
public interface ISharePrefrenceExpand {

    public boolean setIntValue(String key, int value);

    public boolean setLongValue(String key, long value);

    public boolean setStringValue(String key, String value);

    public boolean setFloatValue(String key, float value);

    public boolean setBooleanValue(String key, boolean value);

    public boolean setSetValue(String key, Set<String> value);

    public boolean setJsonValue(String key, Object entity);

    public int getIntValue(String key, int defValue);

    public long getLongValue(String key, long defValue);

    public String getStringValue(String key, String defValue);

    public float getFloatValue(String key, float defValue);

    public boolean getBooleanValue(String key, boolean defValue);

    public Set<String> getSetValue(String key, Set<String> defValue);

    public <T> T getJsonObjectValue(String key, T defValue, Class<T> entityType);

    public <T> List<T> getJsonArrayValue(String key, List<T> defValue, Class<T> entityType);

    public boolean clear();

    public boolean remove();

}
