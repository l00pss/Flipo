package az.rock.lib.annotations;

public @interface JPost {
    String api();
    String description() default "";
    boolean hasBody();
}
