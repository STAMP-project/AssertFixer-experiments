package com.github.cbismuth.algolia.quickstart.repository;

import com.algolia.search.objects.Query;
import com.github.cbismuth.algolia.quickstart.SpringITest;
import com.github.cbismuth.algolia.quickstart.actor.Actor;
import com.github.cbismuth.algolia.quickstart.actor.ActorBuilder;
import com.github.cbismuth.algolia.quickstart.actor.ActorRepository;
import com.github.cbismuth.algolia.quickstart.client.AbstractRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ActorRepositoryITest extends SpringITest {

    @Autowired
    private ActorRepository actorRepository;

    @Test
    public void test_CRUD_similarity_async() throws Exception {
        final Actor input = ActorBuilder.createBuilder()
                                        .setObjectId("christophe.bismuth@gmail.com")
                                        .setName("Christophe Bismuth")
                                        .setRating("★★★")
                                        .setAlternativeName("cbismuth")
                                        .setImagePath("https://github.com/cbismuth/")
                                        .build();

        actorRepository.addObject(input)
                       .whenComplete((asyncTaskIndexing, throwable) -> {
                           final String objectId = asyncTaskIndexing.getObjectID();
                           Assertions.assertThat(objectId).isNotBlank();

                           actorRepository.getAsyncIndexForSearchOnly()
                                          .search(new Query("bsmth"))
                                          .whenComplete((searchResult, throwable1) -> {
                                              final List<Actor> hits = searchResult.getHits();

                                              Assertions.assertThat(hits).hasSize(1);
                                              Assertions.assertThat(hits.get(0).getObjectId()).isEqualTo("christophe.bismuth@gmail.com");

                                              actorRepository.deleteObject(objectId);
                                          });
                       })
                       .get(AbstractRepository.DEFAULT_TIMEOUT_DURATION, AbstractRepository.DEFAULT_TIMEOUT_UNIT);
    }
}
