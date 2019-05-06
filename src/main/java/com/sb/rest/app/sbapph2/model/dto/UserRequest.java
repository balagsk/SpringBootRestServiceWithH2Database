package com.sb.rest.app.sbapph2.model.dto;


import com.fasterxml.jackson.annotation.JsonRootName;
import com.sb.rest.app.sbapph2.model.User;

@JsonRootName("request")
public class UserRequest {
private static final long serialVersionUID=1L;
  /*  public AdminDTO adminInfo;*/
    public UserDto userInfo;

   /* public UserRequest() {
    }

    public UserRequest(AdminDTO adminInfo) {
        this.adminInfo = adminInfo;
    }

    public User UserRequest(AdminDTO adminInfo) {
        User user=new User();
        user.setAPPID(adminInfo.getAPPID());
        user.setGROUPID(adminInfo.getGROUPID());
        user.setUSERID(adminInfo.getUSERID());
        return user;
    }*/

   /* public AdminDTO getAdminInfo() {
        return adminInfo;
    }

    public void setAdminInfo(AdminDTO adminInfo) {
        this.adminInfo = adminInfo;
    }*/

    public UserDto getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserDto userInfo) {
        this.userInfo = userInfo;
    }

    @Override
    public String toString() {
        return "UserRequest{" +
               // "adminInfo=" + adminInfo +
                "userInfo=" + userInfo +
                '}';
    }
}
