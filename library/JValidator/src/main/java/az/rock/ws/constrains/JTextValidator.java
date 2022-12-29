package az.rock.ws.constrains;

import az.rock.ws.annotations.JTextConstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class JTextValidator implements ConstraintValidator<JTextConstraint, String> {

    @Override
    public void initialize(JTextConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return false;
    }
}
