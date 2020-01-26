package com.javaguru.shoppinglist;

import java.math.BigDecimal;
import java.util.Scanner;

class ShoppingListApplication {

    public static void main(String[] args) {

        ProductRepository productRepository = new ProductRepository();

        while (true) {
            Scanner scanner = new Scanner(System.in);
            try {
                System.out.println("1. Create product");
                System.out.println("2. Find product by id");
                System.out.println("3. Exit");
                int userInput = Integer.parseInt(scanner.nextLine());

                switch (userInput) {
                    case 1:
                        System.out.println("Enter product name: ");
                        String name = scanner.nextLine();
                        System.out.println("Enter product price: ");
                        BigDecimal price = new BigDecimal(scanner.nextLine());
                        Product product = new Product();
                        product.setName(name);
                        product.setPrice(price);
                        productRepository.addProduct(product);
                        System.out.println("Result: " + product);
                    case 2:
                        System.out.println("Enter product id: ");
                        long id = scanner.nextLong();
                        Product findProductResult = productRepository.findProductById(id);
                        System.out.println(findProductResult);
                    case 3:
                        return;
                }
            } catch (Exception e) {
                System.out.println("Error! Please try again.");
            }
        }
    }
}
