package org.springframework.data.mongodb.core.index;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMongoPersistentEntityIndexResolverUnitTests_IndexResolutionTests_IndexOnLevelTwo is a Querydsl query type for IndexOnLevelTwo
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMongoPersistentEntityIndexResolverUnitTests_IndexResolutionTests_IndexOnLevelTwo extends EntityPathBase<MongoPersistentEntityIndexResolverUnitTests.IndexResolutionTests.IndexOnLevelTwo> {

    private static final long serialVersionUID = -18806501L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMongoPersistentEntityIndexResolverUnitTests_IndexResolutionTests_IndexOnLevelTwo indexOnLevelTwo = new QMongoPersistentEntityIndexResolverUnitTests_IndexResolutionTests_IndexOnLevelTwo("indexOnLevelTwo");

    public final QMongoPersistentEntityIndexResolverUnitTests_IndexResolutionTests_IndexOnLevelOne one;

    public QMongoPersistentEntityIndexResolverUnitTests_IndexResolutionTests_IndexOnLevelTwo(String variable) {
        this(MongoPersistentEntityIndexResolverUnitTests.IndexResolutionTests.IndexOnLevelTwo.class, forVariable(variable), INITS);
    }

    public QMongoPersistentEntityIndexResolverUnitTests_IndexResolutionTests_IndexOnLevelTwo(Path<? extends MongoPersistentEntityIndexResolverUnitTests.IndexResolutionTests.IndexOnLevelTwo> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMongoPersistentEntityIndexResolverUnitTests_IndexResolutionTests_IndexOnLevelTwo(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMongoPersistentEntityIndexResolverUnitTests_IndexResolutionTests_IndexOnLevelTwo(PathMetadata metadata, PathInits inits) {
        this(MongoPersistentEntityIndexResolverUnitTests.IndexResolutionTests.IndexOnLevelTwo.class, metadata, inits);
    }

    public QMongoPersistentEntityIndexResolverUnitTests_IndexResolutionTests_IndexOnLevelTwo(Class<? extends MongoPersistentEntityIndexResolverUnitTests.IndexResolutionTests.IndexOnLevelTwo> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.one = inits.isInitialized("one") ? new QMongoPersistentEntityIndexResolverUnitTests_IndexResolutionTests_IndexOnLevelOne(forProperty("one"), inits.get("one")) : null;
    }

}

