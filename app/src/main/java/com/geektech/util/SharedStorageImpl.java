package com.geektech.util;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedStorageImpl implements SharedStorage {

    private SharedPreferences sharedPreferences;

    public SharedStorageImpl(Context context, String fileName) {
        sharedPreferences = context.getApplicationContext()
                .getSharedPreferences(
                    fileName,
                    Context.MODE_PRIVATE
                );
    }

    @Override
    public int getInt(String key) {
        return sharedPreferences.getInt(key, -1);
    }

    @Override
    public boolean getBoolean(String key, boolean defaultValue) {
        return sharedPreferences.getBoolean(key, defaultValue);
    }

    @Override
    public void setBoolean(String key, boolean value) {
        sharedPreferences.edit()
                .putBoolean(key, value)
                .apply();
    }

    @Override
    public boolean contains(String key) {
        return sharedPreferences.contains(key);
    }
}
