package com.gmail.etauroginskaya.finalcontrolwork.service.impl;

import com.gmail.etauroginskaya.finalcontrolwork.repository.UserRepository;
import com.gmail.etauroginskaya.finalcontrolwork.repository.model.User;
import com.gmail.etauroginskaya.finalcontrolwork.service.UserService;
import com.gmail.etauroginskaya.finalcontrolwork.service.convertors.UserConverter;
import com.gmail.etauroginskaya.finalcontrolwork.service.model.UserDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserConverter userConverter;

    public UserServiceImpl(UserRepository userRepository, UserConverter userConverter) {
        this.userRepository = userRepository;
        this.userConverter = userConverter;
    }

    @Override
    @Transactional
    public UserDTO getUserByUsername(String username) {
        User user = userRepository.getUserByUsername(username);
        return userConverter.toDTO(user);
    }
}