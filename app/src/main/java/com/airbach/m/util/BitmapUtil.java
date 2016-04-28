package com.airbach.m.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * @author : Aidan(airbach.co@gmail.com)
 * @version : 1.0
 * @date : 2016-04-28.
 */

public class BitmapUtil {


    /**
     * Bitmap from resource
     *
     * @param context
     * @param resource
     * @return
     */
    public static Bitmap getBitmapFromResource(Context context, int resource) {
        return BitmapFactory.decodeResource(context.getResources(), resource);
    }

}
