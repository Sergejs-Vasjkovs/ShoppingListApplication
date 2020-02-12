package com.javaguru.shoppinglist.service.validation;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)

public class ProductValidationServiceTest {

    private ProductValidationService victim;

    @Captor
    private ArgumentCaptor<ProductValidationRule> productValidationRuleArgumentCaptor;

    @Before
    public void setUp() {
        victim = new ProductValidationService();
    }

    @Test
    public void validationRule_shouldAddThreeRules() {
        List<ProductValidationRule> expectedResult = victim.getValidationRulesList();
        assertNotNull(expectedResult);
        assertEquals(3, expectedResult.size());
    }

}