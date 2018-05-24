package com.github.cbismuth.algolia.quickstart.listener;

import com.algolia.search.objects.tasks.async.AsyncTaskSingleIndex;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.cbismuth.algolia.quickstart.actor.Actor;
import com.github.cbismuth.algolia.quickstart.actor.ActorRepository;
import com.github.cbismuth.algolia.quickstart.client.AbstractRepository;
import com.google.common.base.Charsets;
import org.assertj.core.api.Assertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.retry.RetryContext;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

import java.util.List;

@Component
class ActorsIndexInitializer implements IndexInitializer {

    private static final Logger LOGGER = LoggerFactory.getLogger(ActorsIndexInitializer.class);

    private final ActorRepository actorRepository;

    ActorsIndexInitializer(final ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @Override
    public AsyncTaskSingleIndex doWithRetry(final RetryContext context) throws Exception {
        final String json = StreamUtils.copyToString(new ClassPathResource("data/actors.json").getInputStream(), Charsets.UTF_8);

        final List<Actor> actors = new ObjectMapper().readValue(json, new TypeReference<List<Actor>>() {
            // NOP
        });

        return actorRepository.addObjects(actors)
                              .whenComplete((asyncTaskSingleIndex, throwable) -> {
                                  final int objectCount = asyncTaskSingleIndex.getObjectIDs().size();

                                  Assertions.assertThat(objectCount).isEqualTo(500);

                                  LOGGER.info("[{}] actors added to index [{}]", objectCount, actorRepository.getIndexName());
                              })
                              .get(AbstractRepository.DEFAULT_TIMEOUT_DURATION, AbstractRepository.DEFAULT_TIMEOUT_UNIT);
    }
}
