package com.javaguru.shoppinglist.controller;

import com.javaguru.shoppinglist.dto.ProductToUserDTO;
import com.javaguru.shoppinglist.service.ProductToUserService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/assign")
public class ProductToUserController {

    private final ProductToUserService productToUserService;

    public ProductToUserController(ProductToUserService productToUserService) {
        this.productToUserService = productToUserService;
    }

    @PutMapping
    public void updateUser(@RequestBody ProductToUserDTO request) {
        productToUserService.assignProductToUser(request.getProductId(), request.getUserId());
    }


}
