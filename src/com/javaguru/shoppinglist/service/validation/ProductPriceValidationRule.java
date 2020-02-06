package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;

import static com.javaguru.shoppinglist.service.validation.ProductValidationConstants.MIN_PRICE;

public class ProductPriceValidationRule implements ProductValidationRule {

    @Override
    public void validate(Product product) {
        if (product.getPrice().compareTo(MIN_PRICE) <= 0) {
            throw new ProductValidationException("Product price must be more than " + MIN_PRICE + " €");
        }
    }
}
