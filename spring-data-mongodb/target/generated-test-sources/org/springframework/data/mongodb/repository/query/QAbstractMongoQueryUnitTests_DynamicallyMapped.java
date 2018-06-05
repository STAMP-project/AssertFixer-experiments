package org.springframework.data.mongodb.repository.query;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QAbstractMongoQueryUnitTests_DynamicallyMapped is a Querydsl query type for DynamicallyMapped
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAbstractMongoQueryUnitTests_DynamicallyMapped extends EntityPathBase<AbstractMongoQueryUnitTests.DynamicallyMapped> {

    private static final long serialVersionUID = 987833490L;

    public static final QAbstractMongoQueryUnitTests_DynamicallyMapped dynamicallyMapped = new QAbstractMongoQueryUnitTests_DynamicallyMapped("dynamicallyMapped");

    public QAbstractMongoQueryUnitTests_DynamicallyMapped(String variable) {
        super(AbstractMongoQueryUnitTests.DynamicallyMapped.class, forVariable(variable));
    }

    public QAbstractMongoQueryUnitTests_DynamicallyMapped(Path<? extends AbstractMongoQueryUnitTests.DynamicallyMapped> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAbstractMongoQueryUnitTests_DynamicallyMapped(PathMetadata metadata) {
        super(AbstractMongoQueryUnitTests.DynamicallyMapped.class, metadata);
    }

}

