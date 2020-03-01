package com.javaguru.shoppinglist.console;

import org.springframework.stereotype.Component;

@Component
public class Exit implements UserMenu {

    @Override
    public void inputMenu() {
        System.exit(0);
    }

    @Override
    public String toString() {
        return " Exit:";
    }
}
