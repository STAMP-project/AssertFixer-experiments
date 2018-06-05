package org.springframework.data.mongodb.core;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QDefaultReactiveIndexOperationsTests_MappingToSameCollection is a Querydsl query type for MappingToSameCollection
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QDefaultReactiveIndexOperationsTests_MappingToSameCollection extends EntityPathBase<DefaultReactiveIndexOperationsTests.MappingToSameCollection> {

    private static final long serialVersionUID = 422439526L;

    public static final QDefaultReactiveIndexOperationsTests_MappingToSameCollection mappingToSameCollection = new QDefaultReactiveIndexOperationsTests_MappingToSameCollection("mappingToSameCollection");

    public final QDefaultIndexOperationsIntegrationTests_DefaultIndexOperationsIntegrationTestsSample _super = new QDefaultIndexOperationsIntegrationTests_DefaultIndexOperationsIntegrationTestsSample(this);

    public final NumberPath<Integer> age = createNumber("age", Integer.class);

    //inherited
    public final NumberPath<Integer> quantity = _super.quantity;

    public QDefaultReactiveIndexOperationsTests_MappingToSameCollection(String variable) {
        super(DefaultReactiveIndexOperationsTests.MappingToSameCollection.class, forVariable(variable));
    }

    public QDefaultReactiveIndexOperationsTests_MappingToSameCollection(Path<? extends DefaultReactiveIndexOperationsTests.MappingToSameCollection> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDefaultReactiveIndexOperationsTests_MappingToSameCollection(PathMetadata metadata) {
        super(DefaultReactiveIndexOperationsTests.MappingToSameCollection.class, metadata);
    }

}

