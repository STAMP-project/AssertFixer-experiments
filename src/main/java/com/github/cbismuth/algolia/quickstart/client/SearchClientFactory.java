package com.github.cbismuth.algolia.quickstart.client;

import com.algolia.search.AsyncAPIClient;
import com.algolia.search.AsyncHttpAPIClientBuilder;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class SearchClientFactory implements FactoryBean<AsyncAPIClient> {

    private final String applicationId;
    private final String searchOnlyApiKey;

    public SearchClientFactory(@Value("#{environment.APPLICATION_ID}") final String applicationId,
                               @Value("#{environment.SEARCH_ONLY_API_KEY}") final String searchOnlyApiKey) {
        Assert.hasText(applicationId, "[applicationId] must have text");
        Assert.hasText(searchOnlyApiKey, "[searchOnlyApiKey] must have text");

        this.applicationId = applicationId;
        this.searchOnlyApiKey = searchOnlyApiKey;
    }

    @Override
    public AsyncAPIClient getObject() {
        return new AsyncHttpAPIClientBuilder(applicationId, searchOnlyApiKey).build();
    }

    @Override
    public Class<?> getObjectType() {
        return AsyncHttpAPIClientBuilder.class;
    }
}
