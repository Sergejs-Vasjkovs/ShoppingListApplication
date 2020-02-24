package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;
import org.springframework.stereotype.Component;

import static com.javaguru.shoppinglist.domain.Product.*;

@Component
public class ProductDiscountValidationRule implements ProductValidationRule {

    @Override
    public void validate(Product product) {
        checkNotNull(product);

        if (product.getDiscount() > MAX_DISCOUNT) {
            throw new ProductValidationException("Product discount cannot be more than" + MAX_DISCOUNT + " %");
        }
        if (product.getDiscount() < MIN_DISCOUNT) {
            throw new ProductValidationException("Product discount cannot be less than" + MIN_DISCOUNT + " %");
        }
        if (product.getPrice().compareTo(MIN_PRICE_TO_SET_DISCOUNT) > -1 && product.getDiscount() != MIN_DISCOUNT) {
            throw new ProductValidationException("Discount for a product cheaper than "
                    + MIN_PRICE_TO_SET_DISCOUNT + "€ is not allowed");
        }
    }
}
