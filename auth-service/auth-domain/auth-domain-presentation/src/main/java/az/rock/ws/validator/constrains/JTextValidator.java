package az.rock.ws.validator.constrains;

import az.rock.lib.adapter.annotation.JComponent;
import az.rock.ws.port.input.service.abstracts.UserAuthService;
import az.rock.ws.validator.annotations.JPasswordConstraint;
import az.rock.ws.validator.annotations.JTextConstraint;
import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
@JComponent
@Slf4j
public class JTextValidator implements ConstraintValidator<JTextConstraint, String> {

    private UserAuthService userAuthService;
    private String name;
    private boolean nullable;
    private boolean empty;
    private boolean unique;

    @Override
    public void initialize(JTextConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        this.name = constraintAnnotation.name();
        this.nullable = constraintAnnotation.nullable();
        this.empty = constraintAnnotation.empty();
        this.unique  = constraintAnnotation.unique();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        log.info("Text Validator in running");
        return true;
    }
}
