package com.gmail.etauroginskaya.finalcontrolwork.service.convertors.impl;

import com.gmail.etauroginskaya.finalcontrolwork.repository.model.User;
import com.gmail.etauroginskaya.finalcontrolwork.service.convertors.UserConverter;
import com.gmail.etauroginskaya.finalcontrolwork.service.model.UserDTO;
import org.springframework.stereotype.Component;

@Component
public class UserConverterImpl implements UserConverter {

    @Override
    public UserDTO toDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());
        userDTO.setRole(user.getRole().name());
        return userDTO;
    }
}
