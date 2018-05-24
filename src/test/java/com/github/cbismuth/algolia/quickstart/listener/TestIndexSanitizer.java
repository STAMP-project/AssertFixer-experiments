package com.github.cbismuth.algolia.quickstart.listener;

import com.algolia.search.AsyncAPIClient;
import com.github.cbismuth.algolia.quickstart.client.AbstractRepository;
import com.github.cbismuth.algolia.quickstart.client.AdminClientFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
class TestIndexSanitizer implements ApplicationListener<ContextClosedEvent> {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestIndexSanitizer.class);

    private final AsyncAPIClient adminClient;
    private final List<AbstractRepository> repositories;

    TestIndexSanitizer(final AdminClientFactory adminClientFactory, final List<AbstractRepository> repositories) {
        adminClient = adminClientFactory.getObject();

        this.repositories = repositories;
    }

    @Override
    public void onApplicationEvent(final ContextClosedEvent event) {
        deleteIndices();
    }

    private void deleteIndices() {
        repositories.stream()
                    .map(AbstractRepository::getIndexName)
                    .forEach(indexName -> {
                        try {
                            adminClient.deleteIndex(indexName)
                                       .whenComplete((asyncTask, throwable) -> LOGGER.info("Index [{}] deleted", indexName))
                                       .get(AbstractRepository.DEFAULT_TIMEOUT_DURATION, AbstractRepository.DEFAULT_TIMEOUT_UNIT);
                        } catch (final Exception e) {
                            LOGGER.error(e.getMessage(), e);
                        }
                    });
    }
}
