package org.springframework.data.mongodb.core.geo;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QGeoJson is a Querydsl query type for GeoJson
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QGeoJson extends BeanPath<GeoJson<? extends Iterable<?>>> {

    private static final long serialVersionUID = 1844468198L;

    public static final QGeoJson geoJson = new QGeoJson("geoJson");

    public final SimplePath<Iterable<?>> coordinates = createSimple("coordinates", Iterable.class);

    public final StringPath type = createString("type");

    @SuppressWarnings({"all", "rawtypes", "unchecked"})
    public QGeoJson(String variable) {
        super((Class) GeoJson.class, forVariable(variable));
    }

    @SuppressWarnings({"all", "rawtypes", "unchecked"})
    public QGeoJson(Path<? extends GeoJson> path) {
        super((Class) path.getType(), path.getMetadata());
    }

    @SuppressWarnings({"all", "rawtypes", "unchecked"})
    public QGeoJson(PathMetadata metadata) {
        super((Class) GeoJson.class, metadata);
    }

}

