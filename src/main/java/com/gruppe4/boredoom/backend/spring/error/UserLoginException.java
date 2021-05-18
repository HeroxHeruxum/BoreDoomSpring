package com.gruppe4.boredoom.backend.spring.error;

public class UserLoginException extends Exception {

    public UserLoginException() {
    }

    public UserLoginException(String msg) {
        super(msg);
    }
}
