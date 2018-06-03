package annotation;

import java.lang.annotation.*;

@Documented //generated this annotation in JavaDoc
@Inherited //extends children's
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Service {

    boolean lazyLoad() default false;
    String name();
    Mood mood();
    enum Mood {GOOD, BAD};
}
