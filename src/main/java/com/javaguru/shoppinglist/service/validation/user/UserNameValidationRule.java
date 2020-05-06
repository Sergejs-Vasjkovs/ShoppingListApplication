package com.javaguru.shoppinglist.service.validation.user;

import com.javaguru.shoppinglist.domain.User;
import org.springframework.stereotype.Component;

import static com.javaguru.shoppinglist.domain.StaticValues.MAX_USER_NAME_LENGTH;
import static com.javaguru.shoppinglist.domain.StaticValues.MIN_USER_NAME_LENGTH;

@Component
public class UserNameValidationRule implements UserValidationRule {

    @Override
    public void validate(User user) {
        checkNotNull(user);
        if (user.getName().length() > MAX_USER_NAME_LENGTH || user.getName().length() < MIN_USER_NAME_LENGTH) {
            throw new UserValidationException("User name minimum length is " + MIN_USER_NAME_LENGTH +
                    " characters, maximum is " + MAX_USER_NAME_LENGTH);
        }
    }
}
