package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;

import java.util.LinkedList;
import java.util.List;

public class ProductValidationService {

    List<ProductValidationRule> validationRulesList = new LinkedList<>();

    public void validateRules() {
        validationRulesList.add(new ProductDiscountValidationRule());
        validationRulesList.add(new ProductNameValidationRule());
        validationRulesList.add(new ProductPriceValidationRule());
    }

    public void validate(Product product) {
        validateRules();
        for (ProductValidationRule rule : validationRulesList) {
            rule.validate(product);
        }
    }

}
