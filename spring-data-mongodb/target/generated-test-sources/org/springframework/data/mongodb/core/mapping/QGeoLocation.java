package org.springframework.data.mongodb.core.mapping;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QGeoLocation is a Querydsl query type for GeoLocation
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QGeoLocation extends EntityPathBase<GeoLocation> {

    private static final long serialVersionUID = 833232560L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QGeoLocation geoLocation = new QGeoLocation("geoLocation");

    public final org.bson.types.QObjectId id;

    public final ArrayPath<double[], Double> location = createArray("location", double[].class);

    public QGeoLocation(String variable) {
        this(GeoLocation.class, forVariable(variable), INITS);
    }

    public QGeoLocation(Path<? extends GeoLocation> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QGeoLocation(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QGeoLocation(PathMetadata metadata, PathInits inits) {
        this(GeoLocation.class, metadata, inits);
    }

    public QGeoLocation(Class<? extends GeoLocation> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.id = inits.isInitialized("id") ? new org.bson.types.QObjectId(forProperty("id")) : null;
    }

}

