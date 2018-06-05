package org.springframework.data.mongodb.core.index;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_CycleLevelZero is a Querydsl query type for CycleLevelZero
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_CycleLevelZero extends EntityPathBase<MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.CycleLevelZero> {

    private static final long serialVersionUID = -1077641405L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_CycleLevelZero cycleLevelZero = new QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_CycleLevelZero("cycleLevelZero");

    public final QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_CycleLevelZero cyclicReference;

    public final StringPath indexedProperty = createString("indexedProperty");

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_CycleLevelZero(String variable) {
        this(MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.CycleLevelZero.class, forVariable(variable), INITS);
    }

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_CycleLevelZero(Path<? extends MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.CycleLevelZero> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_CycleLevelZero(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_CycleLevelZero(PathMetadata metadata, PathInits inits) {
        this(MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.CycleLevelZero.class, metadata, inits);
    }

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_CycleLevelZero(Class<? extends MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.CycleLevelZero> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.cyclicReference = inits.isInitialized("cyclicReference") ? new QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_CycleLevelZero(forProperty("cyclicReference"), inits.get("cyclicReference")) : null;
    }

}

