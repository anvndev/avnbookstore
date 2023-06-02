package bookstore.avn.avnbookstore.validator;

import bookstore.avn.avnbookstore.repository.IUserRepository;
import bookstore.avn.avnbookstore.validator.annotation.ValidUsername;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.NullLiteral;

public class ValidUsernameValidator implements ConstraintValidator<ValidUsername, String> {
    @Autowired
    private IUserRepository userRepostory;

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context){
        if (userRepostory == null)
            return true;
        return userRepostory.findByUsername(username) == null;
    }
}
