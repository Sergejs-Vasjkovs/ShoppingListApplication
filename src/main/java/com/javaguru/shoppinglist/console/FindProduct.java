package com.javaguru.shoppinglist.console;

import com.javaguru.shoppinglist.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
@Order(2)
public class FindProduct implements UserMenu {

    private ProductService productService;

    @Autowired
    public FindProduct(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void InputMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter product id: ");
        long id = Long.parseLong(scanner.nextLine());

        System.out.println(productService.findProductByID(id));
    }

    @Override
    public String toString() {
        return " FindProduct:";
    }
}
