package com.javaguru.shoppinglist;

import java.util.HashMap;
import java.util.Map;

public class ProductRepository {

    Map<Long, Product> productRepository = new HashMap<>();

    private static Long nextId = 1L;

    public void addProduct(Product product) {

        if (!productRepository.isEmpty()) {
            productRepository.put(nextId, product);
            product.setId(nextId);
            nextId++;
        } else {
            productRepository.put(nextId, product);
            product.setId(nextId);
            nextId++;
        }
    }

    public Product findProductById(long id) {
        return productRepository.get(id);
    }

}
