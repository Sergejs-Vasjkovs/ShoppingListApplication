package com.javaguru.shoppinglist.service.validation.product;

import com.javaguru.shoppinglist.database.HibernateProductRepository;
import com.javaguru.shoppinglist.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductUniqueNameValidationRule implements ProductValidationRule {

    private final HibernateProductRepository hibernateProductRepository;

    @Autowired
    public ProductUniqueNameValidationRule(HibernateProductRepository hibernateProductRepository) {
        this.hibernateProductRepository = hibernateProductRepository;
    }

    @Override
    public void validate(Product product) {
        checkNotNull(product);
        if (hibernateProductRepository.ifProductExistByName(product.getName())) {
            throw new ProductValidationException("Product " + product.getName() + " already exist.");
        }
    }
}
