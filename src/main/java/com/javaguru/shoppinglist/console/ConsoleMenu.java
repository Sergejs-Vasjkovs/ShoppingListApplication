package com.javaguru.shoppinglist.console;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class ConsoleMenu {

    private final List<MenuAction> menuInOrder;

    @Autowired
    public ConsoleMenu(@Qualifier("menuInOrder") List<MenuAction> menuList) {
        this.menuInOrder = menuList;
    }

    public void runApplication() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            try {
                action(scanner, menuInOrder);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void action(Scanner scanner, List<MenuAction> menuInOrder) {
        for (int i = 0; i < menuInOrder.size(); i++) {
            MenuAction menuAction = menuInOrder.get(i);
            System.out.println(i + 1 + menuAction.toString());
        }
        int userInput = scanner.nextInt();
        menuInOrder.get(userInput - 1).execute();
    }
}


