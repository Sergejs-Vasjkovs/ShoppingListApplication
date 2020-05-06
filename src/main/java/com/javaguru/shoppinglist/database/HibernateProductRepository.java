package com.javaguru.shoppinglist.database;

import com.javaguru.shoppinglist.domain.Product;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class HibernateProductRepository {

    private final SessionFactory sessionFactory;

    @Autowired
    public HibernateProductRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save(Product product) {
        sessionFactory.getCurrentSession().save(product);
    }

    public Product findProductByName(String name) {
        return (Product) sessionFactory.getCurrentSession().createCriteria(Product.class)
                .add(Restrictions.eq("name", name))
                .uniqueResult();
    }

    public boolean ifProductExistByName(String name) {
        String query = "select case when count(*)> 0 " +
                "then true else false end " +
                "from Product product where product.name=:name";
        return (boolean) sessionFactory.getCurrentSession().createQuery(query)
                .setString("name", name)
                .setMaxResults(1)
                .uniqueResult();
    }

    public Product findProductById(long id) {
        return (Product) sessionFactory.getCurrentSession().createCriteria(Product.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
    }

    public void update(Product product) {
        sessionFactory.getCurrentSession().update(product);
    }

    public void delete(Product product) {
        sessionFactory.getCurrentSession().delete(product);
    }

    public List<Product> findAllProducts() {
        return sessionFactory.getCurrentSession().createCriteria(Product.class)
                .list();
    }

}
