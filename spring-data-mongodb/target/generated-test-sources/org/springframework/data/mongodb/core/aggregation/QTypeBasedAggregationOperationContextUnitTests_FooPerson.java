package org.springframework.data.mongodb.core.aggregation;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTypeBasedAggregationOperationContextUnitTests_FooPerson is a Querydsl query type for FooPerson
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTypeBasedAggregationOperationContextUnitTests_FooPerson extends EntityPathBase<TypeBasedAggregationOperationContextUnitTests.FooPerson> {

    private static final long serialVersionUID = -996233257L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTypeBasedAggregationOperationContextUnitTests_FooPerson fooPerson = new QTypeBasedAggregationOperationContextUnitTests_FooPerson("fooPerson");

    public final QTypeBasedAggregationOperationContextUnitTests_Age age;

    public final org.bson.types.QObjectId id;

    public final StringPath lastName = createString("lastName");

    public final StringPath name = createString("name");

    public QTypeBasedAggregationOperationContextUnitTests_FooPerson(String variable) {
        this(TypeBasedAggregationOperationContextUnitTests.FooPerson.class, forVariable(variable), INITS);
    }

    public QTypeBasedAggregationOperationContextUnitTests_FooPerson(Path<? extends TypeBasedAggregationOperationContextUnitTests.FooPerson> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QTypeBasedAggregationOperationContextUnitTests_FooPerson(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QTypeBasedAggregationOperationContextUnitTests_FooPerson(PathMetadata metadata, PathInits inits) {
        this(TypeBasedAggregationOperationContextUnitTests.FooPerson.class, metadata, inits);
    }

    public QTypeBasedAggregationOperationContextUnitTests_FooPerson(Class<? extends TypeBasedAggregationOperationContextUnitTests.FooPerson> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.age = inits.isInitialized("age") ? new QTypeBasedAggregationOperationContextUnitTests_Age(forProperty("age")) : null;
        this.id = inits.isInitialized("id") ? new org.bson.types.QObjectId(forProperty("id")) : null;
    }

}

