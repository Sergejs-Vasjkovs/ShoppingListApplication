package com.javaguru.shoppinglist.console.findproduct;

import com.javaguru.shoppinglist.console.MenuAction;
import com.javaguru.shoppinglist.console.ConsoleMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class FindProduct implements MenuAction {

    private final List<MenuAction> findProductList;

    @Autowired
    public FindProduct(@Lazy @Qualifier("findMenu") List<MenuAction> findProductList) {
        this.findProductList = findProductList;
    }

    @Override
    public void execute() {

        Scanner scanner = new Scanner(System.in);

        ConsoleMenu.action(scanner, findProductList);
    }


    @Override
    public String toString() {
        return " Find product:";
    }
}
