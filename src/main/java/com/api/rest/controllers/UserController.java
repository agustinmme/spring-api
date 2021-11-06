package com.api.rest.controllers;

import com.api.rest.dao.IUserDao;
import com.api.rest.models.User;
import com.api.rest.utils.JWTUtil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class UserController {

    @Autowired
    private IUserDao IUserDao;

    @Autowired
    private JWTUtil jwtUtil;


    private boolean valToken(String token){
        String userId = jwtUtil.getKey(token);
        return token != null;

    }

    @RequestMapping(value = "api-test/user/{id}",method = RequestMethod.GET)
    public User getUser(@PathVariable Long id){
        User user = new User();
        user.setId(id);
        user.setName("raul");
        user.setLastname("mansilla");
        user.setEmail("raul@gmail.com");
        user.setPhone("3232323");
        user.setPassword("raul");
        return user;
    }

    @RequestMapping(value = "api-test/users",method = RequestMethod.GET)
    public List<User> getAll(@RequestHeader(value="Authorization")String token){
       if(!valToken(token)){
           return null;
       }
       return IUserDao.getAll();
    }

    @RequestMapping(value = "api-test/user/{id}",method = RequestMethod.DELETE)
    public void deleteUser(@RequestHeader(value="Authorization")String token,@PathVariable Long id){
        if(!valToken(token)){
            return;
        }
        IUserDao.deleteUser(id);
    }

    @RequestMapping(value = "api-test/user/register",method = RequestMethod.POST)
    public void addUser(@RequestBody User user){

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(2,1024,2,user.getPassword());
        user.setPassword(hash);
        IUserDao.addUser(user);
    }


    @RequestMapping(value = "user323")
    public User edit(){
        User user = new User();
        user.setName("raul");
        user.setLastname("mansilla");
        user.setEmail("raul@gmail.com");
        user.setPhone("3232323");
        user.setPassword("raul");
        return user;
    }



}
