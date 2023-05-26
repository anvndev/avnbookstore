package bookstore.avn.avnbookstore.validator;

import bookstore.avn.avnbookstore.entity.Category;
import bookstore.avn.avnbookstore.validator.annotation.ValidCategoryId;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidCategoryIdValidator implements ConstraintValidator<ValidCategoryId, Category> {
    @Override
    public boolean isValid(Category category, ConstraintValidatorContext context) {
        return category != null && category.getId() != 0;
    }
}
