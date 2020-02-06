package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;

import static com.javaguru.shoppinglist.service.validation.ProductValidationConstants.MAX_NAME_LENGTH;
import static com.javaguru.shoppinglist.service.validation.ProductValidationConstants.MIN_NAME_LENGTH;

public class ProductNameValidationRule implements ProductValidationRule {

    @Override
    public void validate(Product product) {
        if (product.getName().length() > MAX_NAME_LENGTH || product.getName().length() < MIN_NAME_LENGTH) {
            throw new ProductValidationException("Product name minimum length is 3 characters, maximum is 32");
        }

    }
}
