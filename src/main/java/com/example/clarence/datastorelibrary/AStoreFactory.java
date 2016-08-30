package com.example.clarence.datastorelibrary;

import android.content.Context;

/**
 * Created by clarence on 16/4/8.
 */
public abstract class AStoreFactory {
    public abstract void initStoreFile(Context context);

    public abstract StoreFile getStoreFile();

    public abstract void initStoreSharePreference(Context context);

    public abstract StoreSharePreference getStoreSharePreference();
}
