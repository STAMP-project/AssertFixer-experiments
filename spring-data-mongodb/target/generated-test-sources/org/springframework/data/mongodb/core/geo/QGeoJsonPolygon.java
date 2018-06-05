package org.springframework.data.mongodb.core.geo;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QGeoJsonPolygon is a Querydsl query type for GeoJsonPolygon
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QGeoJsonPolygon extends BeanPath<GeoJsonPolygon> {

    private static final long serialVersionUID = -327236492L;

    public static final QGeoJsonPolygon geoJsonPolygon = new QGeoJsonPolygon("geoJsonPolygon");

    public final org.springframework.data.geo.QPolygon _super = new org.springframework.data.geo.QPolygon(this);

    public final ListPath<GeoJsonLineString, SimplePath<GeoJsonLineString>> coordinates = this.<GeoJsonLineString, SimplePath<GeoJsonLineString>>createList("coordinates", GeoJsonLineString.class, SimplePath.class, PathInits.DIRECT2);

    //inherited
    public final ListPath<org.springframework.data.geo.Point, org.springframework.data.geo.QPoint> points = _super.points;

    public final StringPath type = createString("type");

    public QGeoJsonPolygon(String variable) {
        super(GeoJsonPolygon.class, forVariable(variable));
    }

    public QGeoJsonPolygon(Path<? extends GeoJsonPolygon> path) {
        super(path.getType(), path.getMetadata());
    }

    public QGeoJsonPolygon(PathMetadata metadata) {
        super(GeoJsonPolygon.class, metadata);
    }

}

