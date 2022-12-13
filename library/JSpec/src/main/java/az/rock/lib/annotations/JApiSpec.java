package az.rock.lib.annotations;

public @interface JApiSpec {
    String url();
    Permission[] permissions() default Permission.PUBLIC;
}
