package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;

import static com.javaguru.shoppinglist.domain.Product.*;

public class ProductNameValidationRule implements ProductValidationRule {

    @Override
    public void validate(Product product) {
        if (product.getName().length() > MAX_NAME_LENGTH || product.getName().length() < MIN_NAME_LENGTH) {
            throw new ProductValidationException("Product name minimum length is " + MIN_NAME_LENGTH +
                    " characters, maximum is " + MAX_NAME_LENGTH);
        }

    }
}
