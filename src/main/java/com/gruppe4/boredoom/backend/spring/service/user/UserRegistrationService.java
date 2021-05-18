package com.gruppe4.boredoom.backend.spring.service.user;

import com.gruppe4.boredoom.backend.spring.error.UserRegistrationException;
import com.gruppe4.boredoom.backend.spring.model.user.User;
import com.gruppe4.boredoom.backend.spring.model.user.UserRegistrationData;
import com.gruppe4.boredoom.backend.spring.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;

@Service
public class UserRegistrationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserRegistrationService(UserRepository userRepository,
            PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerUser(UserRegistrationData userRegistrationData) throws UserRegistrationException {

        if (userAlreadyExists(userRegistrationData.getUsername())) {
            throw new UserRegistrationException("User already exists");
        }

        try {
            userRepository.saveUser(buildUser(userRegistrationData));
        } catch (RuntimeException e) { // TODO: Richtige Exception abfangen
            throw new UserRegistrationException("Error while saving to database");
        }

    }

    private User buildUser(UserRegistrationData userRegistrationData) {
        User user = new User();

        user.setEmail(userRegistrationData.getEmail());
        user.setPassword(passwordEncoder.encode(userRegistrationData.getPassword()));
        user.setRegistrationDate(new Date()); // TODO: Datum formatieren
        user.setUserName(userRegistrationData.getUsername());
        user.setFavorites(Collections.emptyList());

        return user;
    }

    private boolean userAlreadyExists(String username) {
        return userRepository.existsByUsername(username);
    }
}
