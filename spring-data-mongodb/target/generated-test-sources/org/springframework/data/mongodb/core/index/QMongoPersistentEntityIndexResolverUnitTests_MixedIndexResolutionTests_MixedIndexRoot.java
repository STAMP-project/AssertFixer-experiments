package org.springframework.data.mongodb.core.index;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_MixedIndexRoot is a Querydsl query type for MixedIndexRoot
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_MixedIndexRoot extends EntityPathBase<MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.MixedIndexRoot> {

    private static final long serialVersionUID = 2010704982L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_MixedIndexRoot mixedIndexRoot = new QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_MixedIndexRoot("mixedIndexRoot");

    public final StringPath first = createString("first");

    public final QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_NestedGeoIndex nestedGeo;

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_MixedIndexRoot(String variable) {
        this(MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.MixedIndexRoot.class, forVariable(variable), INITS);
    }

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_MixedIndexRoot(Path<? extends MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.MixedIndexRoot> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_MixedIndexRoot(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_MixedIndexRoot(PathMetadata metadata, PathInits inits) {
        this(MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.MixedIndexRoot.class, metadata, inits);
    }

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_MixedIndexRoot(Class<? extends MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.MixedIndexRoot> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.nestedGeo = inits.isInitialized("nestedGeo") ? new QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_NestedGeoIndex(forProperty("nestedGeo"), inits.get("nestedGeo")) : null;
    }

}

