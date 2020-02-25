package com.javaguru.shoppinglist.console.findproduct;

import com.javaguru.shoppinglist.console.UserMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class FindProduct implements UserMenu {

    private final List<FindMenu> findProductList;

    @Autowired
    public FindProduct(@Lazy @Qualifier("findMenu") List<FindMenu> findProductList) {
        this.findProductList = findProductList;
    }

    @Override
    public void inputMenu() {

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < findProductList.size(); i++) {
            FindMenu findMenu = findProductList.get(i);
            System.out.println(i + 1 + findMenu.toString());
        }
        int userInput = scanner.nextInt();
        findProductList.get(userInput - 1).findMenu();
    }


    @Override
    public String toString() {
        return " Find product:";
    }
}
