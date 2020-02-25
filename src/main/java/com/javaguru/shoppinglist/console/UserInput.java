package com.javaguru.shoppinglist.console;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class UserInput {

    private final List<UserMenu> menuList;

    @Autowired
    public UserInput(@Qualifier("menuInOrder") List<UserMenu> menuList) {
        this.menuList = menuList;
    }

    public void runApplication() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            try {
                for (int i = 0; i < menuList.size(); i++) {
                    UserMenu userMenu = menuList.get(i);
                    System.out.println(i + 1 + userMenu.toString());
                }
                int userInput = scanner.nextInt();
                menuList.get(userInput - 1).inputMenu();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}


