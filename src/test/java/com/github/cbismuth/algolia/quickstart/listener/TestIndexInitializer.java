package com.github.cbismuth.algolia.quickstart.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
class TestIndexInitializer implements ApplicationListener<ContextRefreshedEvent> {

    private final RetryTemplate retryTemplate;
    private final List<IndexInitializer> indexInitializers;

    TestIndexInitializer(final RetryTemplate retryTemplate,
                         final List<IndexInitializer> indexInitializers) {
        this.retryTemplate = retryTemplate;
        this.indexInitializers = indexInitializers;
    }

    @Override
    public void onApplicationEvent(final ContextRefreshedEvent event) {
        indexInitializers.forEach(indexInitializer -> {
            try {
                retryTemplate.execute(indexInitializer);
            } catch (final Exception e) {
                throw new RuntimeException(e);
            }
        });
    }
}
