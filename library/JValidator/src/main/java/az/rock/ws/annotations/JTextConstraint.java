package az.rock.ws.annotations;

import az.rock.ws.constrains.JTextValidator;

import javax.validation.Constraint;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = JTextValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface JTextConstraint {
    boolean nullable() default false;
    String name() default "Dəyər";
    boolean unique() default false;
    boolean empty() default false;
}
