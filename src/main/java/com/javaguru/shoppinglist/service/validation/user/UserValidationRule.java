package com.javaguru.shoppinglist.service.validation.user;

import com.javaguru.shoppinglist.domain.User;
import com.javaguru.shoppinglist.service.validation.product.ProductValidationException;

public interface UserValidationRule {

    void validate(User user);

    default void checkNotNull(User user) {
        if (user == null) {
            throw new ProductValidationException("User is null");
        }
    }
}
