
package com.github.cbismuth.algolia.quickstart.nobel;

import com.github.cbismuth.algolia.quickstart.client.AbstractRepository;
import com.github.cbismuth.algolia.quickstart.client.AdminClientFactory;
import com.github.cbismuth.algolia.quickstart.client.SearchClientFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

@Repository
public class NobelPrizeRepository extends AbstractRepository<Laureate> {

    private final String indexName;

    public NobelPrizeRepository(final AdminClientFactory adminClientFactory,
                                final SearchClientFactory searchClientFactory,
                                @Value("${nobel_prizes.index.name}") final String indexName) {
        super(adminClientFactory, searchClientFactory);

        this.indexName = indexName;
    }

    @PostConstruct
    private void setupIndex() {
        addAttributeForFacetingIfNotExists(indexName, "nobel_prizes");
    }

    @Override
    public String getIndexName() {
        return indexName;
    }

    @Override
    public Class<Laureate> getType() {
        return Laureate.class;
    }
}
