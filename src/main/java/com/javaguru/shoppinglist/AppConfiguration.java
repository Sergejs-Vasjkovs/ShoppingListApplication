package com.javaguru.shoppinglist;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.javaguru.shoppinglist")
public class AppConfiguration {

    // не получилось у меня создать свой БИН с правильным порядком

//    private List<UserMenu> menuList;
//    private CreateProduct createProduct;
//    private Exit exit;
//    private FindProduct findProduct;
//
//    @Autowired
//    public AppConfiguration(List<UserMenu> menuList, CreateProduct createProduct, Exit exit, FindProduct findProduct) {
//        this.menuList = menuList;
//        this.createProduct = createProduct;
//        this.exit = exit;
//        this.findProduct = findProduct;
//    }
//
//    @Bean(name = "menuInOrder")
//    public List<UserMenu> menuList() {
//        menuList.add(createProduct);
//        menuList.add(findProduct);
//        menuList.add(exit);
//        return menuList;
//    }
}

