package com.gaopan.utilsgarage.Utils;

import android.text.TextUtils;
import android.util.Log;

/**
 * Author:gaopan
 * Date:2018/3/19
 */
public class LogUtils {
    private final static String TAG = "LogUtils";

    private static boolean isDebug = true; // log开关

    public static void setIsDebug(boolean b) {
        isDebug = b;
    }

    public static boolean isDebug() {
        return isDebug;
    }

    public static void log(Object msg) {
        log(TAG, msg);
    }

    public static void log(String LOG_CLASS_NAME, Object msg) {
        if (!TextUtils.isEmpty(LOG_CLASS_NAME) && null != msg) {
            if (isDebug) {
                Log.i(LOG_CLASS_NAME,
                        "[INFO " + LOG_CLASS_NAME + "] " + String.valueOf(msg));
            }
        }
    }

    public static void log(String TAG, String LOG_CLASS_NAME, Object msg) {
        if (!TextUtils.isEmpty(TAG) && null != msg) {
            if (isDebug) {

                Log.i(TAG,
                        "[INFO " + LOG_CLASS_NAME + "] " + String.valueOf(msg));

            }
        }
    }
}


