package com.gmail.etauroginskaya.finalcontrolwork.service.impl;

import com.gmail.etauroginskaya.finalcontrolwork.service.UserService;
import com.gmail.etauroginskaya.finalcontrolwork.service.model.AppUserPrincipal;
import com.gmail.etauroginskaya.finalcontrolwork.service.model.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AppUserDetailsService implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(AppUserDetailsService.class);
    private final UserService userService;

    public AppUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final UserDTO user = userService.getUserByUsername(username);
        if (user == null) {
            logger.info("User with email: {} doesn't exist", username);
            throw new UsernameNotFoundException(String.format("User with email: %s doesn't exist", username));
        }
        return new AppUserPrincipal(user);
    }
}