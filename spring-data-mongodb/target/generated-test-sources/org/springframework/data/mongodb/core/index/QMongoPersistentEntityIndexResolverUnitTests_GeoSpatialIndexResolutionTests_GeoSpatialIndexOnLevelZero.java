package org.springframework.data.mongodb.core.index;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMongoPersistentEntityIndexResolverUnitTests_GeoSpatialIndexResolutionTests_GeoSpatialIndexOnLevelZero is a Querydsl query type for GeoSpatialIndexOnLevelZero
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMongoPersistentEntityIndexResolverUnitTests_GeoSpatialIndexResolutionTests_GeoSpatialIndexOnLevelZero extends EntityPathBase<MongoPersistentEntityIndexResolverUnitTests.GeoSpatialIndexResolutionTests.GeoSpatialIndexOnLevelZero> {

    private static final long serialVersionUID = -1238559207L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMongoPersistentEntityIndexResolverUnitTests_GeoSpatialIndexResolutionTests_GeoSpatialIndexOnLevelZero geoSpatialIndexOnLevelZero = new QMongoPersistentEntityIndexResolverUnitTests_GeoSpatialIndexResolutionTests_GeoSpatialIndexOnLevelZero("geoSpatialIndexOnLevelZero");

    public final org.springframework.data.geo.QPoint geoIndexedProperty;

    public QMongoPersistentEntityIndexResolverUnitTests_GeoSpatialIndexResolutionTests_GeoSpatialIndexOnLevelZero(String variable) {
        this(MongoPersistentEntityIndexResolverUnitTests.GeoSpatialIndexResolutionTests.GeoSpatialIndexOnLevelZero.class, forVariable(variable), INITS);
    }

    public QMongoPersistentEntityIndexResolverUnitTests_GeoSpatialIndexResolutionTests_GeoSpatialIndexOnLevelZero(Path<? extends MongoPersistentEntityIndexResolverUnitTests.GeoSpatialIndexResolutionTests.GeoSpatialIndexOnLevelZero> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMongoPersistentEntityIndexResolverUnitTests_GeoSpatialIndexResolutionTests_GeoSpatialIndexOnLevelZero(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMongoPersistentEntityIndexResolverUnitTests_GeoSpatialIndexResolutionTests_GeoSpatialIndexOnLevelZero(PathMetadata metadata, PathInits inits) {
        this(MongoPersistentEntityIndexResolverUnitTests.GeoSpatialIndexResolutionTests.GeoSpatialIndexOnLevelZero.class, metadata, inits);
    }

    public QMongoPersistentEntityIndexResolverUnitTests_GeoSpatialIndexResolutionTests_GeoSpatialIndexOnLevelZero(Class<? extends MongoPersistentEntityIndexResolverUnitTests.GeoSpatialIndexResolutionTests.GeoSpatialIndexOnLevelZero> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.geoIndexedProperty = inits.isInitialized("geoIndexedProperty") ? new org.springframework.data.geo.QPoint(forProperty("geoIndexedProperty")) : null;
    }

}

