package com.javaguru.shoppinglist.database;

import com.javaguru.shoppinglist.domain.User;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class HibernateUserRepository {

    private final SessionFactory sessionFactory;

    @Autowired
    public HibernateUserRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public void save(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    public void delete(User user) {
        sessionFactory.getCurrentSession().delete(user);
    }

    public void update(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    public Optional<User> findUserById(Long id) {
        User user = (User) sessionFactory.getCurrentSession().createCriteria(User.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
        return Optional.ofNullable(user);
    }

    public Optional<User> findUserByName(String name) {
        User user = (User) sessionFactory.getCurrentSession().createCriteria(User.class)
                .add(Restrictions.eq("name", name))
                .uniqueResult();
        return Optional.ofNullable(user);
    }

    public boolean ifUserExistByName(String name) {
        String query = "select case when count(*)> 0 " +
                "then true else false end " +
                "from User user where user.name=:name";
        return (boolean) sessionFactory.getCurrentSession().createQuery(query)
                .setString("name", name)
                .setMaxResults(1)
                .uniqueResult();
    }

    public List<User> findAllUsers() {
        return sessionFactory.getCurrentSession().createCriteria(User.class)
                .list();
    }

}
