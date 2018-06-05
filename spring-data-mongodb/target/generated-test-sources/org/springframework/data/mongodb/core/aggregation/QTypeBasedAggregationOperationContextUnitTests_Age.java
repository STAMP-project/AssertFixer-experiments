package org.springframework.data.mongodb.core.aggregation;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QTypeBasedAggregationOperationContextUnitTests_Age is a Querydsl query type for Age
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QTypeBasedAggregationOperationContextUnitTests_Age extends BeanPath<TypeBasedAggregationOperationContextUnitTests.Age> {

    private static final long serialVersionUID = -1699969509L;

    public static final QTypeBasedAggregationOperationContextUnitTests_Age age = new QTypeBasedAggregationOperationContextUnitTests_Age("age");

    public final NumberPath<Integer> value = createNumber("value", Integer.class);

    public QTypeBasedAggregationOperationContextUnitTests_Age(String variable) {
        super(TypeBasedAggregationOperationContextUnitTests.Age.class, forVariable(variable));
    }

    public QTypeBasedAggregationOperationContextUnitTests_Age(Path<? extends TypeBasedAggregationOperationContextUnitTests.Age> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTypeBasedAggregationOperationContextUnitTests_Age(PathMetadata metadata) {
        super(TypeBasedAggregationOperationContextUnitTests.Age.class, metadata);
    }

}

