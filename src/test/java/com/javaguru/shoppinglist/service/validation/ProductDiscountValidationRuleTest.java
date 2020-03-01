package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static com.javaguru.shoppinglist.domain.Product.*;

public class ProductDiscountValidationRuleTest {

    @Rule
    public final ExpectedException expectedException = ExpectedException.none();

    private ProductDiscountValidationRule victim;
    private Product product;

    @Before
    public void setUp() {
        victim = new ProductDiscountValidationRule();
        product = new Product();
    }

    @Test
    public void shouldThrow_ProductDiscountValidationException_DiscountMoreThanMax() {
        product.setDiscount(MAX_DISCOUNT + 1);
        expectedException.expect(ProductValidationException.class);
        expectedException.expectMessage("Product discount cannot be more than"
                + MAX_DISCOUNT + " %");
        victim.validate(product);
    }

    @Test
    public void shouldThrow_ProductDiscountValidationException_DiscountLessThanMin() {
        product.setDiscount(MIN_DISCOUNT - 1);
        expectedException.expect(ProductValidationException.class);
        expectedException.expectMessage("Product discount cannot be less than"
                + MIN_DISCOUNT + " %");
        victim.validate(product);
    }

    @Test
    public void shouldThrow_ProductDiscountValidationException_MinPriceToSetDiscountLessThanAllowed() {
        product.setDiscount(MIN_DISCOUNT + 1);
        product.setPrice(MIN_PRICE_TO_SET_DISCOUNT);
        expectedException.expect(ProductValidationException.class);
        expectedException.expectMessage("Discount for a product cheaper than "
                + MIN_PRICE_TO_SET_DISCOUNT + "€ is not allowed");
        victim.validate(product);
    }

    @Test
    public void shouldValidate_WithoutException() {
        product.setDiscount(MIN_DISCOUNT);
        product.setPrice(MIN_PRICE_TO_SET_DISCOUNT);
        victim.validate(product);
    }

    @After
    public void afterTest() {
        victim = null;
        product = null;
    }

}