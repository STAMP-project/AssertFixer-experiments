package com.bonjourcs.java.ltjl.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * @author Liang Chenghao
 * Description: Annotation Security
 * Date: 2018/4/2
 */
@Target(ElementType.METHOD)
public @interface Security {

    /**
     * roles to access security module
     *
     * @return role list
     */
    String[] roles();

    /**
     * session timeout
     * default never invalid
     */
    long timeout() default -1L;

}
