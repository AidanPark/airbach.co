package com.airbach.m.net;

import java.util.Map;

import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import rx.Observable;

/**
 * @author : Aidan(airbach.co@gmail.com)
 * @version : 1.0
 * @date : 2016-04-27.
 */
public interface Net {

//    String POST_HEADER_CONNECTION = "Connection : Keep-Alive";
//    String POST_HEADER_ACCEPT_CHARSET = "Accept-Charset : UTF-8";
//    String POST_HEADER_CONTENTTYPE = "Content-Type : application/x-www-form-urlencoded; charset=EUC-KR";
//
//    @FormUrlEncoded()
//    @POST(NetClient.IFS_TS_COMMON)
//    @Headers({POST_HEADER_CONNECTION, POST_HEADER_ACCEPT_CHARSET, POST_HEADER_CONTENTTYPE})
//    Observable<IFS_TS_COMMON_R_VERSION_RES> call_TS_COMMON_R_VERSION_REQ(@FieldMap Map<String, String> params);
//
//    @FormUrlEncoded()
//    @POST(NetClient.IFS_TS_COMMON)
//    @Headers({POST_HEADER_CONNECTION, POST_HEADER_ACCEPT_CHARSET, POST_HEADER_CONTENTTYPE})
//    Observable<IFS_TS_COMMON_R_BULLETIN_RES> call_TS_COMMON_R_BULLETIN_REQ(@FieldMap Map<String, String> params);
//
//    @FormUrlEncoded()
//    @POST(NetClient.IFS_TS_COMMON)
//    @Headers({POST_HEADER_CONNECTION, POST_HEADER_ACCEPT_CHARSET, POST_HEADER_CONTENTTYPE})
//    Observable<IFS_TS_COMMON_C_CERT_SMS_RES> call_TS_COMMON_C_CERT_SMS_REQ(@FieldMap Map<String, String> params);
//
//    @FormUrlEncoded()
//    @POST(NetClient.IFS_TS_COMMON)
//    @Headers({POST_HEADER_CONNECTION, POST_HEADER_ACCEPT_CHARSET, POST_HEADER_CONTENTTYPE})
//    Observable<IFS_TS_COMMON_C_CERT_SMS_VERIFY_RES> call_TS_COMMON_C_CERT_SMS_VERIFY_REQ(@FieldMap Map<String, String> params);
//
//    @FormUrlEncoded()
//    @POST(NetClient.IFS_TS_COMMON)
//    @Headers({POST_HEADER_CONNECTION, POST_HEADER_ACCEPT_CHARSET, POST_HEADER_CONTENTTYPE})
//    Observable<IFS_TS_COMMON_R_AUTH_RES> call_TS_COMMON_R_AUTH_REQ(@FieldMap Map<String, String> params);
//
//    @FormUrlEncoded()
//    @POST(NetClient.IFS_TS_COMMON)
//    @Headers({POST_HEADER_CONNECTION, POST_HEADER_ACCEPT_CHARSET, POST_HEADER_CONTENTTYPE})
//    Observable<IFS_TS_COMMON_R_JOIN_TSHARE_RES> call_TS_COMMON_R_JOIN_TSHARE_REQ(@FieldMap Map<String, String> params);
//
//    @FormUrlEncoded()
//    @POST(NetClient.IFS_TS_CSMS)
//    @Headers({POST_HEADER_CONNECTION, POST_HEADER_ACCEPT_CHARSET, POST_HEADER_CONTENTTYPE})
//    Observable<IFS_TS_CSMS_R_CALLFW_RES> call_TS_CSMS_R_CALLFW_REQ(@FieldMap Map<String, String> params);
//
//    @FormUrlEncoded()
//    @POST(NetClient.IFS_TS_CSMS)
//    @Headers({POST_HEADER_CONNECTION, POST_HEADER_ACCEPT_CHARSET, POST_HEADER_CONTENTTYPE})
//    Observable<IFS_TS_CSMS_C_CALLFW_HANDHELD_RES> call_TS_CSMS_C_CALLFW_HANDHELD_REQ(@FieldMap Map<String, String> params);
//
//    @FormUrlEncoded()
//    @POST(NetClient.IFS_TS_CSMS)
//    @Headers({POST_HEADER_CONNECTION, POST_HEADER_ACCEPT_CHARSET, POST_HEADER_CONTENTTYPE})
//    Observable<IFS_TS_CSMS_C_CALLFW_WEARABLE_RES> call_TS_CSMS_C_CALLFW_WEARABLE_REQ(@FieldMap Map<String, String> params);
//
//    @FormUrlEncoded()
//    @POST(NetClient.IFS_TS_COMMON)
//    @Headers({POST_HEADER_CONNECTION, POST_HEADER_ACCEPT_CHARSET, POST_HEADER_CONTENTTYPE})
//    Observable<IFS_TS_COMMON_R_JOIN_ONENUMBER_RES> call_TS_COMMON_R_JOIN_ONENUMBER_REQ(@FieldMap Map<String, String> params);
//
//    @FormUrlEncoded()
//    @POST(NetClient.IFS_TS_CSMS2)
//    @Headers({POST_HEADER_CONNECTION, POST_HEADER_ACCEPT_CHARSET, POST_HEADER_CONTENTTYPE})
//    Observable<IFS_TS_CSMS2_R_ONENUMBER_RES> call_TS_CSMS2_R_ONENUMBER_REQ(@FieldMap Map<String, String> params);
//
//    @FormUrlEncoded()
//    @POST(NetClient.IFS_TS_CSMS2)
//    @Headers({POST_HEADER_CONNECTION, POST_HEADER_ACCEPT_CHARSET, POST_HEADER_CONTENTTYPE})
//    Observable<IFS_TS_CSMS2_C_ONENUMBER_ON_RES> call_TS_CSMS2_C_ONENUMBER_ON_REQ(@FieldMap Map<String, String> params);
//
//    @FormUrlEncoded()
//    @POST(NetClient.IFS_TS_CSMS2)
//    @Headers({POST_HEADER_CONNECTION, POST_HEADER_ACCEPT_CHARSET, POST_HEADER_CONTENTTYPE})
//    Observable<IFS_TS_CSMS2_C_ONENUMBER_OFF_RES> call_TS_CSMS2_C_ONENUMBER_OFF_REQ(@FieldMap Map<String, String> params);
}
