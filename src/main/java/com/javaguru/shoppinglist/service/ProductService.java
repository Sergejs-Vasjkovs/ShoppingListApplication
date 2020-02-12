package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.database.InMemoryRepository;
import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.service.validation.ProductValidationException;
import com.javaguru.shoppinglist.service.validation.ProductValidationService;

public class ProductService {

    private InMemoryRepository repository = new InMemoryRepository();
    private ProductValidationService productValidationService = new ProductValidationService();

    public void addProduct(Product product) {

        try {
            if (!repository.ifProductExistByName(product.getName())) {
                productValidationService.validate(product);
                repository.addProduct(product);
            } else {
                throw new ProductValidationException("Product " + product.getName() + " already exist.");
            }
        } catch (ProductValidationException ex) {
            ex.printStackTrace();
        }
    }

    public Product findProductByID(long id) {
        Product product = repository.findProductById(id);
        if (product == null) {
            throw new ProductValidationException("Product with ID " + id + " not exist!");
        }
        return product;
    }
}
