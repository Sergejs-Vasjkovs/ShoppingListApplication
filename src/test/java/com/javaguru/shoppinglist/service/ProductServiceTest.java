package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.database.HibernateProductRepository;
import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.service.validation.product.ProductValidationException;
import com.javaguru.shoppinglist.service.validation.product.ProductValidationService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.Silent.class)
public class ProductServiceTest {

    @Mock
    private HibernateProductRepository repository;
    @Mock
    private ProductValidationService productValidationService;

    @InjectMocks
    private ProductService victim;

    @Captor
    private ArgumentCaptor<Product> productCaptor;

    private Product expectedProduct;

    @Before
    public void setUp() {
        expectedProduct = new Product();
        expectedProduct.setId(5L);
        expectedProduct.setName("TEST_NAME");
    }

    @Test(expected = ProductValidationException.class)
    public void findProductByID_whenProductNotExist_shouldThrowProductValidationException() {
        victim.findProductByID(5L);
    }

    @Test
    public void addProduct_whenProductOk_shouldInsertProduct() {
        repository.save(expectedProduct);
        verify(repository, times(1)).save(expectedProduct);

        verify(repository).save(productCaptor.capture());
        Product addedProduct = productCaptor.getValue();
        assertEquals(expectedProduct.getId(), addedProduct.getId());

        productValidationService.validate(expectedProduct);
        verify(productValidationService, times(1)).validate(expectedProduct);

        verify(productValidationService).validate(productCaptor.capture());
        Product validatedProduct = productCaptor.getValue();
        assertEquals(expectedProduct, validatedProduct);
    }

    @Test
    public void shouldCheckIfProductExistByName() {
        repository.ifProductExistByName(expectedProduct.getName());
        verify(repository, times(1))
                .ifProductExistByName(expectedProduct.getName());
    }

}