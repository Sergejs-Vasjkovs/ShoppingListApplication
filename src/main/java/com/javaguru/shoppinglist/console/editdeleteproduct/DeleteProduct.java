package com.javaguru.shoppinglist.console.editdeleteproduct;

import com.javaguru.shoppinglist.console.MenuAction;
import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class DeleteProduct implements MenuAction {

    private ProductService productService;

    @Autowired
    public DeleteProduct(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter product ID to delete:");
        long id = Long.parseLong(scanner.nextLine());

        Product product = productService.findProductByID(id);

        System.out.println("Product: " + product.getName() + " with ID : " + product.getId()
                + " was deleted from database");


        productService.deleteProduct(product);
    }

    @Override
    public String toString() {
        return " Delete product by ID:";
    }
}
