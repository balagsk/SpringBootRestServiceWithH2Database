package com.sb.rest.app.sbapph2.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.sb.rest.app.sbapph2.model.User;


@JsonRootName("adminInfo")
public class AdminDTO extends User {
    public static String appId;
    public static String groupId;
    public static String userId;
    @JsonProperty("password")
    public static String pwd;

    public static String getAppId() {
        return appId;
    }

    public static void setAppId(String appId) {
        AdminDTO.appId = appId;
    }

    public static String getGroupId() {
        return groupId;
    }

    public static void setGroupId(String groupId) {
        AdminDTO.groupId = groupId;
    }

    public static String getUserId() {
        return userId;
    }

    public static void setUserId(String userId) {
        AdminDTO.userId = userId;
    }

    public static String getPwd() {
        return pwd;
    }

    public static void setPwd(String pwd) {
        AdminDTO.pwd = pwd;
    }


}
