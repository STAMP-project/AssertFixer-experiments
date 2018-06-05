package org.springframework.data.mongodb.core;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QDefaultIndexOperationsIntegrationTests_DefaultIndexOperationsIntegrationTestsSample is a Querydsl query type for DefaultIndexOperationsIntegrationTestsSample
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QDefaultIndexOperationsIntegrationTests_DefaultIndexOperationsIntegrationTestsSample extends EntityPathBase<DefaultIndexOperationsIntegrationTests.DefaultIndexOperationsIntegrationTestsSample> {

    private static final long serialVersionUID = -207143038L;

    public static final QDefaultIndexOperationsIntegrationTests_DefaultIndexOperationsIntegrationTestsSample defaultIndexOperationsIntegrationTestsSample = new QDefaultIndexOperationsIntegrationTests_DefaultIndexOperationsIntegrationTestsSample("defaultIndexOperationsIntegrationTestsSample");

    public final NumberPath<Integer> quantity = createNumber("quantity", Integer.class);

    public QDefaultIndexOperationsIntegrationTests_DefaultIndexOperationsIntegrationTestsSample(String variable) {
        super(DefaultIndexOperationsIntegrationTests.DefaultIndexOperationsIntegrationTestsSample.class, forVariable(variable));
    }

    public QDefaultIndexOperationsIntegrationTests_DefaultIndexOperationsIntegrationTestsSample(Path<? extends DefaultIndexOperationsIntegrationTests.DefaultIndexOperationsIntegrationTestsSample> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDefaultIndexOperationsIntegrationTests_DefaultIndexOperationsIntegrationTestsSample(PathMetadata metadata) {
        super(DefaultIndexOperationsIntegrationTests.DefaultIndexOperationsIntegrationTestsSample.class, metadata);
    }

}

