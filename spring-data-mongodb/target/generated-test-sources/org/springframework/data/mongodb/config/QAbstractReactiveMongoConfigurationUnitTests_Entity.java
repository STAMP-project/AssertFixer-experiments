package org.springframework.data.mongodb.config;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QAbstractReactiveMongoConfigurationUnitTests_Entity is a Querydsl query type for Entity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAbstractReactiveMongoConfigurationUnitTests_Entity extends EntityPathBase<AbstractReactiveMongoConfigurationUnitTests.Entity> {

    private static final long serialVersionUID = -202215932L;

    public static final QAbstractReactiveMongoConfigurationUnitTests_Entity entity = new QAbstractReactiveMongoConfigurationUnitTests_Entity("entity");

    public QAbstractReactiveMongoConfigurationUnitTests_Entity(String variable) {
        super(AbstractReactiveMongoConfigurationUnitTests.Entity.class, forVariable(variable));
    }

    public QAbstractReactiveMongoConfigurationUnitTests_Entity(Path<? extends AbstractReactiveMongoConfigurationUnitTests.Entity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAbstractReactiveMongoConfigurationUnitTests_Entity(PathMetadata metadata) {
        super(AbstractReactiveMongoConfigurationUnitTests.Entity.class, metadata);
    }

}

