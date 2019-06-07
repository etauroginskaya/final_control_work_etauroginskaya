package com.gmail.etauroginskaya.finalcontrolwork.service;

import com.gmail.etauroginskaya.finalcontrolwork.service.model.UserDTO;

public interface UserService {

    UserDTO getUserByUsername(String username);
}
