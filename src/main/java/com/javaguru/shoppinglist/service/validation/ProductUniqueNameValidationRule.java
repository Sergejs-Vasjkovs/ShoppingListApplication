package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.database.HibernateRepository;
import com.javaguru.shoppinglist.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductUniqueNameValidationRule implements ProductValidationRule {

    private final HibernateRepository hibernateRepository;

    @Autowired
    public ProductUniqueNameValidationRule(HibernateRepository hibernateRepository) {
        this.hibernateRepository = hibernateRepository;
    }

    @Override
    public void validate(Product product) {
        checkNotNull(product);
        if (hibernateRepository.ifProductExistByName(product.getName())) {
            throw new ProductValidationException("Product " + product.getName() + " already exist.");
        }
    }
}
