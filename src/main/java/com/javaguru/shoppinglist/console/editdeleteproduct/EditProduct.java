package com.javaguru.shoppinglist.console.editdeleteproduct;

import com.javaguru.shoppinglist.console.MenuAction;
import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

@Component
public class EditProduct implements MenuAction {

    private ProductService productService;

    @Autowired
    public EditProduct(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void execute() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter product ID to edit:");
        long id = Long.parseLong(scanner.nextLine());
        Product product = productService.findProductByID(id);
        System.out.println(product);

        System.out.println("Enter new name: ");
        String name = scanner.nextLine();

        System.out.println("Enter new price: ");
        BigDecimal price = new BigDecimal(scanner.nextLine());
        BigDecimal scaledPrice = price.setScale(2, RoundingMode.HALF_EVEN);

        System.out.println("Enter new description: ");
        String description = scanner.nextLine();

        product.setName(name);
        product.setPrice(scaledPrice);
        product.setDescription(description);

        productService.updateProduct(product);

        System.out.println("Edited product: " + product.toString());

    }

    @Override
    public String toString() {
        return " Edit product by ID: ";
    }
}
