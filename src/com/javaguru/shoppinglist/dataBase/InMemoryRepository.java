package com.javaguru.shoppinglist.dataBase;

import com.javaguru.shoppinglist.domain.Product;

import java.util.HashMap;
import java.util.Map;

public class InMemoryRepository {

    Map<Long, Product> productRepository = new HashMap<>();
    private Long nextId = 1L;

    public void addProduct(Product product) {
        product.setId(nextId);
        productRepository.put(nextId, product);
        nextId++;
    }

    public Product findProductById(long id) {
        return productRepository.get(id);
    }

}
