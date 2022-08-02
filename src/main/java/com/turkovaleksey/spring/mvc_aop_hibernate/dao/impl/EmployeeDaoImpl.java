package com.turkovaleksey.spring.mvc_aop_hibernate.dao.impl;

import com.turkovaleksey.spring.mvc_aop_hibernate.dao.api.Dao;
import com.turkovaleksey.spring.mvc_aop_hibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements Dao<Employee> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Employee> gelAll() {
        Session session = sessionFactory.getCurrentSession();
        List<Employee> employeeList = session.createQuery("from Employee", Employee.class).getResultList();
        return employeeList;
    }

    @Override
    public void saveOrUpdate(Employee entity) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(entity);
    }

    @Override
    public Employee getByID(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Employee employee = session.get(Employee.class, id);
        return employee;
    }

    @Override
    public void deleteById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Employee> query = session.createQuery("delete from Employee where id =:employeeId" );
        query.setParameter("employeeId", id);
        query.executeUpdate();
    }
}
