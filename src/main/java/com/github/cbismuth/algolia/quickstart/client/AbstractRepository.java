package com.github.cbismuth.algolia.quickstart.client;

import com.algolia.search.AsyncAPIClient;
import com.algolia.search.AsyncIndex;
import com.algolia.search.exceptions.AlgoliaException;
import com.algolia.search.objects.IndexSettings;
import com.algolia.search.objects.tasks.async.AsyncTask;
import com.algolia.search.objects.tasks.async.AsyncTaskIndexing;
import com.algolia.search.objects.tasks.async.AsyncTaskSingleIndex;
import com.github.cbismuth.algolia.quickstart.actor.Actor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import javax.annotation.PreDestroy;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@Repository
public abstract class AbstractRepository<T> {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractRepository.class);

    public static final long DEFAULT_TIMEOUT_DURATION = 5;
    public static final TimeUnit DEFAULT_TIMEOUT_UNIT = TimeUnit.SECONDS;

    private final AsyncAPIClient adminClient;
    private final AsyncAPIClient searchClient;

    protected AbstractRepository(final AdminClientFactory adminClientFactory, final SearchClientFactory searchClientFactory) {
        Assert.notNull(adminClientFactory, "[adminClientFactory] must not be null");
        Assert.notNull(searchClientFactory, "[searchClientFactory] must not be null");

        adminClient = adminClientFactory.getObject();
        searchClient = searchClientFactory.getObject();
    }

    public abstract String getIndexName();

    public abstract Class<T> getType();

    public AsyncIndex<T> getAsyncIndexForSearchOnly() {
        return getSearchClient().initIndex(getIndexName(), getType());
    }

    public CompletableFuture<AsyncTaskIndexing> addObject(final T input) {
        return getAdminClient().initIndex(getIndexName(), getType())
                               .addObject(input);
    }

    public CompletableFuture<AsyncTaskSingleIndex> addObjects(final List<T> inputs) {
        return getAdminClient().initIndex(getIndexName(), getType())
                               .addObjects(inputs);
    }

    public CompletableFuture<AsyncTask> deleteObject(final String objectId) {
        return getAdminClient().initIndex(getIndexName(), Actor.class)
                               .deleteObject(objectId);
    }

    private AsyncAPIClient getAdminClient() {
        return adminClient;
    }

    private AsyncAPIClient getSearchClient() {
        return searchClient;
    }

    protected void addAttributeForFacetingIfNotExists(final String indexName, final String attributeForFaceting) {
        try {
            adminClient.initIndex(indexName)
                       .getSettings()
                       .whenComplete((nullableIndexSettings, throwable) -> {
                           final IndexSettings indexSettings = Optional.ofNullable(nullableIndexSettings).orElse(new IndexSettings());

                           final List<String> attributesForFaceting = indexSettings.getAttributesForFaceting();

                           if (attributesForFaceting == null || !attributesForFaceting.contains(attributeForFaceting)) {
                               indexSettings.setAttributesForFaceting(Collections.singletonList(attributeForFaceting));

                               adminClient.initIndex(indexName)
                                          .setSettings(indexSettings)
                                          .whenComplete((asyncTask, throwable1) -> LOGGER.info("[{}] attribute added for faceting to index [{}]", attributeForFaceting, indexName));
                           } else {
                               LOGGER.debug("[{}] attribute already added for faceting to index [{}]", attributeForFaceting, indexName);
                           }
                       })
                       .get(DEFAULT_TIMEOUT_DURATION, DEFAULT_TIMEOUT_UNIT);
        } catch (final Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PreDestroy
    private void closeClients() throws AlgoliaException {
        closeClient("adminClient", adminClient);
        closeClient("searchClient", searchClient);
    }

    private void closeClient(final String name, final AsyncAPIClient client) throws AlgoliaException {
        LOGGER.debug("Closing [{}] client ...", name);
        client.close();
        LOGGER.debug("[{}] client closed", name);
    }
}
