package com.gruppe4.boredoom.backend.spring.error;

public class UserRegistrationException extends Exception {

    public UserRegistrationException() {}

    public UserRegistrationException(String msg) {
        super(msg);
    }
}
