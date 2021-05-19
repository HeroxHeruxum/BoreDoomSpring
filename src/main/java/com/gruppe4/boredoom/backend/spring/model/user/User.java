package com.gruppe4.boredoom.backend.spring.model.user;

import com.gruppe4.boredoom.backend.spring.model.Media;

import java.util.Date;
import java.util.List;

public class User {

    private long id;
    private String userName;
    private String email;
    private String password;
    private Date registrationDate;
    private List<Media> favorites;

    public User() {}

    public User(long id, String userName, String email, String password, Date registrationDate,
            List<Media> favorites) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.registrationDate = registrationDate;
        this.favorites = favorites;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Media> getFavorites() {
        return favorites;
    }

    public void setFavorites(List<Media> favorites) {
        this.favorites = favorites;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
