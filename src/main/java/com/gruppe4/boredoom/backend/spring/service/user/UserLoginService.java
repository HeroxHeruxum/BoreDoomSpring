package com.gruppe4.boredoom.backend.spring.service.user;

import com.gruppe4.boredoom.backend.spring.error.UserLoginException;
import com.gruppe4.boredoom.backend.spring.model.user.User;
import com.gruppe4.boredoom.backend.spring.model.user.UserLoginData;
import com.gruppe4.boredoom.backend.spring.repository.UserRepository;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserLoginService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public UserLoginService(PasswordEncoder passwordEncoder,
            UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    public void loginUser(UserLoginData userLoginData) throws UserLoginException {

        if (!userRepository.existsById(userLoginData.getUsername())) {
            throw new UserLoginException("Username does not exist");
        }

        User user = userRepository.findUserById(userLoginData.getUsername());

        if (!passwordEncoder.matches(userLoginData.getPassword(), user.getPassword())) {
            throw new UserLoginException("Invalid password");
        }

        setUserSession(user);
    }

    private void setUserSession(User user) {
        user.setPassword("<protected>");
        Object principal = user;
        Object credentials = user.getUserName();

        List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority("ROLE_USER"));
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(principal, credentials,
                authorities);

        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}
