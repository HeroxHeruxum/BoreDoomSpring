package com.gruppe4.boredoom.backend.spring.repository;

import com.gruppe4.boredoom.backend.spring.model.user.User;

import java.util.List;

public interface UserRepository {

    User findUserById(String id);

    List<User> getAllUser();

    void saveUser(User user);

    boolean existsByUsername(String username);

}
