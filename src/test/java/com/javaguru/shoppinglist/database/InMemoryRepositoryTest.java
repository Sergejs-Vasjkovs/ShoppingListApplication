package com.javaguru.shoppinglist.database;

import com.javaguru.shoppinglist.domain.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class InMemoryRepositoryTest {

    private InMemoryRepository victim;

    private Product expectedProduct;

    @Before
    public void setUp() {
        victim = new InMemoryRepository();
        expectedProduct = new Product();
        expectedProduct.setId(5L);
        expectedProduct.setName("TEST_NAME");
    }

    @Test
    public void ifProductExistByName_shouldReturnTrue() {
        victim.insert(expectedProduct);
        boolean result = victim.ifProductExistByName("TEST_NAME");
        Assert.assertTrue(result);
    }

    @Test
    public void ifProductExistByName_shouldReturnFalse() {
        victim.insert(expectedProduct);
        boolean result = victim.ifProductExistByName("False Name");
        Assert.assertFalse(result);
    }

    @Test
    public void findProductByName_ShouldReturnObject(){
        victim.insert(expectedProduct);
        Product actualProduct = victim.findProductByName(expectedProduct.getName());
        Assert.assertSame(expectedProduct, actualProduct);
    }

    @Test
    public void findProductByName_ShouldReturnNull(){
        Product actualProduct = victim.findProductByName(expectedProduct.getName());
        Assert.assertNull(actualProduct);
    }

}