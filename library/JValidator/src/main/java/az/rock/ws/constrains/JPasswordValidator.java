package az.rock.ws.constrains;

import az.rock.ws.annotations.JPasswordConstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class JPasswordValidator implements ConstraintValidator<JPasswordConstraint, String> {
    @Override
    public void initialize(JPasswordConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return false;
    }
}
