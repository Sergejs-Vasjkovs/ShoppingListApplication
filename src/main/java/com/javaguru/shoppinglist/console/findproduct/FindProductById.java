package com.javaguru.shoppinglist.console.findproduct;

import com.javaguru.shoppinglist.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class FindProductById implements FindMenu {

    private ProductService productService;

    @Autowired
    public FindProductById(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void findMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter product id: ");
        long id = Long.parseLong(scanner.nextLine());

        System.out.println(productService.findProductByID(id));
    }

    @Override
    public String toString() {
        return " Find product by ID:";
    }
}
