package com.gmail.etauroginskaya.finalcontrolwork.service.convertors;

import com.gmail.etauroginskaya.finalcontrolwork.repository.model.User;
import com.gmail.etauroginskaya.finalcontrolwork.service.model.UserDTO;

public interface UserConverter {

    UserDTO toDTO(User user);
}
