package com.gruppe4.boredoom.backend.spring.repository.mapper;

import com.gruppe4.boredoom.backend.spring.model.user.User;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;

@Component
public class UserMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int i) throws SQLException {
        User user = new User();

        user.setId(rs.getLong("id"));
        user.setPassword(rs.getString("password"));
        user.setUserName(rs.getString("username"));
        user.setEmail(rs.getString("email"));
        user.setRegistrationDate(rs.getDate("registration_date"));
        user.setFavorites(Collections.emptyList());

        return user;
    }
}
