package com.airbach.m;

import android.app.Application;

import com.airbach.m.c.C;
import com.airbach.m.net.NetLRUCache;
import com.airbach.m.util.log.Log;

import org.acra.ACRA;
import org.acra.ReportField;
import org.acra.ReportingInteractionMode;
import org.acra.annotation.ReportsCrashes;

/**
 * @author : Aidan(airbach.co@gmail.com)
 * @version : 1.0
 * @date : 2016-04-27.
 */

/*
 * 오류 리포트를 어떻게 할것인지에 대한 고민이 필요하다.
 */
@ReportsCrashes(formKey = ""
        , mailTo = "airbach.co@gmail.com"
        , customReportContent = {
        ReportField.APP_VERSION_CODE,
        ReportField.APP_VERSION_NAME,
        ReportField.ANDROID_VERSION,
        ReportField.PHONE_MODEL,
        ReportField.AVAILABLE_MEM_SIZE,
        ReportField.STACK_TRACE,
        ReportField.BUILD,
        ReportField.SHARED_PREFERENCES
}
        , mode = ReportingInteractionMode.TOAST
        , forceCloseDialogAfterToast = false
        , resToastText = R.string.acra_crash_toast_text
)
public class AR extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Log.init(BuildConfig.DEBUG);

        C.init(getApplicationContext());

        //clear network cache.
        NetLRUCache.getInstance().evictAll();
    }
}
