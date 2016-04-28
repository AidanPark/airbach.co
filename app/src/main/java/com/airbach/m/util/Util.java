package com.airbach.m.util;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Vibrator;
import android.provider.MediaStore;
import android.telephony.TelephonyManager;
import android.view.Gravity;
import android.widget.TextView;
import android.widget.Toast;

import com.airbach.m.util.log.LogTag;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.security.spec.AlgorithmParameterSpec;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;


/**
 * @author : Aidan(airbach.co@gmail.com)
 * @version : 1.0
 * @date : 2016-04-27.
 */
public class Util {

    private static LogTag TAG = new LogTag(Util.class.getName(), Util.class.getSimpleName(), Thread.currentThread());

    public static boolean hasM() {
        return Build.VERSION.SDK_INT >= 23;
    }

    //###################################################################################################
    //Toast
    //###################################################################################################
    private static Toast toast;

    /**
     * toast 가 event 독립적으로 생성되지 않도록 사용한다.
     *
     * @param context
     * @param text
     * @param length
     */
    public static void toast(Context context, String text, int length) {
        if (toast == null) {
            toast = new Toast(context);
            toast = Toast.makeText(context, text, length);
        } else {
            toast.setText(text);
        }

        TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
        if (v != null) {
            v.setGravity(Gravity.CENTER);
        }

        toast.show();
    }

    public static void toastLong(Context context, String text) {
        toast(context, text, Toast.LENGTH_LONG);
    }

    public static void toastShort(Context context, String text) {
        toast(context, text, Toast.LENGTH_SHORT);
    }

    // #########################################################################################
    // 스톱워치
    // #########################################################################################
    private static long startTime;

    public static long stopWatchStart() {
        return startTime = System.currentTimeMillis();
    }

    public static long stopWatchStop() {
        return (System.currentTimeMillis() - startTime);
    }





}
