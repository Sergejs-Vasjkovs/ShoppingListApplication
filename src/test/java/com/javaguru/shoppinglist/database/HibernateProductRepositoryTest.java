package com.javaguru.shoppinglist.database;

import com.javaguru.shoppinglist.domain.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class HibernateProductRepositoryTest {

    private static String TEST_NAME = "TEST_NAME";

    @Mock
    private HibernateProductRepository InMemoryRepository;
    private Product expectedProduct;

    @Before
    public void setUp() {
        expectedProduct = new Product();
        expectedProduct.setId(5L);
        expectedProduct.setName(TEST_NAME);
    }

    @Test
    public void ifProductExistByName_shouldReturnTrue() {
        when(InMemoryRepository.ifProductExistByName(TEST_NAME)).thenReturn(true);
        boolean result = InMemoryRepository.ifProductExistByName(TEST_NAME);
        Assert.assertTrue(result);
    }

    @Test
    public void ifProductExistByName_shouldReturnFalse() {
        when(InMemoryRepository.ifProductExistByName("False Name")).thenReturn(false);
        boolean result = InMemoryRepository.ifProductExistByName("False Name");
        Assert.assertFalse(result);
    }

    @Test
    public void findProductByName_ShouldReturnObject() {
        when(InMemoryRepository.findProductByName(TEST_NAME)).thenReturn(expectedProduct);
        Product actualProduct = InMemoryRepository.findProductByName(TEST_NAME);
        Assert.assertSame(expectedProduct, actualProduct);
    }

    @Test
    public void findProductByName_ShouldReturnNull() {
        Product actualProduct = InMemoryRepository.findProductByName("False Name");
        Assert.assertNull(actualProduct);
    }

}