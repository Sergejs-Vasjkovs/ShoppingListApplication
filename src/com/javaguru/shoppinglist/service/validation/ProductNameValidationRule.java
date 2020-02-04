package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;

public class ProductNameValidationRule implements ProductValidationRule {

    @Override
    public void validate(Product product) {
        if (product.getName().length() > 32 || product.getName().length() < 3) {
            throw new ProductValidationException("Product name minimum length is 8 characters, maximum is 32");
        }

    }
}
