package com.gmail.etauroginskaya.finalcontrolwork.repository;

import com.gmail.etauroginskaya.finalcontrolwork.repository.model.User;

public interface UserRepository extends GenericRepository<Long, User> {

    User getUserByUsername(String username);
}
