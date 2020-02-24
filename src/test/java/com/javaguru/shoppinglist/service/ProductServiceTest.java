package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.database.InMemoryRepository;
import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.service.validation.ProductValidationException;
import com.javaguru.shoppinglist.service.validation.ProductValidationService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.Silent.class)
public class ProductServiceTest {

    @Spy
    private InMemoryRepository spyRepository = new InMemoryRepository();
    @Mock
    private InMemoryRepository repository;
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
        repository.insert(expectedProduct);
        verify(repository, times(1)).insert(expectedProduct);

        verify(repository).insert(productCaptor.capture());
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

    @Test
    public void addProduct_whenProductOk_shouldAddProduct_WithsSpy() {
        spyRepository.insert(expectedProduct);
        Long id = expectedProduct.getId();
        assertEquals(expectedProduct, spyRepository.findProductById(id));
    }
}