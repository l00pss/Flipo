package az.rock.ws.validator.annotations;

import az.rock.ws.validator.constrains.JEmailValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = JEmailValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface JEmailConstraint {
    String message() default "Sorry, somethings went wrong";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    boolean nullable() default false;
    String name() default "Elektron poçt";
    boolean unique() default false;
    boolean empty() default false;
}
