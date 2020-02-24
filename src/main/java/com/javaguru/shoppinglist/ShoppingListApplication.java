package com.javaguru.shoppinglist;

import com.javaguru.shoppinglist.console.UserInput;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ShoppingListApplication {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);

        UserInput userInput = context.getBean(UserInput.class);

        userInput.runApplication();
    }
}
