package com.airbach.m.util.log;

/**
 * <p>Logger.
 * <p>메소드네임, 라인넘버, 메시지를 출력한다.
 *
 * @author : Aidan(airbach.co@gmail.com)
 * @version : 1.0
 * @date : 2016-04-27.
 */
public class Log {

    public static boolean DEBUG = false;

    public static void init(boolean debug) {
        Log.DEBUG = debug;
    }

    protected static String getLogMessage(LogTag TAG, String msg) {
        if (TAG != null && TAG.thread != null) {
            try {
                StackTraceElement[] stackTrace = TAG.thread.getStackTrace();
                for (StackTraceElement ste : stackTrace) {
                    String className = ste.getClassName();
                    if (className.contains(TAG.simpleName)) {
                        return ste.getMethodName() + "() [" + ste.getLineNumber() + "]  " + msg;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return msg;
    }

    public static void d(LogTag TAG, String msg) {
        if(DEBUG) {
            android.util.Log.d(TAG.simpleName, getLogMessage(TAG, msg));
        }
    }

    public static void i(LogTag TAG, String msg) {
        if(DEBUG) {
            android.util.Log.i(TAG.simpleName, getLogMessage(TAG, msg));
        }
    }

    public static void v(LogTag TAG, String msg) {
        if(DEBUG) {
            android.util.Log.v(TAG.simpleName, getLogMessage(TAG, msg));
        }
    }

    public static void w(LogTag TAG, String msg) {
        if(DEBUG) {
            android.util.Log.w(TAG.simpleName, getLogMessage(TAG, msg));
            // android.util.Log.wtf
        }
    }

    public static void e(LogTag TAG, String msg) {
        if(DEBUG) {
            android.util.Log.e(TAG.simpleName, getLogMessage(TAG, msg));
        }
    }

    public static void e(LogTag TAG, String msg, Throwable t) {
        if(DEBUG) {
            android.util.Log.e(TAG.simpleName, getLogMessage(TAG, msg), t);
        }
    }

    public static void printStackTrace(Throwable t) {
        if(DEBUG) {
            t.printStackTrace();
        }
    }

}
