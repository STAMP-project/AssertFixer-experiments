package com.bindstone.portfolio.aspect;

import com.bindstone.portfolio.annotations.Auditable;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * Aspect for logging execution of service and repository Spring components.
 */
@Aspect
@Component
public class AuditAspect {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private Environment env;

    @Around("execution(@com.bindstone.portfolio.annotations.Auditable * *(..)) && @annotation(auditable)")
    public Object aroundAdvice(ProceedingJoinPoint jp, Auditable auditable) throws Throwable {
        if (auditable != null && auditable.text() != null) {
            log.info("");
        } else {
            log.info("AUDITABLE CUTPOINT without text...");
        }
        return jp.proceed();
    }
}
