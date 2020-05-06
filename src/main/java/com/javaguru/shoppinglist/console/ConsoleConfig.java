package com.javaguru.shoppinglist.console;

import com.javaguru.shoppinglist.console.editdeleteproduct.DeleteProduct;
import com.javaguru.shoppinglist.console.editdeleteproduct.EditAndDelete;
import com.javaguru.shoppinglist.console.editdeleteproduct.EditProduct;
import com.javaguru.shoppinglist.console.findproduct.FindProduct;
import com.javaguru.shoppinglist.console.findproduct.FindProductById;
import com.javaguru.shoppinglist.console.findproduct.FindProductByName;
import com.javaguru.shoppinglist.console.createproduct.CreateProduct;
import com.javaguru.shoppinglist.console.exit.Exit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedList;
import java.util.List;

@Configuration
public class ConsoleConfig {

    private FindProduct findProduct;
    private CreateProduct createProduct;
    private FindProductById findProductById;
    private FindProductByName findProductByName;
    private EditProduct editProduct;
    private DeleteProduct deleteProduct;
    private EditAndDelete editAndDelete;
    private Exit exit;

    @Autowired
    public ConsoleConfig(FindProduct findProduct, CreateProduct createProduct, FindProductById findProductById, FindProductByName findProductByName, EditProduct editProduct, DeleteProduct deleteProduct, EditAndDelete editAndDelete, Exit exit) {
        this.findProduct = findProduct;
        this.createProduct = createProduct;
        this.findProductById = findProductById;
        this.findProductByName = findProductByName;
        this.editProduct = editProduct;
        this.deleteProduct = deleteProduct;
        this.editAndDelete = editAndDelete;
        this.exit = exit;
    }

    @Bean(name = "findMenu")
    public List<MenuAction> findProductList() {
        List<MenuAction> findProductList = new LinkedList<>();
        findProductList.add(findProductByName);
        findProductList.add(findProductById);
        return findProductList;
    }

    @Bean(name = "menuInOrder")
    public List<MenuAction> menuList() {
        List<MenuAction> menuList = new LinkedList<>();
        menuList.add(createProduct);
        menuList.add(findProduct);
        menuList.add(editAndDelete);
        menuList.add(exit);
        return menuList;
    }

    @Bean(name = "EditProduct")
    public List<MenuAction> EditProduct() {
        List<MenuAction> editProductList = new LinkedList<>();
        editProductList.add(editProduct);
        editProductList.add(deleteProduct);
        return editProductList;
    }

}

