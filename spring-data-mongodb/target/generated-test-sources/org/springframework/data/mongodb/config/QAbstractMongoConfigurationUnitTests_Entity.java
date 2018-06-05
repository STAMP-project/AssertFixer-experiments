package org.springframework.data.mongodb.config;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QAbstractMongoConfigurationUnitTests_Entity is a Querydsl query type for Entity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAbstractMongoConfigurationUnitTests_Entity extends EntityPathBase<AbstractMongoConfigurationUnitTests.Entity> {

    private static final long serialVersionUID = -418350549L;

    public static final QAbstractMongoConfigurationUnitTests_Entity entity = new QAbstractMongoConfigurationUnitTests_Entity("entity");

    public QAbstractMongoConfigurationUnitTests_Entity(String variable) {
        super(AbstractMongoConfigurationUnitTests.Entity.class, forVariable(variable));
    }

    public QAbstractMongoConfigurationUnitTests_Entity(Path<? extends AbstractMongoConfigurationUnitTests.Entity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAbstractMongoConfigurationUnitTests_Entity(PathMetadata metadata) {
        super(AbstractMongoConfigurationUnitTests.Entity.class, metadata);
    }

}

