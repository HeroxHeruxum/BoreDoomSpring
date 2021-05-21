package com.gruppe4.boredoom.backend.spring.controller;

import com.gruppe4.boredoom.backend.spring.error.MediaSaveException;
import com.gruppe4.boredoom.backend.spring.error.UserLoginException;
import com.gruppe4.boredoom.backend.spring.error.UserRegistrationException;
import com.gruppe4.boredoom.backend.spring.model.Book;
import com.gruppe4.boredoom.backend.spring.model.Media;
import com.gruppe4.boredoom.backend.spring.model.Movie;
import com.gruppe4.boredoom.backend.spring.model.enums.MediaType;
import com.gruppe4.boredoom.backend.spring.model.user.User;
import com.gruppe4.boredoom.backend.spring.model.user.UserLoginData;
import com.gruppe4.boredoom.backend.spring.model.user.UserRegistrationData;
import com.gruppe4.boredoom.backend.spring.repository.UserRepository;
import com.gruppe4.boredoom.backend.spring.service.user.UserLoginService;
import com.gruppe4.boredoom.backend.spring.service.user.UserRegistrationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;

@RestController
public class UserController {

    private final UserLoginService userLoginService;
    private final UserRegistrationService userRegistrationService;
    private final UserRepository userRepository;

    public UserController(UserLoginService userLoginService,
            UserRegistrationService userRegistrationService,
            UserRepository userRepository) {
        this.userLoginService = userLoginService;
        this.userRegistrationService = userRegistrationService;
        this.userRepository = userRepository;
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

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@Valid @RequestBody UserLoginData userLoginData) {

        try {
            userLoginService.loginUser(userLoginData);
        } catch (UserLoginException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/isAuthenticated")
    public boolean isAuthenticated() {
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        return (authentication instanceof UsernamePasswordAuthenticationToken) && authentication.isAuthenticated();
    }

    @GetMapping("/user/favorites/books")
    public ResponseEntity<List<Book>> getUserBooks() {

        if (!isAuthenticated()) {
            return new ResponseEntity<>(Collections.emptyList(), HttpStatus.UNAUTHORIZED);
        }

        var user = getUserFromSession();

        return new ResponseEntity<>(userRepository.findUserBooksByUsername(user.getUserName()), HttpStatus.OK);
    }

    @GetMapping("/user/favorites/movies")
    public ResponseEntity<List<Movie>> getUserMovies() {

        if (!isAuthenticated()) {
            return new ResponseEntity<>(Collections.emptyList(), HttpStatus.UNAUTHORIZED);
        }

        var user = getUserFromSession();

        return new ResponseEntity<>(userRepository.findUserMoviesByUsername(user.getUserName()), HttpStatus.OK);
    }

    @GetMapping("/user/favorites/")
    public ResponseEntity<List<Media>> getUserFavorites() {

        if (!isAuthenticated()) {
            return new ResponseEntity<>(Collections.emptyList(), HttpStatus.UNAUTHORIZED);
        }

        var user = getUserFromSession();

        return new ResponseEntity<>(userRepository.findFavoritesByUsername(user.getUserName()), HttpStatus.OK);
    }

    @GetMapping("/user/data")
    public ResponseEntity<User> getUserData() {

        if (!isAuthenticated()) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        var user = getUserFromSession();
        user.setPassword("<protected>");

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @CrossOrigin("http://localhost:3000")
    @PutMapping("/user/favorites/saveMedia")
    public ResponseEntity<String> saveMedia(@RequestParam long mediaId, @RequestParam MediaType mediaType) {

        if (!isAuthenticated()) {
            return new ResponseEntity<>("No user session", HttpStatus.UNAUTHORIZED);
        }

        var user = getUserFromSession();

        try {
            userRepository.saveFavoriteMedia(mediaId, mediaType, user.getId());
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (MediaSaveException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private User getUserFromSession() {
        var authentication = SecurityContextHolder.getContext().getAuthentication();

        return (User) authentication.getPrincipal();
    }

    @CrossOrigin("http://localhost:3000")
    @PutMapping("/user/favorites/deleteMedia")
    public ResponseEntity<String> deleteMedia(@RequestParam long mediaId, @RequestParam MediaType mediaType){

        if (!isAuthenticated()){
            return new ResponseEntity<>("No user session", HttpStatus.UNAUTHORIZED);
        }
        var user = getUserFromSession();

        try {
            userRepository.deleteFavoriteMedia(mediaId, mediaType, user.getId());
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (MediaSaveException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
