package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.database.HibernateRepository;
import com.javaguru.shoppinglist.domain.Product;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductUniqueNameValidationRuleTest {

    @Rule
    public final ExpectedException expectedException = ExpectedException.none();

    @Mock
    HibernateRepository inMemoryRepository;

    @InjectMocks
    ProductUniqueNameValidationRule victim;

    Product expectedProduct;

    @Before
    public void setUp() {
        expectedProduct = new Product();
        expectedProduct.setId(1L);
        expectedProduct.setName("Beer");
    }

    @Test
    public void validate_whenProductExistByName() {
        victim.validate(expectedProduct);
    }

    @Test
    public void validate_ShouldThrowProductUniqueNameValidationRule_ProductAlreadyExist() {
        when(inMemoryRepository.ifProductExistByName(expectedProduct.getName())).thenReturn(true);
        expectedException.expect(ProductValidationException.class);
        expectedException.expectMessage("Product " + expectedProduct.getName() + " already exist.");
        victim.validate(expectedProduct);
    }

    @Test
    public void validate_ShouldThrowProductValidationException_CheckByNull() {
        expectedException.expect(ProductValidationException.class);
        expectedException.expectMessage("Product is null");
        victim.validate(null);
    }
}