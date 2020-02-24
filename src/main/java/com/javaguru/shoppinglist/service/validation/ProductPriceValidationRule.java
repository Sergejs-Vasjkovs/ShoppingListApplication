package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;
import org.springframework.stereotype.Component;

import static com.javaguru.shoppinglist.domain.Product.*;

@Component
public class ProductPriceValidationRule implements ProductValidationRule {

    @Override
    public void validate(Product product) {
        checkNotNull(product);
        if (product.getPrice().compareTo(MIN_PRICE) < 1) {
            throw new ProductValidationException("Product price must be more than " + MIN_PRICE + " €");
        }
    }
}
