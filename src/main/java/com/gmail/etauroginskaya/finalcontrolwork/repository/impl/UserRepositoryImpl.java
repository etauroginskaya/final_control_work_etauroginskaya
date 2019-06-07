package com.gmail.etauroginskaya.finalcontrolwork.repository.impl;

import com.gmail.etauroginskaya.finalcontrolwork.repository.UserRepository;
import com.gmail.etauroginskaya.finalcontrolwork.repository.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;

@Repository
public class UserRepositoryImpl extends GenericRepositoryImpl<Long, User> implements UserRepository {

    @Override
    public User getUserByUsername(String username) {
        String hql = "FROM User AS U WHERE U.username=:username";
        Query query = entityManager.createQuery(hql)
                .setParameter("username", username);
        return (User) query.getSingleResult();
    }
}