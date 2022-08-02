package com.turkovaleksey.spring.mvc_aop_hibernate.srevice.impl;

import com.turkovaleksey.spring.mvc_aop_hibernate.dao.api.Dao;
import com.turkovaleksey.spring.mvc_aop_hibernate.entity.Employee;
import com.turkovaleksey.spring.mvc_aop_hibernate.srevice.api.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@org.springframework.stereotype.Service
public class EmployeeServiceImpl implements Service<Employee> {

    @Autowired
    private Dao dao;

    @Override
    @Transactional
    public List<Employee> getAll() {
        return dao.gelAll();
    }

    @Override
    @Transactional
    public void saveOrUpdate(Employee entity) {
        dao.saveOrUpdate(entity);
    }

    @Override
    @Transactional
    public Employee getByID(Integer id) {
        return (Employee) dao.getByID(id);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        dao.deleteById(id);
    }


}
