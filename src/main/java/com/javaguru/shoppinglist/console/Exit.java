package com.javaguru.shoppinglist.console;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(3)
public class Exit implements UserMenu {

    @Override
    public void InputMenu() {
        System.exit(0);
    }

    @Override
    public String toString() {
        return " Exit:";
    }
}
