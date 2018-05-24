package com.github.cbismuth.algolia.quickstart.listener;

import com.algolia.search.objects.tasks.async.AsyncTaskSingleIndex;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.cbismuth.algolia.quickstart.client.AbstractRepository;
import com.github.cbismuth.algolia.quickstart.nobel.Laureate;
import com.github.cbismuth.algolia.quickstart.nobel.NobelPrizeRepository;
import org.assertj.core.api.Assertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.retry.RetryContext;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

import java.util.List;

import static com.google.common.base.Charsets.UTF_8;

@Component
class NobelPrizesIndexInitializer implements IndexInitializer {

    private static final Logger LOGGER = LoggerFactory.getLogger(NobelPrizesIndexInitializer.class);

    private final NobelPrizeRepository nobelPrizeRepository;

    NobelPrizesIndexInitializer(final NobelPrizeRepository nobelPrizeRepository) {
        this.nobelPrizeRepository = nobelPrizeRepository;
    }

    @Override
    public AsyncTaskSingleIndex doWithRetry(final RetryContext context) throws Exception {
        final String json = StreamUtils.copyToString(new ClassPathResource("data/nobel_prizes.json").getInputStream(), UTF_8);

        final List<Laureate> laureates = new ObjectMapper().readValue(json, new TypeReference<List<Laureate>>() {
            // NOP
        });

        return nobelPrizeRepository.addObjects(laureates)
                                   .whenComplete((asyncTaskSingleIndex, throwable) -> {
                                       final int objectCount = asyncTaskSingleIndex.getObjectIDs().size();

                                       Assertions.assertThat(objectCount).isEqualTo(923);

                                       LOGGER.info("[{}] Nobel Laureates added to index [{}]", objectCount, nobelPrizeRepository.getIndexName());
                                   })
                                   .get(AbstractRepository.DEFAULT_TIMEOUT_DURATION, AbstractRepository.DEFAULT_TIMEOUT_UNIT);
    }
}
