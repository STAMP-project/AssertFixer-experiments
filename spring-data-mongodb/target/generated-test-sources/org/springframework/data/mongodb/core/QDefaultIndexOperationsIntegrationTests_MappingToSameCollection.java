package org.springframework.data.mongodb.core;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QDefaultIndexOperationsIntegrationTests_MappingToSameCollection is a Querydsl query type for MappingToSameCollection
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QDefaultIndexOperationsIntegrationTests_MappingToSameCollection extends EntityPathBase<DefaultIndexOperationsIntegrationTests.MappingToSameCollection> {

    private static final long serialVersionUID = -1524975969L;

    public static final QDefaultIndexOperationsIntegrationTests_MappingToSameCollection mappingToSameCollection = new QDefaultIndexOperationsIntegrationTests_MappingToSameCollection("mappingToSameCollection");

    public final QDefaultIndexOperationsIntegrationTests_DefaultIndexOperationsIntegrationTestsSample _super = new QDefaultIndexOperationsIntegrationTests_DefaultIndexOperationsIntegrationTestsSample(this);

    public final NumberPath<Integer> age = createNumber("age", Integer.class);

    //inherited
    public final NumberPath<Integer> quantity = _super.quantity;

    public QDefaultIndexOperationsIntegrationTests_MappingToSameCollection(String variable) {
        super(DefaultIndexOperationsIntegrationTests.MappingToSameCollection.class, forVariable(variable));
    }

    public QDefaultIndexOperationsIntegrationTests_MappingToSameCollection(Path<? extends DefaultIndexOperationsIntegrationTests.MappingToSameCollection> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDefaultIndexOperationsIntegrationTests_MappingToSameCollection(PathMetadata metadata) {
        super(DefaultIndexOperationsIntegrationTests.MappingToSameCollection.class, metadata);
    }

}

