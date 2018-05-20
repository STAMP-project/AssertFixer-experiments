package hu.elte.recipe.annotations;

import hu.elte.recipe.entities.Role;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// TODO: Auto-generated Javadoc
/**
 * The Interface BusinessRole.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface BusinessRole {
    
    /**
     * Value.
     *
     * @return the role[]
     */
    Role[] value() default {Role.GUEST};
}
