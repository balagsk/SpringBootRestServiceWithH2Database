package com.sb.rest.app.sbapph2.dao;

import com.sb.rest.app.sbapph2.model.User;
import com.sb.rest.app.sbapph2.model.dto.UserDto;
import com.sb.rest.app.sbapph2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDAO {
    @Autowired
    UserRepository userRepo;

    /*Get All Users*/
    public List<User> findAllUser() {
        List<User> userList = new ArrayList<>();
        userList = userRepo.findAll();
        for (User ub : userList) {
            System.out.println("User list in DAO : " + ub);
        }
        System.out.println("findAllUser : userlist size " + userList.size() + "User model : ");
        return userList;
    }
    /*Get User by Id*/
    public User findOne(String userId) {
        //return userRepo.getOne(userId);
        return userRepo.findById(userId).orElse(null);

    }
   /* *//*Create User/Save user*//*
    public User saveUser(User user) {
        return userRepo.save(user);
    }*/

    /*Create User/Save user*/
    public User saveUser(User user) {
        return userRepo.save(user);
    }

    /*Delete user by userId*/
    public void deleteUser(User user) {
        userRepo.delete(user);
    }



}


