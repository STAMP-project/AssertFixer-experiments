package org.springframework.data.mongodb.core.geo;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QGeoSpatialIndexTests_GeoSpatialEntity2DSphere is a Querydsl query type for GeoSpatialEntity2DSphere
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QGeoSpatialIndexTests_GeoSpatialEntity2DSphere extends EntityPathBase<GeoSpatialIndexTests.GeoSpatialEntity2DSphere> {

    private static final long serialVersionUID = -475681650L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QGeoSpatialIndexTests_GeoSpatialEntity2DSphere geoSpatialEntity2DSphere = new QGeoSpatialIndexTests_GeoSpatialEntity2DSphere("geoSpatialEntity2DSphere");

    public final StringPath id = createString("id");

    public final QGeoSpatialIndexTests_GeoJsonPoint location;

    public QGeoSpatialIndexTests_GeoSpatialEntity2DSphere(String variable) {
        this(GeoSpatialIndexTests.GeoSpatialEntity2DSphere.class, forVariable(variable), INITS);
    }

    public QGeoSpatialIndexTests_GeoSpatialEntity2DSphere(Path<? extends GeoSpatialIndexTests.GeoSpatialEntity2DSphere> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QGeoSpatialIndexTests_GeoSpatialEntity2DSphere(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QGeoSpatialIndexTests_GeoSpatialEntity2DSphere(PathMetadata metadata, PathInits inits) {
        this(GeoSpatialIndexTests.GeoSpatialEntity2DSphere.class, metadata, inits);
    }

    public QGeoSpatialIndexTests_GeoSpatialEntity2DSphere(Class<? extends GeoSpatialIndexTests.GeoSpatialEntity2DSphere> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.location = inits.isInitialized("location") ? new QGeoSpatialIndexTests_GeoJsonPoint(forProperty("location")) : null;
    }

}

