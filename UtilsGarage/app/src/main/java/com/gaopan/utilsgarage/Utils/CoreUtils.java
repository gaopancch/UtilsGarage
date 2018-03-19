package com.gaopan.utilsgarage.Utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.provider.Settings;
import android.telephony.TelephonyManager;

/**
 * Author:letv
 * Date:2018/3/19
 */
public class CoreUtils {
    /**
     * 获取app版本
     *
     * @param context
     * @return
     */
    public static String getVersion(Context context) {
        String version = "";
        PackageManager packageManager = context.getPackageManager();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(
                    context.getPackageName(), 0);
            version = packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        // return version.replace(".", "");
        return version;
    }

    /**
     * 获取运营商名称
     *
     * @param context
     * @return
     */
    public static String getSimOperatorName(Context context) {
        TelephonyManager mTelephonyManager = (TelephonyManager) context
                .getSystemService(Context.TELEPHONY_SERVICE);
        return mTelephonyManager.getSimOperatorName();
    }

    /**
     * 获取IMEI
     *
     * @param context
     * @return
     */
    @SuppressLint("MissingPermission")
    public static String getIMEI(Context context) {
        if (context == null) {
            return "";
        }
        String imei = "";
        imei = ((TelephonyManager) context
                .getSystemService(Context.TELEPHONY_SERVICE)).getDeviceId();
        return imei;
    }

    /**
     * 获取IMSI
     *
     * @param context
     * @return
     */
    @SuppressLint("MissingPermission")
    public static String getIMSI(Context context) {
        if (context == null) {
            return "";
        }
        String imsi = "";
        imsi = ((TelephonyManager) context
                .getSystemService(Context.TELEPHONY_SERVICE)).getSubscriberId();
        return imsi;
    }

    /**
     * 获取udid
     *
     * @param context
     * @return
     */
    public static String getUdid(Context context) {
        String Udid = "";
        Udid = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
        return Udid;
    }
}

