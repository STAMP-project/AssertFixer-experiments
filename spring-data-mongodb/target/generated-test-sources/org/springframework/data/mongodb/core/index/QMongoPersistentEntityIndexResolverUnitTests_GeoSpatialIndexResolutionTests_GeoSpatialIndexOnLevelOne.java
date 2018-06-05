package org.springframework.data.mongodb.core.index;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMongoPersistentEntityIndexResolverUnitTests_GeoSpatialIndexResolutionTests_GeoSpatialIndexOnLevelOne is a Querydsl query type for GeoSpatialIndexOnLevelOne
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMongoPersistentEntityIndexResolverUnitTests_GeoSpatialIndexResolutionTests_GeoSpatialIndexOnLevelOne extends EntityPathBase<MongoPersistentEntityIndexResolverUnitTests.GeoSpatialIndexResolutionTests.GeoSpatialIndexOnLevelOne> {

    private static final long serialVersionUID = 375678165L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMongoPersistentEntityIndexResolverUnitTests_GeoSpatialIndexResolutionTests_GeoSpatialIndexOnLevelOne geoSpatialIndexOnLevelOne = new QMongoPersistentEntityIndexResolverUnitTests_GeoSpatialIndexResolutionTests_GeoSpatialIndexOnLevelOne("geoSpatialIndexOnLevelOne");

    public final QMongoPersistentEntityIndexResolverUnitTests_GeoSpatialIndexResolutionTests_GeoSpatialIndexOnLevelZero zero;

    public QMongoPersistentEntityIndexResolverUnitTests_GeoSpatialIndexResolutionTests_GeoSpatialIndexOnLevelOne(String variable) {
        this(MongoPersistentEntityIndexResolverUnitTests.GeoSpatialIndexResolutionTests.GeoSpatialIndexOnLevelOne.class, forVariable(variable), INITS);
    }

    public QMongoPersistentEntityIndexResolverUnitTests_GeoSpatialIndexResolutionTests_GeoSpatialIndexOnLevelOne(Path<? extends MongoPersistentEntityIndexResolverUnitTests.GeoSpatialIndexResolutionTests.GeoSpatialIndexOnLevelOne> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMongoPersistentEntityIndexResolverUnitTests_GeoSpatialIndexResolutionTests_GeoSpatialIndexOnLevelOne(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMongoPersistentEntityIndexResolverUnitTests_GeoSpatialIndexResolutionTests_GeoSpatialIndexOnLevelOne(PathMetadata metadata, PathInits inits) {
        this(MongoPersistentEntityIndexResolverUnitTests.GeoSpatialIndexResolutionTests.GeoSpatialIndexOnLevelOne.class, metadata, inits);
    }

    public QMongoPersistentEntityIndexResolverUnitTests_GeoSpatialIndexResolutionTests_GeoSpatialIndexOnLevelOne(Class<? extends MongoPersistentEntityIndexResolverUnitTests.GeoSpatialIndexResolutionTests.GeoSpatialIndexOnLevelOne> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.zero = inits.isInitialized("zero") ? new QMongoPersistentEntityIndexResolverUnitTests_GeoSpatialIndexResolutionTests_GeoSpatialIndexOnLevelZero(forProperty("zero"), inits.get("zero")) : null;
    }

}

