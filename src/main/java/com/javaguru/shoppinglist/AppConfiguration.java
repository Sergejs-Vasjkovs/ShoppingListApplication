package com.javaguru.shoppinglist;

import com.javaguru.shoppinglist.console.CreateProduct;
import com.javaguru.shoppinglist.console.Exit;
import com.javaguru.shoppinglist.console.UserMenu;
import com.javaguru.shoppinglist.console.findproduct.FindMenu;
import com.javaguru.shoppinglist.console.findproduct.FindProduct;
import com.javaguru.shoppinglist.console.findproduct.FindProductById;
import com.javaguru.shoppinglist.console.findproduct.FindProductByName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedList;
import java.util.List;

@Configuration
@ComponentScan(basePackages = "com.javaguru.shoppinglist")
public class AppConfiguration {

    private FindProduct findProduct;
    private CreateProduct createProduct;
    private FindProductById findProductById;
    private FindProductByName findProductByName;
    private Exit exit;

    @Autowired
    public AppConfiguration(FindProduct findProduct, CreateProduct createProduct, FindProductById findProductById, FindProductByName findProductByName, Exit exit) {
        this.findProduct = findProduct;
        this.createProduct = createProduct;
        this.findProductById = findProductById;
        this.findProductByName = findProductByName;
        this.exit = exit;
    }

    @Bean(name = "findMenu")
    public List<FindMenu> findProductList() {
        List<FindMenu> findProductList = new LinkedList<>();
        findProductList.add(findProductByName);
        findProductList.add(findProductById);
        return findProductList;
    }

    @Bean(name = "menuInOrder")
    public List<UserMenu> menuList() {
        List<UserMenu> menuList = new LinkedList<>();
        menuList.add(createProduct);
        menuList.add(findProduct);
        menuList.add(exit);
        return menuList;
    }


}

