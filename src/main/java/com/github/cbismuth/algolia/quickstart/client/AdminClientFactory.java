package com.github.cbismuth.algolia.quickstart.client;

import com.algolia.search.AsyncAPIClient;
import com.algolia.search.AsyncHttpAPIClientBuilder;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class AdminClientFactory implements FactoryBean<AsyncAPIClient> {

    private final String applicationId;
    private final String adminApiKey;

    public AdminClientFactory(@Value("#{environment.APPLICATION_ID}") final String applicationId,
                              @Value("#{environment.ADMIN_API_KEY}") final String adminApiKey) {
        Assert.hasText(applicationId, "[applicationId] must have text");
        Assert.hasText(adminApiKey, "[adminApiKey] must have text");

        this.applicationId = applicationId;
        this.adminApiKey = adminApiKey;
    }

    @Override
    public AsyncAPIClient getObject() {
        return new AsyncHttpAPIClientBuilder(applicationId, adminApiKey).build();
    }

    @Override
    public Class<?> getObjectType() {
        return AsyncAPIClient.class;
    }
}
