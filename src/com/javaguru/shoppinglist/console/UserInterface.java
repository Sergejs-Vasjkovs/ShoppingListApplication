package com.javaguru.shoppinglist.console;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.service.ProductService;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class UserInterface {

    ProductService productService = new ProductService();

    public void runApplication() {
        while (true) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("1. Create product");
            System.out.println("2. Find product by id");
            System.out.println("3. Exit");

            String userInput = scanner.nextLine();

            switch (userInput) {
                case "1":
                    createProduct();
                    break;
                case "2":
                    findProduct();
                    break;
                case "3":
                    return;
                default:
                    System.err.println("Error! Enter: 1 - To create product, " +
                            "2 - To find product by ID, 3 - For exit.");
                    break;
            }

        }
    }


    public void createProduct() {
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

    public void findProduct() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter product id: ");
        long id = scanner.nextLong();

        System.out.println(productService.findProductByID(id));
    }

}
