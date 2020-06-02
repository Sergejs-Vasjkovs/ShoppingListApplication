package com.javaguru.shoppinglist.service.validation.product;

import com.javaguru.shoppinglist.domain.Product;
import org.springframework.stereotype.Component;

import static com.javaguru.shoppinglist.domain.StaticValues.*;

@Component
public class ProductNameValidationRule implements ProductValidationRule {

    @Override
    public void validate(Product product) {
        checkNotNull(product);
        if (product.getName().length() > MAX_PRODUCT_NAME_LENGTH || product.getName().length() < MIN_PRODUCT_NAME_LENGTH) {
            throw new ProductValidationException("Product name minimum length is " + MIN_PRODUCT_NAME_LENGTH +
                    " characters, maximum is " + MAX_PRODUCT_NAME_LENGTH);
        }
    }
}
