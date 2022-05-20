package com.saitej.repos;

import com.saitej.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserRepository {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Transactional
    public int saveUser(User user) {
       int id= (Integer)this.hibernateTemplate.save(user);
       return id;
    }
}
