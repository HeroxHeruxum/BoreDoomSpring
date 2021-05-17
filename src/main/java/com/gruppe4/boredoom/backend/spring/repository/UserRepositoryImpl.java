package com.gruppe4.boredoom.backend.spring.repository;

import com.gruppe4.boredoom.backend.spring.model.user.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    List<User> users = generateUserList();

    @Override
    public User findUserById(String id) {
        for (User user : users) {
            if (user.getUserName().equals(id)) {
                return user;
            }
        }

        return null;
    }

    @Override
    public List<User> getAllUser() {
        return users;
    }

    @Override
    public void saveUser(User user) {
        users.add(user);
    }

    @Override
    public boolean existsById(String id) {
        for (User user : users) {
            if (user.getUserName().equals(id)) {
                return true;
            }
        }
        return false;
    }

    private User generateMockUser(String id) {
        return new User(id, "test@test.de", "123", new Date(), Collections.emptyList());
    }

    private List<User> generateUserList() {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            users.add(generateMockUser(String.valueOf(i)));
        }
        return users;
    }
}
