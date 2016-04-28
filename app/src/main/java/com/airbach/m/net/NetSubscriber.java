package com.airbach.m.net;

import com.airbach.m.util.log.Log;
import com.airbach.m.util.log.LogTag;

import javax.net.ssl.SSLException;

import rx.Subscriber;

/**
 * @author : Aidan(airbach.co@gmail.com)
 * @version : 1.0
 * @date : 2016-04-27.
 */
public abstract class NetSubscriber<T> extends Subscriber<T> {

    private LogTag TAG = new LogTag(this.getClass().getName(), this.getClass().getSimpleName(), Thread.currentThread());

    @Override
    public void onCompleted() {
    }

    @Override
    public void onError(Throwable t) {
        if (t instanceof SSLException) {
            onSSLException(t);
        } else {
            onException(t);
        }
    }

    @Override
    public void onNext(T t) {
        Log.d(TAG, "#### onNext(T t) ####");
        Log.d(TAG, t.toString());

        if (t instanceof NetResponse) {
            ((NetResponse) t).decode();

            if (((NetResponse) t).is(ResCode.RESULT_SUCC)) {
                onResponse(t);
                return;
            } else {
                if (((NetResponse) t).result == null || ((NetResponse) t).is(ResCode.RESULT_FAIL_SESSION_EXPIRED)) {
                    NetClient.clearSession();
                    onSessionExpired();
                } else {
                    onError(t);
                }
                return;
            }
        }

        onException(new IllegalArgumentException("Result object type ambiguous. " + t.getClass().getName()));
    }

    public abstract void onResponse(T response);

    public abstract void onError(T response);

    public abstract void onException(Throwable t);

    public abstract void onSSLException(Throwable t);

    /**
     * 세션 만료.
     */
    public abstract void onSessionExpired();

}
