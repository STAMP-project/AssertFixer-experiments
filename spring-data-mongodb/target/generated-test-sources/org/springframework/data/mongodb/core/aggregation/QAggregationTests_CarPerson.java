package org.springframework.data.mongodb.core.aggregation;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAggregationTests_CarPerson is a Querydsl query type for CarPerson
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAggregationTests_CarPerson extends EntityPathBase<AggregationTests.CarPerson> {

    private static final long serialVersionUID = 1481825788L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAggregationTests_CarPerson carPerson = new QAggregationTests_CarPerson("carPerson");

    public final QAggregationTests_Descriptors descriptors;

    public final StringPath firstName = createString("firstName");

    public final StringPath id = createString("id");

    public final StringPath lastName = createString("lastName");

    public QAggregationTests_CarPerson(String variable) {
        this(AggregationTests.CarPerson.class, forVariable(variable), INITS);
    }

    public QAggregationTests_CarPerson(Path<? extends AggregationTests.CarPerson> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAggregationTests_CarPerson(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAggregationTests_CarPerson(PathMetadata metadata, PathInits inits) {
        this(AggregationTests.CarPerson.class, metadata, inits);
    }

    public QAggregationTests_CarPerson(Class<? extends AggregationTests.CarPerson> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.descriptors = inits.isInitialized("descriptors") ? new QAggregationTests_Descriptors(forProperty("descriptors")) : null;
    }

}

