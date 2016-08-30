package com.example.clarence.datastorelibrary.db;

import android.content.Context;
import android.text.TextUtils;

import java.io.File;

/**
 * Created by clarence on 16/4/15.
 */
public class DaoConfig {
    private Context context;
    private File dbDir;
    private String dbName = "xUtils.db"; // default db name
    private int dbVersion = 1;
    private boolean allowTransaction = true;
    private DbManager.DbUpgradeListener dbUpgradeListener;
    private DbManager.TableCreateListener tableCreateListener;
    private DbManager.DbOpenListener dbOpenListener;

    public DaoConfig(Context context) {
        this.context = context.getApplicationContext();
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public DaoConfig setDbDir(File dbDir) {
        this.dbDir = dbDir;
        return this;
    }

    public DaoConfig setDbName(String dbName) {
        if (!TextUtils.isEmpty(dbName)) {
            this.dbName = dbName;
        }
        return this;
    }

    public DaoConfig setDbVersion(int dbVersion) {
        this.dbVersion = dbVersion;
        return this;
    }

    public DaoConfig setAllowTransaction(boolean allowTransaction) {
        this.allowTransaction = allowTransaction;
        return this;
    }

    public DaoConfig setDbOpenListener(DbManager.DbOpenListener dbOpenListener) {
        this.dbOpenListener = dbOpenListener;
        return this;
    }

    public DaoConfig setDbUpgradeListener(DbManager.DbUpgradeListener dbUpgradeListener) {
        this.dbUpgradeListener = dbUpgradeListener;
        return this;
    }

    public DaoConfig setTableCreateListener(DbManager.TableCreateListener tableCreateListener) {
        this.tableCreateListener = tableCreateListener;
        return this;
    }

    public File getDbDir() {
        return dbDir;
    }

    public String getDbName() {
        return dbName;
    }

    public int getDbVersion() {
        return dbVersion;
    }

    public boolean isAllowTransaction() {
        return allowTransaction;
    }

    public DbManager.DbOpenListener getDbOpenListener() {
        return dbOpenListener;
    }

    public DbManager.DbUpgradeListener getDbUpgradeListener() {
        return dbUpgradeListener;
    }

    public DbManager.TableCreateListener getTableCreateListener() {
        return tableCreateListener;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DaoConfig daoConfig = (DaoConfig) o;

        if (!dbName.equals(daoConfig.dbName)) return false;
        return dbDir == null ? daoConfig.dbDir == null : dbDir.equals(daoConfig.dbDir);
    }

    @Override
    public int hashCode() {
        int result = dbName.hashCode();
        result = 31 * result + (dbDir != null ? dbDir.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return String.valueOf(dbDir) + "/" + dbName;
    }
}
