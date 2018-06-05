package org.springframework.data.mongodb.core;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QReactiveMongoTemplateIndexTests_IndexedSample is a Querydsl query type for IndexedSample
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QReactiveMongoTemplateIndexTests_IndexedSample extends EntityPathBase<ReactiveMongoTemplateIndexTests.IndexedSample> {

    private static final long serialVersionUID = -1956414469L;

    public static final QReactiveMongoTemplateIndexTests_IndexedSample indexedSample = new QReactiveMongoTemplateIndexTests_IndexedSample("indexedSample");

    public final StringPath field = createString("field");

    public final StringPath id = createString("id");

    public QReactiveMongoTemplateIndexTests_IndexedSample(String variable) {
        super(ReactiveMongoTemplateIndexTests.IndexedSample.class, forVariable(variable));
    }

    public QReactiveMongoTemplateIndexTests_IndexedSample(Path<? extends ReactiveMongoTemplateIndexTests.IndexedSample> path) {
        super(path.getType(), path.getMetadata());
    }

    public QReactiveMongoTemplateIndexTests_IndexedSample(PathMetadata metadata) {
        super(ReactiveMongoTemplateIndexTests.IndexedSample.class, metadata);
    }

}

