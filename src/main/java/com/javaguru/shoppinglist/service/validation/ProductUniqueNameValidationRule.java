package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.database.InMemoryRepository;
import com.javaguru.shoppinglist.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductUniqueNameValidationRule implements ProductValidationRule {

    private final InMemoryRepository inMemoryRepository;

    @Autowired
    public ProductUniqueNameValidationRule(InMemoryRepository inMemoryRepository) {
        this.inMemoryRepository = inMemoryRepository;
    }

    @Override
    public void validate(Product product) {
        checkNotNull(product);
        if (inMemoryRepository.ifProductExistByName(product.getName())) {
            throw new ProductValidationException("Product " + product.getName() + " already exist.");
        }
    }
}
