package org.springframework.data.mongodb.core;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QVenue is a Querydsl query type for Venue
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QVenue extends EntityPathBase<Venue> {

    private static final long serialVersionUID = -1648771687L;

    public static final QVenue venue = new QVenue("venue");

    public final StringPath id = createString("id");

    public final ArrayPath<double[], Double> location = createArray("location", double[].class);

    public final StringPath name = createString("name");

    public final DatePath<org.joda.time.LocalDate> openingDate = createDate("openingDate", org.joda.time.LocalDate.class);

    public QVenue(String variable) {
        super(Venue.class, forVariable(variable));
    }

    public QVenue(Path<? extends Venue> path) {
        super(path.getType(), path.getMetadata());
    }

    public QVenue(PathMetadata metadata) {
        super(Venue.class, metadata);
    }

}

