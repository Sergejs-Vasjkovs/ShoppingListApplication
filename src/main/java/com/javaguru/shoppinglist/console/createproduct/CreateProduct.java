package com.javaguru.shoppinglist.console.createproduct;

import com.javaguru.shoppinglist.console.MenuAction;
import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

@Component
public class CreateProduct implements MenuAction {

    private ProductService productService;

    @Autowired
    public CreateProduct(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter product name: ");
        String name = scanner.nextLine();

        System.out.println("Enter product price: ");
        BigDecimal price = new BigDecimal(scanner.nextLine());
        BigDecimal scaledPrice = price.setScale(2, RoundingMode.HALF_EVEN);

        System.out.println("Enter product description: ");
        String description = scanner.nextLine();

        Product product = new Product();
        product.setName(name);
        product.setPrice(scaledPrice);
        product.setDescription(description);

        productService.createProduct(product);
        System.out.println("Product ID: " + product.getId());
    }

    @Override
    public String toString() {
        return " Create product:";
    }
}
