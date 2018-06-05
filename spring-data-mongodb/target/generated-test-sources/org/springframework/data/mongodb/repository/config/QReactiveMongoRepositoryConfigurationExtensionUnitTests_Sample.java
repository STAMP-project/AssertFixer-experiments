package org.springframework.data.mongodb.repository.config;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QReactiveMongoRepositoryConfigurationExtensionUnitTests_Sample is a Querydsl query type for Sample
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QReactiveMongoRepositoryConfigurationExtensionUnitTests_Sample extends EntityPathBase<ReactiveMongoRepositoryConfigurationExtensionUnitTests.Sample> {

    private static final long serialVersionUID = -296257784L;

    public static final QReactiveMongoRepositoryConfigurationExtensionUnitTests_Sample sample = new QReactiveMongoRepositoryConfigurationExtensionUnitTests_Sample("sample");

    public QReactiveMongoRepositoryConfigurationExtensionUnitTests_Sample(String variable) {
        super(ReactiveMongoRepositoryConfigurationExtensionUnitTests.Sample.class, forVariable(variable));
    }

    public QReactiveMongoRepositoryConfigurationExtensionUnitTests_Sample(Path<? extends ReactiveMongoRepositoryConfigurationExtensionUnitTests.Sample> path) {
        super(path.getType(), path.getMetadata());
    }

    public QReactiveMongoRepositoryConfigurationExtensionUnitTests_Sample(PathMetadata metadata) {
        super(ReactiveMongoRepositoryConfigurationExtensionUnitTests.Sample.class, metadata);
    }

}

