package com.javaguru.shoppinglist.console;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

@Component
@Order(1)
public class CreateProduct implements UserMenu {

    private ProductService productService;

    @Autowired
    public CreateProduct(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void InputMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter product name: ");
        String name = scanner.nextLine();

        System.out.println("Enter product price: ");
        BigDecimal price = new BigDecimal(scanner.nextLine());
        BigDecimal scaledPrice = price.setScale(2, RoundingMode.HALF_EVEN);

        Product product = new Product();
        product.setName(name);
        product.setPrice(scaledPrice);

        productService.createProduct(product);
        System.out.println("Product ID: " + product.getId());
    }

    @Override
    public String toString() {
        return " CreateProduct:";
    }
}
