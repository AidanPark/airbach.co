package com.airbach.m.net;

/**
 * <p>서버 result code
 * <p>각 서비스 마다 코드와 실제 상황이 일치하지 않을 수 있다.
 *
 * @author SeungUp. Park(supark@moent.com)
 * @version : 1.0
 */
public class ResCode {

	public static final String JSON_RESULT_MISSING = "10000";

	public static final String JSON_RESULT_TEXT_MISSING = "10001";

	public static final String JSON_RESULT_HEADER_MISSING = "10002";

	public static final String JSON_RESULT_CONFIRM_MISSING = "10003";

	public static final String JSON_REQUIRED_PARAMETER_MISSING = "10004";

	public static final String JSON_REQUIRED_PARAMETER_INVALID = "10005";

	public static final String RESULT_MISSING = "20000";

	public static final String RESULT_TEXT_MISSING = "20001";

	public static final String RESULT_HEADER_MISSING = "20002";

	public static final String RESULT_CONFIRM_MISSING = "20003";

	public static final String RESULT_TEXT_DECODE_FAIL = "20004";

	public static final String RESULT_HEADER_DECODE_FAIL = "20005";

	public static final String REQUIRED_PARAMETER_MISSING = "20006";

	public static final String REQUIRED_PARAMETER_DECODE_FAIL = "20007";

	//###################################################################################################
	//공통
	//###################################################################################################

	//성공
	public static final String RESULT_SUCC = "0";

	//실패. resulttext 참조.
	public static final String RESULT_FAIL = "1";

	//개인인증 실패
	public static final String RESULT_FAIL_CERT = "99";

	//잘못된 전화번호
	public static final String RESULT_FAIL_WRONG_NUMBER = "300";

	//세션 끊김
	public static final String RESULT_FAIL_SESSION_EXPIRED = "100";

	//op 오류
	public static final String RESULT_FAIL_WRONG_REQ_OP = "101";

	//divi 오류
	public static final String RESULT_FAIL_WRONG_REQ_DIVI = "102";

	//type 오류
	public static final String RESULT_FAIL_WRONG_REQ_TYPE = "103";

	//sms 인증 오류
	public static final String RESULT_FAIL_CERT_SMS = "105";

	//service code 오류. 파라미터 오류. (서비스 가입/해지시 서비스 코드 없음)
	public static final String RESULT_FAIL_CERT_SVCCODE = "106";

	//알수없는 오류
	public static final String RESULT_FAIL_UNKNOWN = "999";

	//###################################################################################################
	//부가서비스 조회(ngcp)
	//###################################################################################################

	//입력 파라미터 정보 오류
	public static final String UAPROFILE_INVALID_PARAMETER = "31";

	//등록된 MDN번호가 아님 (SKT 고객 아님)
	public static final String MOBILE_RES_NOT_SKT_MEMBER = "40";

	//등록된 MIN 번호가 아님 (SKT 고객 아님)
	public static final String MOBILE_RES_INVALID_MIN = "41";

	//등록된 CP가 아님
	public static final String CP_RES_NOT_REGIST = "50";

	//비밀번호가 유효하지 않음
	public static final String CP_RES_INVALID_PASSCP = "51";

	//권한이 없권한이 없는 CP입니다.
	public static final String CP_RES_NOT_AUTHORIZE = "52";

	//SKT 명의자 주민번호와 다름
	public static final String SKT_RES_INVALID_PERSON_ID = "80";

	public static final String SKT_RES_INVALID_PERSON_ID2 = "81";

	//해당 부가서비스가 존재하지 않음
	public static final String SERVICE_RES_NOT_EXIST = "90";

	//해당 부가서비스 고객이 아님
	public static final String SERVICE_RES_NOT_SERVICE_MEMBER = "91";

	//SKT에 등록된 Client ID가 아닙니다.
	public static final String UAPROFILE_RES_INVALID_CLIENTID = "110";

	//SKT에 등록된 IMSI가 아님
	public static final String UAPROFILE_RES_INVALID_IMSI = "120";

	//모든 Connection이 사용중입니다.
	public static final String ALL_CONNECTION_USED = "250";

	//ConnectionPool이 생성되지 않았습니다.
	public static final String CONNECTIONPOOL_IS_NOT_CREATED = "251";

	//단말정보가 명확하지 않음
	public static final String MOBILE_RES_INSUFFICIENT_INFORM = "252";

	//조회 시 오류 발생
	public static final String DB_CONNECT_ERRORDB = "253";

	//(MOBILE_RES_ERROR)정의되지 않은 오류
	public static final String CP_RES_ERROR = "254";

	//세션만료
	public static final String RESULT_SESSION_EXPIRED = "300";

	//사용중인 컨텐츠 삭제시
	public static final String RESULT_400 = "400";

	public static final String RESULT_401 = "401";

	//미가입시
	public static final String RESULT_404 = "404";

	//미가입시
	public static final String RESULT_1000 = "1000";
}
