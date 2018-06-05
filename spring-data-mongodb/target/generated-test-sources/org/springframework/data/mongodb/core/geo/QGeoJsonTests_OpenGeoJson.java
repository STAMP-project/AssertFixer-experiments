package org.springframework.data.mongodb.core.geo;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QGeoJsonTests_OpenGeoJson is a Querydsl query type for OpenGeoJson
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QGeoJsonTests_OpenGeoJson extends EntityPathBase<GeoJsonTests.OpenGeoJson> {

    private static final long serialVersionUID = -2000143236L;

    public static final QGeoJsonTests_OpenGeoJson openGeoJson = new QGeoJsonTests_OpenGeoJson("openGeoJson");

    public final StringPath id = createString("id");

    // custom
    public final QGeoJson shape = new QGeoJson(forProperty("shape"));

    public QGeoJsonTests_OpenGeoJson(String variable) {
        super(GeoJsonTests.OpenGeoJson.class, forVariable(variable));
    }

    public QGeoJsonTests_OpenGeoJson(Path<? extends GeoJsonTests.OpenGeoJson> path) {
        super(path.getType(), path.getMetadata());
    }

    public QGeoJsonTests_OpenGeoJson(PathMetadata metadata) {
        super(GeoJsonTests.OpenGeoJson.class, metadata);
    }

}

