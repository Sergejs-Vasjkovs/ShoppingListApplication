package com.javaguru.shoppinglist.database;

import com.javaguru.shoppinglist.domain.Product;

import java.util.HashMap;
import java.util.Map;

public class InMemoryRepository {

    private Map<Long, Product> inMemoryRepository = new HashMap<>();
    private Long productNextId = 1L;

    public void addProduct(Product product) {
        product.setId(productNextId);
        inMemoryRepository.put(productNextId, product);
        productNextId++;
    }

    public Product findProductByName(String name) {
        Product product = null;
        for (Map.Entry<Long, Product> entry : inMemoryRepository.entrySet()) {
            product = entry.getValue();
            if (product.getName().equals(name)) {
                return product;
            }
        }
        return product;
    }

    public boolean ifProductExistByName(String name) {
        Product product;
        for (Map.Entry<Long, Product> entry : inMemoryRepository.entrySet()) {
            product = entry.getValue();
            if (product.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public Product findProductById(long id) {
        return inMemoryRepository.get(id);
    }

}
