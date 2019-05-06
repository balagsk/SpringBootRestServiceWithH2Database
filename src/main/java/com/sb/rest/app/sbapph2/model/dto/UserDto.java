package com.sb.rest.app.sbapph2.model.dto;


import com.fasterxml.jackson.annotation.JsonRootName;
import com.sb.rest.app.sbapph2.model.User;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
@JsonRootName("userInfo")
/*@JsonRootName("userInfo")*/
public class UserDto extends User {
    private static final long serialVersionUID=1L;
    private String APPID;
    private String GROUPID;
    private String USERID;  // PK to Alphanumeric e.g BALAGSK01, BALAGSK02
    private String NAME;
    private String ADDRESS;
    private String COUNTRY;
    private String ROLEID;
    private String EMAIL;
    private String PASSWORD;
    private String CREATEDDATE; // Change to String
    private String MODIFIEDDATE;

    public UserDto(String APPID, String GROUPID, String USERID) {
        this.APPID = APPID;
        this.GROUPID = GROUPID;
        this.USERID = USERID;

    }

    public UserDto(){


    }

    @Override
    public String getAPPID() {
        return APPID;
    }

    @Override
    public void setAPPID(String APPID) {
        this.APPID = APPID;
    }

    @Override
    public String getGROUPID() {
        return GROUPID;
    }

    @Override
    public void setGROUPID(String GROUPID) {
        this.GROUPID = GROUPID;
    }

    @Override
    public String getUSERID() {
        return USERID;
    }

    @Override
    public void setUSERID(String USERID) {
        this.USERID = USERID;
    }

    @Override
    public String getNAME() {
        return NAME;
    }


    @Override
    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    @Override
    public String getADDRESS() {
        return ADDRESS;
    }

    @Override
    public void setADDRESS(String ADDRESS) {
        this.ADDRESS = ADDRESS;
    }

    @Override
    public String getCOUNTRY() {
        return COUNTRY;
    }

    @Override
    public void setCOUNTRY(String COUNTRY) {
        this.COUNTRY = COUNTRY;
    }

    @Override
    public String getROLEID() {
        return ROLEID;
    }

    @Override
    public void setROLEID(String ROLEID) {
        this.ROLEID = ROLEID;
    }

    @Override
    public String getEMAIL() {
        return EMAIL;
    }

    @Override
    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    @Override
    public String getPASSWORD() {
        return PASSWORD;
    }

    @Override
    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

    @Override
    public String getCREATEDDATE() {
        return CREATEDDATE;
    }

    @Override
    public void setCREATEDDATE(String CREATEDDATE) {
        this.CREATEDDATE = CREATEDDATE;
    }

    @Override
    public String getMODIFIEDDATE() {
        return MODIFIEDDATE;
    }

    @Override
    public void setMODIFIEDDATE(String MODIFIEDDATE) {
        this.MODIFIEDDATE = MODIFIEDDATE;
    }
    @Override
    public String toString() {
        return "UserDto{" +
                "APPID='" + APPID + '\'' +
                ", GROUPID='" + GROUPID + '\'' +
                ", USERID='" + USERID + '\'' +
                ", NAME='" + NAME + '\'' +
                ", ADDRESS='" + ADDRESS + '\'' +
                ", COUNTRY='" + COUNTRY + '\'' +
                ", ROLEID='" + ROLEID + '\'' +
                ", EMAIL='" + EMAIL + '\'' +
                ", PASSWORD='" + PASSWORD + '\'' +
                ", CREATEDDATE='" + CREATEDDATE + '\'' +
                ", MODIFIEDDATE='" + MODIFIEDDATE + '\'' +
                '}';
    }


}
