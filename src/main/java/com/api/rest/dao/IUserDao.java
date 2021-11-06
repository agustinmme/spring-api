package com.api.rest.dao;

import com.api.rest.models.User;

import java.util.List;

public interface IUserDao {

    List<User> getAll();

    void deleteUser(Long id);

    void addUser(User user);

    User getUser(User user);

}
