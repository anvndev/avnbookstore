package bookstore.avn.avnbookstore.validator.annotation;

import bookstore.avn.avnbookstore.validator.ValidUsernameValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.springframework.context.annotation.Conditional;

import javax.xml.transform.sax.SAXResult;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({TYPE, FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = ValidUsernameValidator.class)
public @interface ValidUsername {
    String message() default " Username already exits";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
