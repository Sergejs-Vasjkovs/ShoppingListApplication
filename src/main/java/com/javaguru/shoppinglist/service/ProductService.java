package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.database.InMemoryRepository;
import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.service.validation.ProductValidationException;
import com.javaguru.shoppinglist.service.validation.ProductValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductService {

    private final InMemoryRepository repository;
    private final ProductValidationService productValidationService;

    @Autowired
    public ProductService(InMemoryRepository repository, ProductValidationService productValidationService) {
        this.repository = repository;
        this.productValidationService = productValidationService;
    }

    public void createProduct(Product product) {
        productValidationService.validate(product);
        repository.insert(product);
    }

    public Product findProductByID(long id) {
        Product product = repository.findProductById(id);
        if (product == null) {
            throw new ProductValidationException("Product with ID " + id + " not exist!");
        }
        return product;
    }

    public Product findProductByName (String name){
        Product product = repository.findProductByName(name);
        if (product == null) {
            throw new ProductValidationException("Product " + name + " not exist!");
        }
        return product;
    }
}
