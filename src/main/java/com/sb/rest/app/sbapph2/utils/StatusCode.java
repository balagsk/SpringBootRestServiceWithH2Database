package com.sb.rest.app.sbapph2.utils;

public class StatusCode {


    public String responseCode;
    public String responseMessage;
    public String getResponseCode() {
        return responseCode;
    }

    public StatusCode(String responseCode, String responseMessage) {
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }
}
