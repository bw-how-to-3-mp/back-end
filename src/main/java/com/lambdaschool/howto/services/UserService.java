package com.lambdaschool.howto.services;

import com.lambdaschool.howto.models.User;

import java.util.List;

public interface UserService
{
    List<User> findAll();

    List<User> findByNameContaining(String username);

    User findByUsername(String username);

    User findUserById(long id);

    void delete(long id);

    User save(User user);

    void addRoleAdmin(long id);
}
