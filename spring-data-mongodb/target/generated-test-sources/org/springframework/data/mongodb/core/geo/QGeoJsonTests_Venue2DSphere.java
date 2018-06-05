package org.springframework.data.mongodb.core.geo;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QGeoJsonTests_Venue2DSphere is a Querydsl query type for Venue2DSphere
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QGeoJsonTests_Venue2DSphere extends EntityPathBase<GeoJsonTests.Venue2DSphere> {

    private static final long serialVersionUID = 1834332987L;

    public static final QGeoJsonTests_Venue2DSphere venue2DSphere = new QGeoJsonTests_Venue2DSphere("venue2DSphere");

    public final StringPath id = createString("id");

    public final ArrayPath<double[], Double> location = createArray("location", double[].class);

    public final StringPath name = createString("name");

    public QGeoJsonTests_Venue2DSphere(String variable) {
        super(GeoJsonTests.Venue2DSphere.class, forVariable(variable));
    }

    public QGeoJsonTests_Venue2DSphere(Path<? extends GeoJsonTests.Venue2DSphere> path) {
        super(path.getType(), path.getMetadata());
    }

    public QGeoJsonTests_Venue2DSphere(PathMetadata metadata) {
        super(GeoJsonTests.Venue2DSphere.class, metadata);
    }

}

