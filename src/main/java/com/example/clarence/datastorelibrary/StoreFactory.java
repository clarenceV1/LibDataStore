package com.example.clarence.datastorelibrary;

import android.content.Context;

import com.example.clarence.datastorelibrary.db.DaoConfig;
import com.example.clarence.datastorelibrary.db.DbManager;
import com.example.clarence.datastorelibrary.db.DbManagerImpl;

/**
 * Created by clarence on 16/4/8.
 */
public class StoreFactory {


    public void initStoreFile(Context context) {

    }

    public StoreFile getStoreFile() {
        return null;
    }


    public static StoreSharePreference getStoreSharePreference() {
        return StoreSharePreference.getInstance();
    }

    public static DbManager getDbManager(DaoConfig daoConfig) {
        return DbManagerImpl.getInstance(daoConfig);
    }
}
