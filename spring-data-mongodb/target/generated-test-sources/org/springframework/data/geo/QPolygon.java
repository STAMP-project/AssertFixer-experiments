package org.springframework.data.geo;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPolygon is a Querydsl query type for Polygon
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QPolygon extends BeanPath<Polygon> {

    private static final long serialVersionUID = -1742572864L;

    public static final QPolygon polygon = new QPolygon("polygon");

    public final ListPath<Point, QPoint> points = this.<Point, QPoint>createList("points", Point.class, QPoint.class, PathInits.DIRECT2);

    public QPolygon(String variable) {
        super(Polygon.class, forVariable(variable));
    }

    public QPolygon(Path<? extends Polygon> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPolygon(PathMetadata metadata) {
        super(Polygon.class, metadata);
    }

}

