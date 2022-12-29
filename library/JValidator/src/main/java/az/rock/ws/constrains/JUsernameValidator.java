package az.rock.ws.constrains;

import az.rock.ws.annotations.JTextConstraint;
import az.rock.ws.annotations.JUsernameConstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class JUsernameValidator implements ConstraintValidator<JUsernameConstraint, String> {
    @Override
    public void initialize(JUsernameConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return false;
    }
}
