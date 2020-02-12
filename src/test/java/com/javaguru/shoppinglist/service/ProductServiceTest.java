package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.database.InMemoryRepository;
import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.service.validation.ProductValidationException;
import com.javaguru.shoppinglist.service.validation.ProductValidationService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

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
        expectedProduct = createProduct();
    }

    @Test
    public void findProductByID_whenProductExists_shouldReturnObjectByID() {
        when(repository.findProductById(5L)).thenReturn(expectedProduct);
        Product actualResult = victim.findProductByID(5L);
        assertEquals(expectedProduct, actualResult);
    }

    @Test(expected = ProductValidationException.class)
    public void findProductByID_whenProductNotExist_shouldThrowProductValidationException() {
        when(repository.findProductById(5L)).thenReturn(null);
        victim.findProductByID(5L);
    }

    @Test
    public void AddProduct_whenProductOk_shouldAddProduct() {
        repository.addProduct(expectedProduct);
        verify(repository, times(1)).addProduct(expectedProduct);
    }

    @Test
    public void shouldCheckIfProductExistByName() {
        repository.ifProductExistByName(expectedProduct.getName());
        verify(repository, times(1))
                .ifProductExistByName(expectedProduct.getName());
    }

    public Product createProduct() {
        Product product = new Product();
        product.setId(5L);
        product.setName("TEST_NAME");
        return product;
    }

}