package com.sb.rest.app.sbapph2.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name="PERSON")
@EntityListeners(AuditingEntityListener.class)
public class User {
    private String APPID;
    private String GROUPID;
   /*  @TableGenerator(name = "userid",initialValue = 15001500,allocationSize = 1)*/
    /*@SequenceGenerator(name="userid_seq",initialValue = 10007000,allocationSize = 1)*/

 //*   @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "userid_seq")*/
    @Id
    private String USERID;
 /*   @NotNull(message = "Name should not be blank")
    @Size(min = 5,max = 15,message = "Name should contain min 5 and max 50")*/
    private String NAME;
    private String ADDRESS;
    private String COUNTRY;
    private String ROLEID;
  /*  @NotNull(message = "email must be entered")*/
    private String EMAIL;
/*    @NotNull(message = "Password should not be blank")
    @Size(min = 5,max = 8,message = "Password should contain min 5 and max 8")*/
    private String PASSWORD;

   /* @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate*/
    private String CREATEDDATE;

   /* @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate*/
    private String MODIFIEDDATE;

    public String getUSERID() {
        return USERID;
    }

    public void setUSERID(String USERID) {
        this.USERID = USERID;
    }

    public String getCREATEDDATE() {
        return CREATEDDATE;
    }

    public void setCREATEDDATE(String CREATEDDATE) {
        this.CREATEDDATE = CREATEDDATE;
    }

    public String getMODIFIEDDATE() {
        return MODIFIEDDATE;
    }

    public void setMODIFIEDDATE(String MODIFIEDDATE) {
        this.MODIFIEDDATE = MODIFIEDDATE;
    }


    public String getAPPID() {
        return APPID;
    }

    public void setAPPID(String APPID) {
        this.APPID = APPID;
    }

    public String getGROUPID() {
        return GROUPID;
    }

    public void setGROUPID(String GROUPID) {
        this.GROUPID = GROUPID;
    }

      public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getADDRESS() {
        return ADDRESS;
    }

    public void setADDRESS(String ADDRESS) {
        this.ADDRESS = ADDRESS;
    }

    public String getCOUNTRY() {
        return COUNTRY;
    }

    public void setCOUNTRY(String COUNTRY) {
        this.COUNTRY = COUNTRY;
    }

    public String getROLEID() {
        return ROLEID;
    }

    public void setROLEID(String ROLEID) {
        this.ROLEID = ROLEID;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

    @Override
    public String toString() {
        return "User{" +
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
