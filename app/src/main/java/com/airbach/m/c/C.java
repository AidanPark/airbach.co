package com.airbach.m.c;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Typeface;
import android.os.Build;
import android.view.Display;
import android.view.WindowManager;

import com.airbach.m.util.log.Log;
import com.airbach.m.util.log.LogTag;

public class C {

    private static LogTag TAG = new LogTag(C.class.getName(), C.class.getSimpleName(), Thread.currentThread());

    public static Typeface global_font;

    public static int width;
    public static int height;
    public static float density;

    @SuppressWarnings("deprecation")
    public static void init(Context context) {
        //display init
        Display display = ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        Point size = new Point();
        if (Build.VERSION.SDK_INT >= 13) {
            display.getSize(size);
            C.width = size.x;
            height = size.y;
        } else {
            width = display.getWidth();
            height = display.getHeight();
        }
        density = context.getResources().getDisplayMetrics().density;

        //font init
        if (C.global_font == null) {
            try {
                C.global_font = Typeface.createFromAsset(context.getAssets(), "fonts/Moebius_Regular_kor.ttf");
            } catch (Throwable t) {
            }
        }

        Log.i(TAG, "*****************************************");
        Log.i(TAG, "Build.MANUFACTURER : " + Build.MANUFACTURER);
        Log.i(TAG, "width : " + C.width);
        Log.i(TAG, "height : " + C.height);
        Log.i(TAG, "density : " + C.density);
        Log.i(TAG, "*****************************************");
    }





    public static final int LOW_DPI_STATUS_BAR_HEIGHT    = 19;
    public static final int MEDIUM_DPI_STATUS_BAR_HEIGHT = 25;
    public static final int HIGH_DPI_STATUS_BAR_HEIGHT   = 38;
}
