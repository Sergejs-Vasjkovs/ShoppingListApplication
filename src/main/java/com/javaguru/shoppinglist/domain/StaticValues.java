package com.javaguru.shoppinglist.domain;

import java.math.BigDecimal;

public class StaticValues {

    public static final float MAX_DISCOUNT = 100;
    public static final float MIN_DISCOUNT = 0;

    public static final BigDecimal MIN_PRICE = new BigDecimal("0.00");
    public static final BigDecimal MIN_PRICE_TO_SET_DISCOUNT = new BigDecimal("20.00");

    public static final int MIN_PRODUCT_NAME_LENGTH = 3;
    public static final int MAX_PRODUCT_NAME_LENGTH = 32;

    public static final int MIN_USER_NAME_LENGTH = 3;
    public static final int MAX_USER_NAME_LENGTH = 32;
}
