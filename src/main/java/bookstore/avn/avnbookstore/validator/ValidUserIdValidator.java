package bookstore.avn.avnbookstore.validator;

import bookstore.avn.avnbookstore.entity.User;
import bookstore.avn.avnbookstore.validator.annotation.ValidUserId;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidUserIdValidator implements ConstraintValidator<ValidUserId, User> {
    @Override
    public boolean isValid(User user, ConstraintValidatorContext context){
        if (user == null)
            return true;
        return user.getId() != null;
    }
}
