package org.springframework.data.mongodb.core;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QDefaultReactiveIndexOperationsTests_DefaultIndexOperationsIntegrationTestsSample is a Querydsl query type for DefaultIndexOperationsIntegrationTestsSample
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QDefaultReactiveIndexOperationsTests_DefaultIndexOperationsIntegrationTestsSample extends EntityPathBase<DefaultReactiveIndexOperationsTests.DefaultIndexOperationsIntegrationTestsSample> {

    private static final long serialVersionUID = 261488155L;

    public static final QDefaultReactiveIndexOperationsTests_DefaultIndexOperationsIntegrationTestsSample defaultIndexOperationsIntegrationTestsSample = new QDefaultReactiveIndexOperationsTests_DefaultIndexOperationsIntegrationTestsSample("defaultIndexOperationsIntegrationTestsSample");

    public final NumberPath<Integer> quantity = createNumber("quantity", Integer.class);

    public QDefaultReactiveIndexOperationsTests_DefaultIndexOperationsIntegrationTestsSample(String variable) {
        super(DefaultReactiveIndexOperationsTests.DefaultIndexOperationsIntegrationTestsSample.class, forVariable(variable));
    }

    public QDefaultReactiveIndexOperationsTests_DefaultIndexOperationsIntegrationTestsSample(Path<? extends DefaultReactiveIndexOperationsTests.DefaultIndexOperationsIntegrationTestsSample> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDefaultReactiveIndexOperationsTests_DefaultIndexOperationsIntegrationTestsSample(PathMetadata metadata) {
        super(DefaultReactiveIndexOperationsTests.DefaultIndexOperationsIntegrationTestsSample.class, metadata);
    }

}

