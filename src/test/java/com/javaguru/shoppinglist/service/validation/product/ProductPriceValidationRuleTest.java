package com.javaguru.shoppinglist.service.validation.product;

import com.javaguru.shoppinglist.domain.Product;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static com.javaguru.shoppinglist.domain.StaticValues.*;

public class ProductPriceValidationRuleTest {

    @Rule
    public final ExpectedException expectedException = ExpectedException.none();

    private ProductPriceValidationRule victim;
    private Product product;

    @Before
    public void setUp() {
        victim = new ProductPriceValidationRule();
        product = new Product();
    }

    @Test
    public void shouldThrow_ProductPriceValidationException_MinPriceToLow() {
        product.setPrice(MIN_PRICE);
        expectedException.expect(ProductValidationException.class);
        expectedException.expectMessage("Product price must be more than " + MIN_PRICE + " €");
        victim.validate(product);
    }

    @Test
    public void shouldValidate_WithoutException() {
        product.setPrice(MIN_PRICE_TO_SET_DISCOUNT);
        victim.validate(product);
    }

    @After
    public void afterTest() {
        victim = null;
        product = null;
    }


}