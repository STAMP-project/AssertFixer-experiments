package org.springframework.data.mongodb.core.index;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMongoPersistentEntityIndexResolverUnitTests_GeoSpatialIndexResolutionTests_WithOptionsOnGeoSpatialIndexProperty is a Querydsl query type for WithOptionsOnGeoSpatialIndexProperty
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMongoPersistentEntityIndexResolverUnitTests_GeoSpatialIndexResolutionTests_WithOptionsOnGeoSpatialIndexProperty extends EntityPathBase<MongoPersistentEntityIndexResolverUnitTests.GeoSpatialIndexResolutionTests.WithOptionsOnGeoSpatialIndexProperty> {

    private static final long serialVersionUID = -293305624L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMongoPersistentEntityIndexResolverUnitTests_GeoSpatialIndexResolutionTests_WithOptionsOnGeoSpatialIndexProperty withOptionsOnGeoSpatialIndexProperty = new QMongoPersistentEntityIndexResolverUnitTests_GeoSpatialIndexResolutionTests_WithOptionsOnGeoSpatialIndexProperty("withOptionsOnGeoSpatialIndexProperty");

    public final org.springframework.data.geo.QPoint location;

    public QMongoPersistentEntityIndexResolverUnitTests_GeoSpatialIndexResolutionTests_WithOptionsOnGeoSpatialIndexProperty(String variable) {
        this(MongoPersistentEntityIndexResolverUnitTests.GeoSpatialIndexResolutionTests.WithOptionsOnGeoSpatialIndexProperty.class, forVariable(variable), INITS);
    }

    public QMongoPersistentEntityIndexResolverUnitTests_GeoSpatialIndexResolutionTests_WithOptionsOnGeoSpatialIndexProperty(Path<? extends MongoPersistentEntityIndexResolverUnitTests.GeoSpatialIndexResolutionTests.WithOptionsOnGeoSpatialIndexProperty> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMongoPersistentEntityIndexResolverUnitTests_GeoSpatialIndexResolutionTests_WithOptionsOnGeoSpatialIndexProperty(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMongoPersistentEntityIndexResolverUnitTests_GeoSpatialIndexResolutionTests_WithOptionsOnGeoSpatialIndexProperty(PathMetadata metadata, PathInits inits) {
        this(MongoPersistentEntityIndexResolverUnitTests.GeoSpatialIndexResolutionTests.WithOptionsOnGeoSpatialIndexProperty.class, metadata, inits);
    }

    public QMongoPersistentEntityIndexResolverUnitTests_GeoSpatialIndexResolutionTests_WithOptionsOnGeoSpatialIndexProperty(Class<? extends MongoPersistentEntityIndexResolverUnitTests.GeoSpatialIndexResolutionTests.WithOptionsOnGeoSpatialIndexProperty> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.location = inits.isInitialized("location") ? new org.springframework.data.geo.QPoint(forProperty("location")) : null;
    }

}

