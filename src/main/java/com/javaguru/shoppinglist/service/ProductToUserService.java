package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.domain.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductToUserService {

    private final ProductService productService;
    private final UserService userService;

    public ProductToUserService(ProductService productService, UserService userService) {
        this.productService = productService;
        this.userService = userService;
    }

    @Transactional
    public void assignProductToUser(Long ProductId, Long UserId) {
        Product product = productService.findProductByID(ProductId);
        User user = userService.findUserByID(UserId);
        product.setUser(user);
    }
}
