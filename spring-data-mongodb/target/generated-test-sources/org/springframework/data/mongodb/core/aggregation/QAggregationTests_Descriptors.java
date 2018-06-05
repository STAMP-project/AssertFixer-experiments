package org.springframework.data.mongodb.core.aggregation;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QAggregationTests_Descriptors is a Querydsl query type for Descriptors
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QAggregationTests_Descriptors extends BeanPath<AggregationTests.Descriptors> {

    private static final long serialVersionUID = -549060649L;

    public static final QAggregationTests_Descriptors descriptors = new QAggregationTests_Descriptors("descriptors");

    public final SimplePath<AggregationTests.CarDescriptor> carDescriptor = createSimple("carDescriptor", AggregationTests.CarDescriptor.class);

    public QAggregationTests_Descriptors(String variable) {
        super(AggregationTests.Descriptors.class, forVariable(variable));
    }

    public QAggregationTests_Descriptors(Path<? extends AggregationTests.Descriptors> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAggregationTests_Descriptors(PathMetadata metadata) {
        super(AggregationTests.Descriptors.class, metadata);
    }

}

