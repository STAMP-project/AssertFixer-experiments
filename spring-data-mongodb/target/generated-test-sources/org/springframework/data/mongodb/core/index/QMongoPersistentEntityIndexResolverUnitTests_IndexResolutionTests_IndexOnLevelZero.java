package org.springframework.data.mongodb.core.index;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMongoPersistentEntityIndexResolverUnitTests_IndexResolutionTests_IndexOnLevelZero is a Querydsl query type for IndexOnLevelZero
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMongoPersistentEntityIndexResolverUnitTests_IndexResolutionTests_IndexOnLevelZero extends EntityPathBase<MongoPersistentEntityIndexResolverUnitTests.IndexResolutionTests.IndexOnLevelZero> {

    private static final long serialVersionUID = -582839879L;

    public static final QMongoPersistentEntityIndexResolverUnitTests_IndexResolutionTests_IndexOnLevelZero indexOnLevelZero = new QMongoPersistentEntityIndexResolverUnitTests_IndexResolutionTests_IndexOnLevelZero("indexOnLevelZero");

    public final StringPath indexedProperty = createString("indexedProperty");

    public QMongoPersistentEntityIndexResolverUnitTests_IndexResolutionTests_IndexOnLevelZero(String variable) {
        super(MongoPersistentEntityIndexResolverUnitTests.IndexResolutionTests.IndexOnLevelZero.class, forVariable(variable));
    }

    public QMongoPersistentEntityIndexResolverUnitTests_IndexResolutionTests_IndexOnLevelZero(Path<? extends MongoPersistentEntityIndexResolverUnitTests.IndexResolutionTests.IndexOnLevelZero> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMongoPersistentEntityIndexResolverUnitTests_IndexResolutionTests_IndexOnLevelZero(PathMetadata metadata) {
        super(MongoPersistentEntityIndexResolverUnitTests.IndexResolutionTests.IndexOnLevelZero.class, metadata);
    }

}

