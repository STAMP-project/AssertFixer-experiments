package org.springframework.data.mongodb.core.geo;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QGeoSpatialIndexTests_GeoSpatialEntity2D is a Querydsl query type for GeoSpatialEntity2D
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QGeoSpatialIndexTests_GeoSpatialEntity2D extends EntityPathBase<GeoSpatialIndexTests.GeoSpatialEntity2D> {

    private static final long serialVersionUID = 1752933729L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QGeoSpatialIndexTests_GeoSpatialEntity2D geoSpatialEntity2D = new QGeoSpatialIndexTests_GeoSpatialEntity2D("geoSpatialEntity2D");

    public final StringPath id = createString("id");

    public final org.springframework.data.geo.QPoint location;

    public QGeoSpatialIndexTests_GeoSpatialEntity2D(String variable) {
        this(GeoSpatialIndexTests.GeoSpatialEntity2D.class, forVariable(variable), INITS);
    }

    public QGeoSpatialIndexTests_GeoSpatialEntity2D(Path<? extends GeoSpatialIndexTests.GeoSpatialEntity2D> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QGeoSpatialIndexTests_GeoSpatialEntity2D(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QGeoSpatialIndexTests_GeoSpatialEntity2D(PathMetadata metadata, PathInits inits) {
        this(GeoSpatialIndexTests.GeoSpatialEntity2D.class, metadata, inits);
    }

    public QGeoSpatialIndexTests_GeoSpatialEntity2D(Class<? extends GeoSpatialIndexTests.GeoSpatialEntity2D> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.location = inits.isInitialized("location") ? new org.springframework.data.geo.QPoint(forProperty("location")) : null;
    }

}

