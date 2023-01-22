package com.faboda.query.service;

import com.faboda.query.model.User;
import com.faboda.query.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;




    public void saveUser(User  user){
        try{
            userRepository.save(user);

        }
        catch (Exception e){
            System.out.println("Faiiled");
        }
    }

    public String getUser(User user){

        User foundUser =  userRepository.findByUserNameAndPassword(user.getUserName(),user.getPassword());
        if(foundUser!=null){
            return "Success";
        }

        return "fail";
    }







}
