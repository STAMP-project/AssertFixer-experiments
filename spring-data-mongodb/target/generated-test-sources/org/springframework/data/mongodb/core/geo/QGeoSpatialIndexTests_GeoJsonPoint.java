package org.springframework.data.mongodb.core.geo;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QGeoSpatialIndexTests_GeoJsonPoint is a Querydsl query type for GeoJsonPoint
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QGeoSpatialIndexTests_GeoJsonPoint extends BeanPath<GeoSpatialIndexTests.GeoJsonPoint> {

    private static final long serialVersionUID = -825595312L;

    public static final QGeoSpatialIndexTests_GeoJsonPoint geoJsonPoint = new QGeoSpatialIndexTests_GeoJsonPoint("geoJsonPoint");

    public final ArrayPath<double[], Double> coordinates = createArray("coordinates", double[].class);

    public final StringPath type = createString("type");

    public QGeoSpatialIndexTests_GeoJsonPoint(String variable) {
        super(GeoSpatialIndexTests.GeoJsonPoint.class, forVariable(variable));
    }

    public QGeoSpatialIndexTests_GeoJsonPoint(Path<? extends GeoSpatialIndexTests.GeoJsonPoint> path) {
        super(path.getType(), path.getMetadata());
    }

    public QGeoSpatialIndexTests_GeoJsonPoint(PathMetadata metadata) {
        super(GeoSpatialIndexTests.GeoJsonPoint.class, metadata);
    }

}

