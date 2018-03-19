package com.gaopan.utilsgarage.Utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Author:gaopan
 * Date:2018/3/19
 */
public class SharedPreferencesUtils {
    private static SharedPreferences.Editor editor = null;
    private static SharedPreferences sharedPreferences = null;

    private SharedPreferencesUtils() {}

    private static SharedPreferences getSharedPreferencesObject(Context context) {
        if (sharedPreferences == null) {
            synchronized (SharedPreferencesUtils.class) {
                if(sharedPreferences == null) {
                    sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
                }
            }
        }
        return sharedPreferences;
    }

    private static SharedPreferences.Editor getEditorObject(Context context) {
        if (editor == null) {
            synchronized (SharedPreferencesUtils.class) {
                if (editor == null) {
                    editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
                }
            }
        }
        return editor;
    }

    public static int getSharedPreferences(Context context, String key, int defValue) {
        return getSharedPreferencesObject(context).getInt(key, defValue);
    }

    public static long getSharedPreferences(Context context, String key, long defValue) {
        return getSharedPreferencesObject(context).getLong(key, defValue);
    }

    public static Boolean getSharedPreferences(Context context, String key, Boolean defValue) {
        return getSharedPreferencesObject(context).getBoolean(key, defValue);
    }

    public static String getSharedPreferences(Context context, String key, String defValue) {
        return getSharedPreferencesObject(context).getString(key, defValue);
    }

    public static void setEditor(Context context, String key, int value) {
        getEditorObject(context).putInt(key, value).commit();
    }

    public static void setEditor(Context context, String key, long value) {
        getEditorObject(context).putLong(key, value).commit();
    }

    public static void setEditor(Context context, String key, Boolean value) {
        getEditorObject(context).putBoolean(key, value).commit();
    }

    public static void setEditor(Context context, String key, String value) {
        getEditorObject(context).putString(key, value).commit();
    }

    public static void removeKey(Context context, String key) {
        getEditorObject(context).remove(key).commit();
    }
}

