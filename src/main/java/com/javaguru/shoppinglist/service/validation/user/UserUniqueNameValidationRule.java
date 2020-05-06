package com.javaguru.shoppinglist.service.validation.user;

import com.javaguru.shoppinglist.database.HibernateUserRepository;
import com.javaguru.shoppinglist.domain.User;
import com.javaguru.shoppinglist.service.validation.product.ProductValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserUniqueNameValidationRule implements UserValidationRule{

    private final HibernateUserRepository hibernateUserRepository;

    @Autowired
    public UserUniqueNameValidationRule(HibernateUserRepository hibernateUserRepository) {
        this.hibernateUserRepository = hibernateUserRepository;
    }

    @Override
    public void validate(User user) {
        checkNotNull(user);
        if (hibernateUserRepository.ifUserExistByName(user.getName())) {
            throw new ProductValidationException("User " + user.getName() + " already exist.");
        }
    }
}

