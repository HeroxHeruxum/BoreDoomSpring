package com.gruppe4.boredoom.backend.spring.controller.user;

import com.gruppe4.boredoom.backend.spring.error.UserLoginException;
import com.gruppe4.boredoom.backend.spring.model.user.UserLoginData;
import com.gruppe4.boredoom.backend.spring.service.user.UserLoginService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserLoginController {

    private final UserLoginService userLoginService;

    public UserLoginController(UserLoginService userLoginService) {this.userLoginService = userLoginService;}

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@Valid @RequestBody UserLoginData userLoginData) {

        try {
            userLoginService.loginUser(userLoginData);
        } catch (UserLoginException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
