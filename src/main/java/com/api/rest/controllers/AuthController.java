package com.api.rest.controllers;

import com.api.rest.dao.IUserDao;
import com.api.rest.models.User;
import com.api.rest.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    private IUserDao IUserDao;

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "api-test/login",method = RequestMethod.POST)
    public String login(@RequestBody User user){
        User userAuth = IUserDao.getUser(user);
        if(userAuth != null){
            String token = jwtUtil.create(String.valueOf(userAuth.getId()),userAuth.getEmail());
            return token;
        }
        return "Error";
    }

}
