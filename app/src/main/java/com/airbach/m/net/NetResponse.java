package com.airbach.m.net;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * @author : Aidan(airbach.co@gmail.com)
 * @version : 1.0
 * @date : 2016-04-27.
 */
public abstract class NetResponse {

    public String result;
    public String resulttext;
    public String header;
    public int confirm;

    public boolean is(String resCode) {
        if (result == null) {
            return false;
        }
        return result.equals(resCode);
    }

    public void decode() {
        try {
            resulttext = decode(resulttext);
        } catch (UnsupportedEncodingException e) {
        } catch (NullPointerException e) {
        }

        try {
            header = decode(header);
        } catch (UnsupportedEncodingException e) {
        } catch (NullPointerException e) {
        }
    }

    protected String decode(String text) throws UnsupportedEncodingException {
        return URLDecoder.decode(text, "utf-8").replaceAll("§", " ");
    }

    @Override
    public String toString() {
        return "\nresult='" + result + '\''
                + "\n, resulttext='" + resulttext + '\''
                + "\n, header='" + header + '\''
                + "\n, confirm='" + confirm + '\'';

    }

    public abstract String getDataString();
}
