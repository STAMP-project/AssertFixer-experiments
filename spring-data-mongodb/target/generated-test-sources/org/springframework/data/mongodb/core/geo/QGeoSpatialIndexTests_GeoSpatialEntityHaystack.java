package org.springframework.data.mongodb.core.geo;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QGeoSpatialIndexTests_GeoSpatialEntityHaystack is a Querydsl query type for GeoSpatialEntityHaystack
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QGeoSpatialIndexTests_GeoSpatialEntityHaystack extends EntityPathBase<GeoSpatialIndexTests.GeoSpatialEntityHaystack> {

    private static final long serialVersionUID = 270274519L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QGeoSpatialIndexTests_GeoSpatialEntityHaystack geoSpatialEntityHaystack = new QGeoSpatialIndexTests_GeoSpatialEntityHaystack("geoSpatialEntityHaystack");

    public final StringPath id = createString("id");

    public final org.springframework.data.geo.QPoint location;

    public final StringPath name = createString("name");

    public QGeoSpatialIndexTests_GeoSpatialEntityHaystack(String variable) {
        this(GeoSpatialIndexTests.GeoSpatialEntityHaystack.class, forVariable(variable), INITS);
    }

    public QGeoSpatialIndexTests_GeoSpatialEntityHaystack(Path<? extends GeoSpatialIndexTests.GeoSpatialEntityHaystack> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QGeoSpatialIndexTests_GeoSpatialEntityHaystack(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QGeoSpatialIndexTests_GeoSpatialEntityHaystack(PathMetadata metadata, PathInits inits) {
        this(GeoSpatialIndexTests.GeoSpatialEntityHaystack.class, metadata, inits);
    }

    public QGeoSpatialIndexTests_GeoSpatialEntityHaystack(Class<? extends GeoSpatialIndexTests.GeoSpatialEntityHaystack> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.location = inits.isInitialized("location") ? new org.springframework.data.geo.QPoint(forProperty("location")) : null;
    }

}

