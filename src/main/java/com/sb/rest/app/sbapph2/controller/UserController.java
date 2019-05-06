package com.sb.rest.app.sbapph2.controller;

import com.sb.rest.app.sbapph2.consts.Constants;
import com.sb.rest.app.sbapph2.dao.UserDAO;
import com.sb.rest.app.sbapph2.model.User;
import com.sb.rest.app.sbapph2.model.dto.*;
import com.sb.rest.app.sbapph2.utils.CommonUtils;
import com.sb.rest.app.sbapph2.utils.StatusCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

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
        logger.debug("JSON Request : "+userRequest);
        UserResponse userResponse=null;
        System.out.println("Print user request : "+userRequest.toString());
        // AdminDTO adminDto=userRequest.getAdminInfo(); //Admin login using AGUID.
        User userInput=userRequest.getUserInfo();
        boolean validAdmin=true;
        //AdminLogin is success, create new user
        if(validAdmin) {
            User newUser = userDao.saveUser(userInput); //new User using UserInfo
            UserDto userDtoInfo=new UserDto(newUser.getAPPID(),newUser.getGROUPID(),newUser.getUSERID());
            userResponse.setUserDetails(userDtoInfo);
            userResponse.setStatusDetails(new StatusCode(Constants.OPERATION_SUCCESS,"Created successfully"));   //Enum for status messages
        }else{
            userResponse.setStatusDetails(new StatusCode(Constants.OPERATION_FAILED,"Invalid Admin login, and Failed to create user"));
        }
        //Get Response Code & Fetch it in JSON response
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
        updateOldUser.setAPPID(userUpdate.getAPPID());
        updateOldUser.setGROUPID(userUpdate.getGROUPID());
        updateOldUser.setROLEID(userUpdate.getROLEID());
        updateOldUser.setADDRESS(userUpdate.getADDRESS());
        updateOldUser.setEMAIL(userUpdate.getEMAIL());
        updateOldUser.setMODIFIEDDATE(userUpdate.getMODIFIEDDATE());
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
