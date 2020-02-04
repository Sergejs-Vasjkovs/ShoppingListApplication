package com.javaguru.shoppinglist.console;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.service.ProductService;

import java.math.BigDecimal;
import java.util.Scanner;

public class userInterface {

    ProductService productService = new ProductService();

    public void runApplication() {
        while (true) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("1. Create product");
            System.out.println("2. Find product by id");
            System.out.println("3. Exit");

            String userInput = scanner.nextLine();

            if (userInput.equals("1")) {
                createProduct();
            } else if (userInput.equals("2")) {
                findProduct();
            } else if (userInput.equals("3")) {
                return;
            } else {
                System.err.println("Error! Enter: 1 - To create product, " +
                        "2 - To find product by ID, 3 - For exit.");
            }

        }
    }


    public void createProduct() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter product name: ");
        String name = scanner.nextLine();

        System.out.println("Enter product price: ");
        BigDecimal price = new BigDecimal(scanner.nextLine());

        Product product = new Product();
        product.setName(name);
        product.setPrice(price);

        productService.createProduct(product);
        System.out.println("Product ID: " + product.getId());
    }

    public void findProduct() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter product id: ");
        long id = scanner.nextLong();

        System.out.println(productService.findProductByID(id));
    }

}
