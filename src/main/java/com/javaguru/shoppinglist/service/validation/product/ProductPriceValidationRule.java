package com.javaguru.shoppinglist.service.validation.product;

import com.javaguru.shoppinglist.domain.Product;
import org.springframework.stereotype.Component;

import static com.javaguru.shoppinglist.domain.StaticValues.*;

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
