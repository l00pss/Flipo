package az.rock.ws.validator.constrains;

import az.rock.lib.adapter.annotation.JComponent;
import az.rock.lib.message.MessageProvider;
import az.rock.ws.exception.InvalidFieldFormatException;
import az.rock.ws.port.output.repository.abstracts.AbstractUserRepository;
import az.rock.ws.validator.annotations.JEmailConstraint;
import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@JComponent
@Slf4j
public class JEmailValidator implements ConstraintValidator<JEmailConstraint, String> {

    private final AbstractUserRepository userRepository;
    private final MessageProvider messageProvider;
    private final ValidatorUtil validatorUtil;

    private String name;
    private boolean nullable;
    private boolean empty;
    private boolean unique;

    public JEmailValidator(AbstractUserRepository userRepository, MessageProvider messageProvider, ValidatorUtil validatorUtil) {
        this.userRepository = userRepository;
        this.messageProvider = messageProvider;
        this.validatorUtil = validatorUtil;
    }

    @Override
    public void initialize(JEmailConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        this.name = constraintAnnotation.name();
        this.nullable = constraintAnnotation.nullable();
        this.empty = constraintAnnotation.empty();
        this.unique  = constraintAnnotation.unique();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(!nullable) this.validatorUtil.checkEmpty.accept(value,this.messageProvider.fail("F_0000000004"));
        if (unique && this.userRepository.findByUsername(value) != null)
            throw new InvalidFieldFormatException(this.messageProvider.fail("F_0000000007"));
        return true;
    }
}
