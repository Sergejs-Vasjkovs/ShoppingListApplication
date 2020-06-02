package com.javaguru.shoppinglist.service.validation.user;

import com.javaguru.shoppinglist.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserValidationService {

    private final List<UserValidationRule> validationRules;

    @Autowired
    public UserValidationService(List<UserValidationRule> validationRules) {
        this.validationRules = validationRules;
    }

    public void validate(User user) {
        validationRules.forEach(rule -> rule.validate(user));
    }
}
