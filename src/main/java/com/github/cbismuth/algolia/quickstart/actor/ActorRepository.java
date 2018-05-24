
package com.github.cbismuth.algolia.quickstart.actor;

import com.github.cbismuth.algolia.quickstart.client.AbstractRepository;
import com.github.cbismuth.algolia.quickstart.client.AdminClientFactory;
import com.github.cbismuth.algolia.quickstart.client.SearchClientFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

@Repository
public class ActorRepository extends AbstractRepository<Actor> {

    private final String indexName;

    public ActorRepository(final AdminClientFactory adminClientFactory,
                           final SearchClientFactory searchClientFactory,
                           @Value("${actors.index.name}") final String indexName) {
        super(adminClientFactory, searchClientFactory);

        this.indexName = indexName;
    }

    @PostConstruct
    private void setupIndex() {
        addAttributeForFacetingIfNotExists(indexName, "rating");
    }

    @Override
    public String getIndexName() {
        return indexName;
    }

    @Override
    public Class<Actor> getType() {
        return Actor.class;
    }
}
