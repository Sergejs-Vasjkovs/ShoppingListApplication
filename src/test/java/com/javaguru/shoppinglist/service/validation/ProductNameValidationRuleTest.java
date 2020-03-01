package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static com.javaguru.shoppinglist.domain.Product.*;

public class ProductNameValidationRuleTest {

    @Rule
    public final ExpectedException expectedException = ExpectedException.none();

    private ProductNameValidationRule victim;
    private Product product;

    @Before
    public void setUp() {
        victim = new ProductNameValidationRule();
        product = new Product();
    }

    @Test
    public void shouldThrow_ProductNameValidationException_NameLengthToShort() {
        product.setName(RandomStringUtils.randomAlphabetic(MIN_NAME_LENGTH - 1));
        expectedException.expect(ProductValidationException.class);
        expectedException.expectMessage("Product name minimum length is " + MIN_NAME_LENGTH +
                " characters, maximum is " + MAX_NAME_LENGTH);
        victim.validate(product);
    }

    @Test
    public void shouldThrow_ProductNameValidationException_NameLengthToLong() {
        product.setName(RandomStringUtils.randomAlphabetic(MAX_NAME_LENGTH + 1));
        expectedException.expect(ProductValidationException.class);
        expectedException.expectMessage("Product name minimum length is " + MIN_NAME_LENGTH +
                " characters, maximum is " + MAX_NAME_LENGTH);
        victim.validate(product);
    }

    @Test
    public void shouldValidate_WithoutException() {
        product.setName(RandomStringUtils.randomAlphabetic(MAX_NAME_LENGTH));
        victim.validate(product);
    }

    @After
    public void afterTest() {
        victim = null;
        product = null;
    }
}