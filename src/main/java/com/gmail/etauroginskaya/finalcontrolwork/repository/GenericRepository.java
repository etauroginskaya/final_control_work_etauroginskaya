package com.gmail.etauroginskaya.finalcontrolwork.repository;

import java.util.List;

public interface GenericRepository<I, T> {

    void persist(T entity);

    void remove(T entity);

    T getById(I id);

    List<T> getAll();
}
