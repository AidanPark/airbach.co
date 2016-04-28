package com.airbach.m.net;

import java.util.HashSet;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author : Aidan(airbach.co@gmail.com)
 * @version : 1.0
 * @date : 2016-04-27.
 */
public class NetClient {

    // private static final String SERVER_URL = "http://ndev.moent.com"; // 개발
    private static final String SERVER_URL = "https://vas.sktelecom.com"; // 상용
    //공통
    public static final String IFS_TS_COMMON = "/IFS/TshareCommon";
    //착신전환
    public static final String IFS_TS_CSMS = "/IFS/TshareCSMSHandler";
    //원넘버
    public static final String IFS_TS_CSMS2 = "/IFS/TshareCSMSP2Handler";
    //통계
    public static final String IFS_TS_STAT = "/IFS/TshareStat";

    public static final String IFS_TS_CNAP = "/IFS/TshareCNAPHandler";

    private static final int CONNECT_TIMEOUT = 10 * 1000;
    private static final int WRITE_TIMEOUT = 5 * 1000;
    private static final int READ_TIMEOUT = 5 * 1000;

    private static Net net;

    //세션 획득시 쿠키 저장.
    private static HashSet<String> cookies;

    public static void clearSession() {
        cookies = null;
    }

    public static boolean isSessioned() {
        return cookies != null;
    }

    public synchronized static Net getClient() {
        if (net == null) {
            //Logging
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            //OkHttpClient
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .connectTimeout(CONNECT_TIMEOUT, TimeUnit.MILLISECONDS)
                    .writeTimeout(WRITE_TIMEOUT, TimeUnit.MILLISECONDS)
                    .readTimeout(READ_TIMEOUT, TimeUnit.MILLISECONDS)
                    .addInterceptor(httpLoggingInterceptor)

                    //수집된 세션아이디 헤더에 추가.
                    .addInterceptor(chain -> {
                        Request.Builder builder = chain.request().newBuilder();
                        System.out.println("cookies :" + cookies);

                        if (cookies != null) {
                            for (String cookie : cookies) {
                                builder.addHeader("Cookie", cookie);
                            }
                        }

                        // Web,Android,iOS 구분을 위해 User-Agent세팅
                        builder.removeHeader("User-Agent").addHeader("User-Agent", "Android");
                        return chain.proceed(builder.build());
                    })

                    //세션아이디 수집.
                    .addInterceptor(chain -> {
                        Response originalResponse = chain.proceed(chain.request());
                        System.out.println("originalResponse.headers(Set-Cookie) :" + originalResponse.headers("Set-Cookie"));

                        if (!originalResponse.headers("Set-Cookie").isEmpty()) {
                            cookies = new HashSet<>();
                            for (String header : originalResponse.headers("Set-Cookie")) {
                                cookies.add(header);
                            }
                        }
                        return originalResponse;
                    })

                    .build();

            //Retrofit
            net = new Retrofit.Builder()
                    .baseUrl(SERVER_URL)
                    .addConverterFactory(GsonConverterFactory.create()) //Json Parser
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create()) //Rxandroid
                    .client(client)
                    .build()
                    .create(Net.class);
        }

        return net;
    }
}
