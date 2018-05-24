package com.github.cbismuth.algolia.quickstart.client;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.retry.backoff.ExponentialBackOffPolicy;
import org.springframework.retry.policy.TimeoutRetryPolicy;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class RetryTemplateFactoryBean implements FactoryBean<RetryTemplate> {

    private static final long INITIAL_INTERVAL = TimeUnit.SECONDS.toMillis(1);
    private static final long MAX_INTERVAL = TimeUnit.SECONDS.toMillis(30);
    private static final double MULTIPLIER = 1.25;

    @Override
    public RetryTemplate getObject() {
        final ExponentialBackOffPolicy backOffPolicy = new ExponentialBackOffPolicy();
        backOffPolicy.setInitialInterval(INITIAL_INTERVAL);
        backOffPolicy.setMaxInterval(MAX_INTERVAL);
        backOffPolicy.setMultiplier(MULTIPLIER);

        final TimeoutRetryPolicy retryPolicy = new TimeoutRetryPolicy();
        retryPolicy.setTimeout(backOffPolicy.getMaxInterval());

        final RetryTemplate retryTemplate = new RetryTemplate();
        retryTemplate.setBackOffPolicy(backOffPolicy);
        retryTemplate.setRetryPolicy(retryPolicy);

        return retryTemplate;
    }

    @Override
    public Class<?> getObjectType() {
        return RetryTemplate.class;
    }
}
