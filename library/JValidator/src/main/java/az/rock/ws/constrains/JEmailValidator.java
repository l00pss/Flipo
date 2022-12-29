package az.rock.ws.constrains;

import az.rock.ws.annotations.JEmailConstraint;
import az.rock.ws.annotations.JTextConstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class JEmailValidator implements ConstraintValidator<JEmailConstraint, String> {

    @Override
    public void initialize(JEmailConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return false;
    }
}
