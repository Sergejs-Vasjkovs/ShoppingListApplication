package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.service.validation.ProductDiscountValidationRuleTest;
import com.javaguru.shoppinglist.service.validation.ProductNameValidationRuleTest;
import com.javaguru.shoppinglist.service.validation.ProductPriceValidationRuleTest;
import com.javaguru.shoppinglist.service.validation.ProductValidationServiceTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ProductDiscountValidationRuleTest.class,
        ProductNameValidationRuleTest.class,
        ProductPriceValidationRuleTest.class,
        ProductValidationServiceTest.class
})

public class ProductValidationSuite {

}
