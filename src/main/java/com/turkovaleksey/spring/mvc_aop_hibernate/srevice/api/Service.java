package com.turkovaleksey.spring.mvc_aop_hibernate.srevice.api;

import java.util.List;

public interface Service<T> {
    List<T> getAll();
    void saveOrUpdate(T entity);
    T getByID(Integer id);
    void deleteById(Integer id);
}
