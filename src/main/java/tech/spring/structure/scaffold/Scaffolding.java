package tech.spring.structure.scaffold;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Inherited
@Documented
@Target(TYPE)
@Retention(RUNTIME)
public @interface Scaffolding {

    String[] order() default {};

    int numberOfColumns() default 1;

    boolean allowCreate() default false;

    boolean allowBatch() default false;

    boolean allowDelete() default false;

    boolean readOnly() default false;

    String image() default "";

    String title() default "";

    String subTitle() default "";

    String noticeHeader() default "";

    String notice() default "";

    String note() default "";

}
