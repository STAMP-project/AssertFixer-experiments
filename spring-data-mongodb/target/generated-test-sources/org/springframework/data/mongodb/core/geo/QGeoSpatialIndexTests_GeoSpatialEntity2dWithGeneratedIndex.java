package org.springframework.data.mongodb.core.geo;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QGeoSpatialIndexTests_GeoSpatialEntity2dWithGeneratedIndex is a Querydsl query type for GeoSpatialEntity2dWithGeneratedIndex
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QGeoSpatialIndexTests_GeoSpatialEntity2dWithGeneratedIndex extends EntityPathBase<GeoSpatialIndexTests.GeoSpatialEntity2dWithGeneratedIndex> {

    private static final long serialVersionUID = -818655670L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QGeoSpatialIndexTests_GeoSpatialEntity2dWithGeneratedIndex geoSpatialEntity2dWithGeneratedIndex = new QGeoSpatialIndexTests_GeoSpatialEntity2dWithGeneratedIndex("geoSpatialEntity2dWithGeneratedIndex");

    public final StringPath id = createString("id");

    public final org.springframework.data.geo.QPoint location;

    public QGeoSpatialIndexTests_GeoSpatialEntity2dWithGeneratedIndex(String variable) {
        this(GeoSpatialIndexTests.GeoSpatialEntity2dWithGeneratedIndex.class, forVariable(variable), INITS);
    }

    public QGeoSpatialIndexTests_GeoSpatialEntity2dWithGeneratedIndex(Path<? extends GeoSpatialIndexTests.GeoSpatialEntity2dWithGeneratedIndex> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QGeoSpatialIndexTests_GeoSpatialEntity2dWithGeneratedIndex(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QGeoSpatialIndexTests_GeoSpatialEntity2dWithGeneratedIndex(PathMetadata metadata, PathInits inits) {
        this(GeoSpatialIndexTests.GeoSpatialEntity2dWithGeneratedIndex.class, metadata, inits);
    }

    public QGeoSpatialIndexTests_GeoSpatialEntity2dWithGeneratedIndex(Class<? extends GeoSpatialIndexTests.GeoSpatialEntity2dWithGeneratedIndex> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.location = inits.isInitialized("location") ? new org.springframework.data.geo.QPoint(forProperty("location")) : null;
    }

}

