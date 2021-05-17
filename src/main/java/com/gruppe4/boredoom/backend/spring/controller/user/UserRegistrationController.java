package com.gruppe4.boredoom.backend.spring.controller.user;

import com.gruppe4.boredoom.backend.spring.error.UserRegistrationException;
import com.gruppe4.boredoom.backend.spring.model.user.UserRegistrationData;
import com.gruppe4.boredoom.backend.spring.service.user.UserRegistrationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserRegistrationController {

    private final UserRegistrationService userRegistrationService;

    public UserRegistrationController(UserRegistrationService userRegistrationService) {
        this.userRegistrationService = userRegistrationService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@Valid @RequestBody UserRegistrationData userRegistrationData) {
        try {
            userRegistrationService.registerUser(userRegistrationData);
        } catch (UserRegistrationException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
