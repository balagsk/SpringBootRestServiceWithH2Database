package com.sb.rest.app.sbapph2.consts;

public class Constants {

    //Applicaiton Policies
    public static final int PASSWORD_LENGTH=8;
    public static final int GROUPID_MIN_MAX_LENGTGH=6;
    public static final int APPID_MIN_MAX_LENGTGH=3;
    public static final int USERID_MIN_LENGTGH=6;

    //Role Configuration
    public static final int GIT_ADMIN_ROLE=1000;
    public static final int GIT_OPERATOR_ROLE=1001;
    public static final int GIT_SUPPORT_ROLE=1002;
    public static final int GIM_ADMIN_ROLE=1000;
    public static final int GIM_OPERATOR_ROLE=1001;
    public static final int GIM_SUPPORT_ROLE=1002;

    //Response Code
    public static final String OPERATION_SUCCESS="100";
    public static final String OPERATION_FAILED="101";
    public static final String APPID_INVALID="102";
    public static final String GROUPID_INVALID="103";
    public static final String USERID_INVALID="104";

    //Application Configuration
    public static final String PARAMETER_MISSING="110";
}
