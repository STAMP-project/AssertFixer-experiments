package org.springframework.data.mongodb.core.index;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_NestedGeoIndex is a Querydsl query type for NestedGeoIndex
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_NestedGeoIndex extends BeanPath<MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.NestedGeoIndex> {

    private static final long serialVersionUID = 976821077L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_NestedGeoIndex nestedGeoIndex = new QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_NestedGeoIndex("nestedGeoIndex");

    public final org.springframework.data.geo.QPoint location;

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_NestedGeoIndex(String variable) {
        this(MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.NestedGeoIndex.class, forVariable(variable), INITS);
    }

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_NestedGeoIndex(Path<? extends MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.NestedGeoIndex> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_NestedGeoIndex(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_NestedGeoIndex(PathMetadata metadata, PathInits inits) {
        this(MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.NestedGeoIndex.class, metadata, inits);
    }

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_NestedGeoIndex(Class<? extends MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.NestedGeoIndex> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.location = inits.isInitialized("location") ? new org.springframework.data.geo.QPoint(forProperty("location")) : null;
    }

}

