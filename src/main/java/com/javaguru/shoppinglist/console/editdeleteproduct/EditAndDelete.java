package com.javaguru.shoppinglist.console.editdeleteproduct;

import com.javaguru.shoppinglist.console.MenuAction;
import com.javaguru.shoppinglist.console.ConsoleMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class EditAndDelete implements MenuAction {

    private final List<MenuAction> editProduct;

    @Autowired
    public EditAndDelete(@Lazy @Qualifier("EditProduct") List<MenuAction> EditProduct) {
        this.editProduct = EditProduct;
    }

    @Override
    public void execute() {

        Scanner scanner = new Scanner(System.in);

        ConsoleMenu.action(scanner, editProduct);
    }


    @Override
    public String toString() {
        return " Edit/Delete product:";
    }
}
