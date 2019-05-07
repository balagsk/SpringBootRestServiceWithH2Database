package com.sb.rest.app.sbapph2.controller;

import com.sb.rest.app.sbapph2.consts.Constants;
import com.sb.rest.app.sbapph2.dao.UserDAO;
import com.sb.rest.app.sbapph2.model.User;
import com.sb.rest.app.sbapph2.model.dto.*;
import com.sb.rest.app.sbapph2.utils.StatusCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserDAO userDao;

    @PostMapping("/userlist")
    public List<User> getAllUsers(){

        List<User> userList=new ArrayList<>();
        userList=userDao.findAllUser();
        System.out.println("Controller size : "+userList.size());
        return  userList;
    }

    @PostMapping("/userbyid/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(value="id") String userId)
    {
        User user=userDao.findOne(userId);
        if(user==null){
          return ResponseEntity.notFound().build();
        }
        System.out.println(" getUserById ="+user);
        /*RestTemplate restTemplate = CommonUtils.prepareRestTemplate();
        HttpEntity<User> requestUser=new HttpEntity<>(User);
        String url="";
        ResponseEntity<List> responseEntity=restTemplate.getForObject(ResponseEntity.ok().body(user),User);*/
        return ResponseEntity.ok().body(user);
    }
    @PostMapping("/createuser")
    public UserResponse createUser(@RequestBody UserRequest userRequest) {
        logger.info("Begin Create user operation ");
        logger.debug("Print User Request (userRequest): "+userRequest);
        logger.debug("Print User Request (userRequest.getUserInfo()): "+userRequest.getUserInfo());
        logger.debug("Print User Request (userRequest.getUserInfo().toString): "+userRequest.getUserInfo().toString());
        // AdminDTO adminDto=userRequest.getAdminInfo(); //Admin login using AGUID.
        UserResponse userResponse=new UserResponse();
        boolean validAdmin=true;
        if(validAdmin) {
            User newUser = userDao.saveUser(userRequest.getUserInfo());
            userResponse.setStatusCode(new StatusCode(Constants.OPERATION_SUCCESS,"Created successfully"));
            userResponse.setUserInfo(newUser);
        }else{
            userResponse.setStatusCode(new StatusCode(Constants.OPERATION_FAILED,"Invalid Admin login, and Failed to create user"));
        }
        logger.info("Printing user response : "+userResponse);
        logger.info("End of User registration operation.");
        return userResponse;
    }

    @PostMapping("/CreateAdminUser")
    public ResponseEntity<User> createAdminUser(@RequestBody MultiUserRequest mreq){
        logger.info("Beginning of CreateAdminUser");

        logger.debug("Request toString() : "+mreq.toString());
        logger.debug("getUserroot.toString() : "+mreq.getUser().toString());
        return ResponseEntity.ok().body(mreq.getUser());
    }

    @PostMapping("/deleteuser/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable(value="id") String userId){
       User delUser=userDao.findOne(userId);
          if(delUser==null){
              return ResponseEntity.notFound().build();
          }
        userDao.deleteUser(delUser);
          return ResponseEntity.ok().build();
    }
    @PostMapping("/updateuser/{id}")
    public ResponseEntity<User> updateUser(@PathVariable(value="id") String userId,@Valid @RequestBody User userUpdate){

        User updateOldUser=userDao.findOne(userId);
        if(updateOldUser==null){
            return ResponseEntity.notFound().build();
        }
        updateOldUser.setAppId(userUpdate.getAppId());
        updateOldUser.setGroupId(userUpdate.getGroupId());
        updateOldUser.setRoleId(userUpdate.getRoleId());
        updateOldUser.setAddress(userUpdate.getAddress());
        updateOldUser.setEmail(userUpdate.getEmail());
        updateOldUser.setModifiedDate(userUpdate.getModifiedDate());
        System.out.println("Updated user details : User ="+userUpdate);
        return ResponseEntity.ok().body(userUpdate);
    }


/*
    @PostMapping("/GetUserEmailByUserId")
    public ResponseEntity<User> getUserEmailByUserId(@PathVariable(value="id") Long userId)
    {
        User user=userDao.findOne(userId);
        if(user==null){
            return ResponseEntity.notFound().build();
        }
        System.out.println(" getUserById ="+user);
        */
/*RestTemplate restTemplate = CommonUtils.prepareRestTemplate();
        HttpEntity<User> requestUser=new HttpEntity<>(User);
        String url="";
        ResponseEntity<List> responseEntity=restTemplate.getForObject(ResponseEntity.ok().body(user),User);*//*

        return ResponseEntity.ok().body(user);
    }
*/

}
