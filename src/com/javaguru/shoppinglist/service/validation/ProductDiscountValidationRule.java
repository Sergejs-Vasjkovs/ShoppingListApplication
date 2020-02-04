package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;

public class ProductDiscountValidationRule implements ProductValidationRule {

    @Override
    public void validate(Product product) {
        if (product.getDiscount() > 100) {
            throw new ProductValidationException("Product discount cannot be more than 100%");
        }
        if (product.getDiscount() < 0) {
            throw new ProductValidationException("Product discount cannot be less than 0%");
        }
        if (product.getPrice().doubleValue() < 20 && product.getDiscount() != 0){
            throw new ProductValidationException("Discount for a product cheaper than 20€ is not allowed");
        }
    }
}
