package tech.spring.structure.scaffold;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import tech.spring.structure.auth.model.Role;
import tech.spring.structure.scaffold.model.ConditionalType;

@Inherited
@Documented
@Target(FIELD)
@Retention(RUNTIME)
public @interface ScaffoldProperty {

    String type() default "text";

    String path() default "";

    String template() default "";

    String gloss() default "";

    String help() default "";

    String proxy() default "";

    String autocomplete() default "";

    boolean autofocus() default false;

    boolean hidden() default false;

    boolean disabled() default false;

    boolean collection() default false;

    boolean join() default false;

    boolean column() default false;

    boolean facet() default false;

    boolean validate() default true;

    boolean batch() default false;

    int length() default 64;

    PropertyHeader header() default @PropertyHeader(text = "");

    ScaffoldConditional[] conditionals() default {};

    Role[] whitelist() default {};

    Role[] blacklist() default {};

    JoinSelectFilter[] filters() default {};

    @Documented
    @Target(FIELD)
    @Retention(RUNTIME)
    public @interface PropertyHeader {

        String text();

        boolean italicized() default false;

    }

    @Documented
    @Target(FIELD)
    @Retention(RUNTIME)
    public @interface JoinSelectFilter {

        String property();

        String value();

    }

    @Documented
    @Target(FIELD)
    @Retention(RUNTIME)
    public @interface ScaffoldConditional {

        ConditionalType type();

        String path();

        String value();

    }

}
