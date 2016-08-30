package com.example.clarence.datastorelibrary.shareprefenrence;

import java.util.List;
import java.util.Set;

/**
 * Created by clarence on 16/4/8.
 */
public interface ISharePrefrenceExpandForUser {
    public void setUserId(String spName);

    public boolean setIntValueForUser(String key, int value);

    public boolean setLongValueForUser(String key, long value);

    public boolean setStringValueForUser(String key, String value);

    public boolean setFloatValueForUser(String key, float value);

    public boolean setBooleanValueForUser(String key, boolean value);

    public boolean setSetValueForUser(String key, Set<String> value);

    public boolean setJsonValueForUser(String key, Object entity);

    public int getIntValueForUser(String key, int defValue);

    public long getLongValueForUser(String key, long defValue);

    public String getStringValueForUser(String key, String defValue);

    public float getFloatValueForUser(String key, float defValue);

    public boolean getBooleanValueForUser(String key, boolean defValue);

    public Set<String> getSetValueForUser(String key, Set<String> defValue);

    public <T> T getJsonObjectValueForUser(String key, T defValue, Class<T> entityType);

    public <T> List<T> getJsonArrayValueForUser(String key, List<T> defValue, Class<T> entityType);

    public boolean clearForUser();

    public boolean removeForUser();

}
