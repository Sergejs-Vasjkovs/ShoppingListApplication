package com.javaguru.shoppinglist.service.validation;

import java.math.BigDecimal;

public class ProductValidationConstants {
    public static final float MAX_DISCOUNT = 100;
    public static final float MIN_DISCOUNT = 0;

    public static final BigDecimal MIN_PRICE = new BigDecimal("0.00");
    public static final BigDecimal MIN_PRICE_TO_SET_DISCOUNT = new BigDecimal("20.00");

    public static final int MIN_NAME_LENGTH = 3;
    public static final int MAX_NAME_LENGTH = 32;
}
