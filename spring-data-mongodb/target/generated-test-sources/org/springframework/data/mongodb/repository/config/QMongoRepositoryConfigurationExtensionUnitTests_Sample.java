package org.springframework.data.mongodb.repository.config;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMongoRepositoryConfigurationExtensionUnitTests_Sample is a Querydsl query type for Sample
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMongoRepositoryConfigurationExtensionUnitTests_Sample extends EntityPathBase<MongoRepositoryConfigurationExtensionUnitTests.Sample> {

    private static final long serialVersionUID = -1884870783L;

    public static final QMongoRepositoryConfigurationExtensionUnitTests_Sample sample = new QMongoRepositoryConfigurationExtensionUnitTests_Sample("sample");

    public QMongoRepositoryConfigurationExtensionUnitTests_Sample(String variable) {
        super(MongoRepositoryConfigurationExtensionUnitTests.Sample.class, forVariable(variable));
    }

    public QMongoRepositoryConfigurationExtensionUnitTests_Sample(Path<? extends MongoRepositoryConfigurationExtensionUnitTests.Sample> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMongoRepositoryConfigurationExtensionUnitTests_Sample(PathMetadata metadata) {
        super(MongoRepositoryConfigurationExtensionUnitTests.Sample.class, metadata);
    }

}

