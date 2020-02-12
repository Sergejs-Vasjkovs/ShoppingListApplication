package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;

import java.util.LinkedList;
import java.util.List;

public class ProductValidationService {

    public List<ProductValidationRule> getValidationRulesList() {
        List<ProductValidationRule> validationRulesList = new LinkedList<>();
        validationRulesList.add(new ProductDiscountValidationRule());
        validationRulesList.add(new ProductNameValidationRule());
        validationRulesList.add(new ProductPriceValidationRule());
        return validationRulesList;
    }

    public void validate(Product product) {
        List<ProductValidationRule> validationRulesList = getValidationRulesList();
        for (ProductValidationRule rule : validationRulesList) {
            rule.validate(product);
        }
    }

}
