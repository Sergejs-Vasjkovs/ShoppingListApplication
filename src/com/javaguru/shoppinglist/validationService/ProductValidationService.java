package com.javaguru.shoppinglist.validationService;

import com.javaguru.shoppinglist.Product;

public class ProductValidationService {

    public void validate(Product product) throws ProductValidationException {
        if (product.getPrice().intValue() < 0) {
            throw new ProductValidationException("Цена продукта должна быть больше 0");
        }
        if (product.getDiscount() > 100){
            throw new ProductValidationException("Скидка не может быть больше 100%");
        }
        if (product.getName().length()>32 || product.getName().length() < 3){
            throw new ProductValidationException("Название не может быть меньше 3 символов и больше 32");
        }
    }
}
