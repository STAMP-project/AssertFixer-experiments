package org.springframework.data.mongodb.core.index;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMongoPersistentEntityIndexResolverUnitTests_IndexResolutionTests_IndexOnLevelOne is a Querydsl query type for IndexOnLevelOne
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMongoPersistentEntityIndexResolverUnitTests_IndexResolutionTests_IndexOnLevelOne extends EntityPathBase<MongoPersistentEntityIndexResolverUnitTests.IndexResolutionTests.IndexOnLevelOne> {

    private static final long serialVersionUID = -18811595L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMongoPersistentEntityIndexResolverUnitTests_IndexResolutionTests_IndexOnLevelOne indexOnLevelOne = new QMongoPersistentEntityIndexResolverUnitTests_IndexResolutionTests_IndexOnLevelOne("indexOnLevelOne");

    public final QMongoPersistentEntityIndexResolverUnitTests_IndexResolutionTests_IndexOnLevelZero zero;

    public QMongoPersistentEntityIndexResolverUnitTests_IndexResolutionTests_IndexOnLevelOne(String variable) {
        this(MongoPersistentEntityIndexResolverUnitTests.IndexResolutionTests.IndexOnLevelOne.class, forVariable(variable), INITS);
    }

    public QMongoPersistentEntityIndexResolverUnitTests_IndexResolutionTests_IndexOnLevelOne(Path<? extends MongoPersistentEntityIndexResolverUnitTests.IndexResolutionTests.IndexOnLevelOne> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMongoPersistentEntityIndexResolverUnitTests_IndexResolutionTests_IndexOnLevelOne(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMongoPersistentEntityIndexResolverUnitTests_IndexResolutionTests_IndexOnLevelOne(PathMetadata metadata, PathInits inits) {
        this(MongoPersistentEntityIndexResolverUnitTests.IndexResolutionTests.IndexOnLevelOne.class, metadata, inits);
    }

    public QMongoPersistentEntityIndexResolverUnitTests_IndexResolutionTests_IndexOnLevelOne(Class<? extends MongoPersistentEntityIndexResolverUnitTests.IndexResolutionTests.IndexOnLevelOne> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.zero = inits.isInitialized("zero") ? new QMongoPersistentEntityIndexResolverUnitTests_IndexResolutionTests_IndexOnLevelZero(forProperty("zero")) : null;
    }

}

