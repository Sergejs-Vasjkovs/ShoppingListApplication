package com.javaguru.shoppinglist;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ProductRepository {

    Map<Long, Product> productRepository = new HashMap<>();

    public void addProduct(Product product) {
        if (productRepository.isEmpty()) {
            productRepository.put(1L, product);
        } else {
            productRepository.put((long) (productRepository.size() + 1), product);
        }
    }

    public Product findProductById(long id) {

        Product product = null;

        for (Map.Entry<Long, Product> entry : productRepository.entrySet())
            if (id == (entry.getKey())) {
                product = entry.getValue();
            }
        return product;
    }

    // тут будут разлтчные CRUD методы
//    public void deleteProduct() {
//    }
//
//    public void deleteProductById() {
//    }
//
//    public void deleteProductByName() {
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductRepository that = (ProductRepository) o;
        return Objects.equals(productRepository, that.productRepository);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productRepository);
    }

    @Override
    public String toString() {
        return "ProductRepository{" +
                "productRepository=" + productRepository +
                '}';
    }
}
