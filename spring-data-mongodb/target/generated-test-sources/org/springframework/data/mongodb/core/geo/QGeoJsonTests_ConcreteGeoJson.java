package org.springframework.data.mongodb.core.geo;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QGeoJsonTests_ConcreteGeoJson is a Querydsl query type for ConcreteGeoJson
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QGeoJsonTests_ConcreteGeoJson extends EntityPathBase<GeoJsonTests.ConcreteGeoJson> {

    private static final long serialVersionUID = -486622879L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QGeoJsonTests_ConcreteGeoJson concreteGeoJson = new QGeoJsonTests_ConcreteGeoJson("concreteGeoJson");

    public final StringPath id = createString("id");

    public final QGeoJsonPolygon shape;

    public QGeoJsonTests_ConcreteGeoJson(String variable) {
        this(GeoJsonTests.ConcreteGeoJson.class, forVariable(variable), INITS);
    }

    public QGeoJsonTests_ConcreteGeoJson(Path<? extends GeoJsonTests.ConcreteGeoJson> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QGeoJsonTests_ConcreteGeoJson(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QGeoJsonTests_ConcreteGeoJson(PathMetadata metadata, PathInits inits) {
        this(GeoJsonTests.ConcreteGeoJson.class, metadata, inits);
    }

    public QGeoJsonTests_ConcreteGeoJson(Class<? extends GeoJsonTests.ConcreteGeoJson> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.shape = inits.isInitialized("shape") ? new QGeoJsonPolygon(forProperty("shape")) : null;
    }

}

