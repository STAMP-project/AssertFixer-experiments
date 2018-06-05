package org.springframework.data.mongodb.core.index;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QIndexingIntegrationTests_IndexedPerson is a Querydsl query type for IndexedPerson
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QIndexingIntegrationTests_IndexedPerson extends EntityPathBase<IndexingIntegrationTests.IndexedPerson> {

    private static final long serialVersionUID = -130619353L;

    public static final QIndexingIntegrationTests_IndexedPerson indexedPerson = new QIndexingIntegrationTests_IndexedPerson("indexedPerson");

    public final StringPath firstname = createString("firstname");

    public final StringPath lastname = createString("lastname");

    public QIndexingIntegrationTests_IndexedPerson(String variable) {
        super(IndexingIntegrationTests.IndexedPerson.class, forVariable(variable));
    }

    public QIndexingIntegrationTests_IndexedPerson(Path<? extends IndexingIntegrationTests.IndexedPerson> path) {
        super(path.getType(), path.getMetadata());
    }

    public QIndexingIntegrationTests_IndexedPerson(PathMetadata metadata) {
        super(IndexingIntegrationTests.IndexedPerson.class, metadata);
    }

}

