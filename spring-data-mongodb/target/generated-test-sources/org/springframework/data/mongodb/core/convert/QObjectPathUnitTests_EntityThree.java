package org.springframework.data.mongodb.core.convert;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QObjectPathUnitTests_EntityThree is a Querydsl query type for EntityThree
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QObjectPathUnitTests_EntityThree extends EntityPathBase<ObjectPathUnitTests.EntityThree> {

    private static final long serialVersionUID = 68703413L;

    public static final QObjectPathUnitTests_EntityThree entityThree = new QObjectPathUnitTests_EntityThree("entityThree");

    public QObjectPathUnitTests_EntityThree(String variable) {
        super(ObjectPathUnitTests.EntityThree.class, forVariable(variable));
    }

    public QObjectPathUnitTests_EntityThree(Path<? extends ObjectPathUnitTests.EntityThree> path) {
        super(path.getType(), path.getMetadata());
    }

    public QObjectPathUnitTests_EntityThree(PathMetadata metadata) {
        super(ObjectPathUnitTests.EntityThree.class, metadata);
    }

}

