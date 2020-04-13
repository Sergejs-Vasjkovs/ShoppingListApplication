package com.javaguru.shoppinglist.console.exit;

import com.javaguru.shoppinglist.console.MenuAction;
import org.springframework.stereotype.Component;

@Component
public class Exit implements MenuAction {

    @Override
    public void execute() {
        System.exit(0);
    }

    @Override
    public String toString() {
        return " Exit:";
    }
}
