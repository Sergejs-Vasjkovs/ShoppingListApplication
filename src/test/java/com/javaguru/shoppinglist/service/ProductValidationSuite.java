package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.service.validation.product.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ProductDiscountValidationRuleTest.class,
        ProductNameValidationRuleTest.class,
        ProductPriceValidationRuleTest.class,
        ProductUniqueNameValidationRuleTest.class,
        ProductValidationServiceTest.class,
        ProductServiceTest.class
        })

public class ProductValidationSuite {

}
