package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.database.HibernateProductRepository;
import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.service.validation.product.ProductValidationException;
import com.javaguru.shoppinglist.service.validation.product.ProductValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {

    private final HibernateProductRepository repository;
    private final ProductValidationService productValidationService;

    @Autowired
    public ProductService(HibernateProductRepository repository, ProductValidationService productValidationService) {
        this.repository = repository;
        this.productValidationService = productValidationService;
    }

    @Transactional
    public void createProduct(Product product) {
        productValidationService.validate(product);
        repository.save(product);
    }

    public Product findProductByID(long id) {
        Product product = repository.findProductById(id);
        if (product == null) {
            throw new ProductValidationException("Product with ID " + id + " not exist!");
        }
        return product;
    }

    public Product findProductByName(String name) {
        Product product = repository.findProductByName(name);
        if (product == null) {
            throw new ProductValidationException("Product " + name + " not exist!");
        }
        return product;
    }

    @Transactional
    public void updateProductById(Long id, Product updatedProduct) {
        Product product = repository.findProductById(id);
        if (product == null) {
            throw new ProductValidationException("Product with ID " + id + " not exist!");
        }

        product.setName(updatedProduct.getName());
        product.setPrice(updatedProduct.getPrice());
        product.setCategory(updatedProduct.getCategory());
        product.setDiscount(updatedProduct.getDiscount());
        product.setDescription(updatedProduct.getDescription());

        repository.update(product);
    }

    public void deleteProductById(Long id) {
        Product product = repository.findProductById(id);
        if (product == null) {
            throw new ProductValidationException("Product with" + id + " not exist!");
        }
        repository.delete(product);
    }

    public void deleteProductByName(String name) {
        Product product = repository.findProductByName(name);
        if (product == null) {
            throw new ProductValidationException("Product " + name + " not exist!");
        }
        repository.delete(product);
    }

    public List<Product> findAllProducts() {
        return repository.findAllProducts();
    }
}
