package com.example.partb;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class EmployeeDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void saveEmployee(Employee emp) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(emp);
    }
}
