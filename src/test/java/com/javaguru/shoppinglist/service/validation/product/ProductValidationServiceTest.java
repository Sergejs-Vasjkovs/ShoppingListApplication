package com.javaguru.shoppinglist.service.validation.product;

import com.javaguru.shoppinglist.domain.Product;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)

public class ProductValidationServiceTest {

    Product product;
    @Mock
    private ProductUniqueNameValidationRule productUniqueNameValidationRule;
    @Mock
    private ProductNameValidationRule productNameValidationRule;
    @Mock
    private List<ProductValidationRule> validationRules;

    @Captor
    private ArgumentCaptor<Product> captor;
    @Mock
    private ProductValidationService victim;

    @Before
    public void setUp() {
        validationRules = new LinkedList<>();
        validationRules.add(productUniqueNameValidationRule);
        validationRules.add(productNameValidationRule);

        victim = new ProductValidationService(validationRules);

        product = new Product();
        product.setId(5L);
        product.setName("TEST_NAME");
    }

    @Test
    public void validate_ShouldValidateProduct() {
        victim.validate(product);

        verify(productUniqueNameValidationRule).validate(captor.capture());
        verify(productNameValidationRule).validate(captor.capture());

        assertThat(validationRules, hasItem(productUniqueNameValidationRule));
        assertThat(validationRules, hasItem(productNameValidationRule));
    }
}