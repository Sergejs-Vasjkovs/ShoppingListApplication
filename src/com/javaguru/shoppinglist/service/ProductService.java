package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.dataBase.InMemoryRepository;
import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.service.validation.ProductValidationException;
import com.javaguru.shoppinglist.service.validation.ProductValidationService;

public class ProductService {

    InMemoryRepository inMemoryRepository = new InMemoryRepository();
    ProductValidationService productValidationService = new ProductValidationService();


    public void createProduct(Product product) {

        try {
            if (!inMemoryRepository.ifProductExistByName(product.getName())) {
                productValidationService.validate(product);
                inMemoryRepository.addProduct(product);
            } else {
                throw new ProductValidationException("Product " + product.getName() + " already exist.");
            }
        } catch (ProductValidationException ex) {
            ex.printStackTrace();
        }
    }

    public Product findProductByID(long id) {
        return inMemoryRepository.findProductById(id);
    }
}
