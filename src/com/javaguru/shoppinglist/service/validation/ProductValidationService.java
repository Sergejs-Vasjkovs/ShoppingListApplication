package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;

public class ProductValidationService {

    public void validate(Product product) throws ProductValidationException {
        if (product.getPrice().intValue() <= 0) {
            throw new ProductValidationException("Product price must be more than 0.00 €");
        }
        if (product.getDiscount() > 100){
            throw new ProductValidationException("Product discount cannot be more than 100%");
        }
        if (product.getName().length()>32 || product.getName().length() < 3){
            throw new ProductValidationException("Product name minimum length is 8 characters, maximum is 32");
        }
    }
}
