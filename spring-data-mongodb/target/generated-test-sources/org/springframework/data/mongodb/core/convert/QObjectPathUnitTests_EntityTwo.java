package org.springframework.data.mongodb.core.convert;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QObjectPathUnitTests_EntityTwo is a Querydsl query type for EntityTwo
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QObjectPathUnitTests_EntityTwo extends EntityPathBase<ObjectPathUnitTests.EntityTwo> {

    private static final long serialVersionUID = 4541219L;

    public static final QObjectPathUnitTests_EntityTwo entityTwo = new QObjectPathUnitTests_EntityTwo("entityTwo");

    public final QObjectPathUnitTests_EntityOne _super = new QObjectPathUnitTests_EntityOne(this);

    public QObjectPathUnitTests_EntityTwo(String variable) {
        super(ObjectPathUnitTests.EntityTwo.class, forVariable(variable));
    }

    public QObjectPathUnitTests_EntityTwo(Path<? extends ObjectPathUnitTests.EntityTwo> path) {
        super(path.getType(), path.getMetadata());
    }

    public QObjectPathUnitTests_EntityTwo(PathMetadata metadata) {
        super(ObjectPathUnitTests.EntityTwo.class, metadata);
    }

}

