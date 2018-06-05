package org.springframework.data.mongodb.core.convert;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QObjectPathUnitTests_EntityOne is a Querydsl query type for EntityOne
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QObjectPathUnitTests_EntityOne extends EntityPathBase<ObjectPathUnitTests.EntityOne> {

    private static final long serialVersionUID = 4536125L;

    public static final QObjectPathUnitTests_EntityOne entityOne = new QObjectPathUnitTests_EntityOne("entityOne");

    public QObjectPathUnitTests_EntityOne(String variable) {
        super(ObjectPathUnitTests.EntityOne.class, forVariable(variable));
    }

    public QObjectPathUnitTests_EntityOne(Path<? extends ObjectPathUnitTests.EntityOne> path) {
        super(path.getType(), path.getMetadata());
    }

    public QObjectPathUnitTests_EntityOne(PathMetadata metadata) {
        super(ObjectPathUnitTests.EntityOne.class, metadata);
    }

}

