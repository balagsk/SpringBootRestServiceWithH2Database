package com.sb.rest.app.sbapph2.model.dto;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.sb.rest.app.sbapph2.model.User;
import com.sb.rest.app.sbapph2.utils.StatusCode;

@JsonRootName("response")
public class UserResponse {
    public StatusCode statusDetails;
    public  UserDto userDetails;

    public User UserResponse(UserDto userDto){
        User user=new User();
        user.setGROUPID(userDto.getGROUPID());
        user.setAPPID(userDto.getAPPID());
        user.setUSERID(userDto.getUSERID());
        user.setNAME(userDto.getNAME());
        user.setADDRESS(userDto.getADDRESS());
        user.setCOUNTRY(userDto.getCOUNTRY());
        userDto.setROLEID(userDto.getROLEID());
        user.setEMAIL(userDto.getEMAIL());
        user.setPASSWORD(userDto.getPASSWORD());
        user.setCREATEDDATE(userDto.getCREATEDDATE());
        user.setMODIFIEDDATE(userDto.getMODIFIEDDATE());
         return user;
    }

    /*public UserResponse StatusCode(String responseCode, String responseMessage){
        StatusCode status=new StatusCode(responseCode,responseMessage);

        return status;

    }*/

    public StatusCode getStatusDetails() {
        return statusDetails;
    }

    public void setStatusDetails(StatusCode statusDetails) {
        this.statusDetails = statusDetails;
    }

    public UserDto getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDto userDetails) {
        this.userDetails = userDetails;
    }




}
