package org.springframework.data.mongodb.core.aggregation;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QAggregationTests_InventoryItem is a Querydsl query type for InventoryItem
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAggregationTests_InventoryItem extends EntityPathBase<AggregationTests.InventoryItem> {

    private static final long serialVersionUID = -1466306878L;

    public static final QAggregationTests_InventoryItem inventoryItem = new QAggregationTests_InventoryItem("inventoryItem");

    public final StringPath description = createString("description");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath item = createString("item");

    public final NumberPath<Integer> qty = createNumber("qty", Integer.class);

    public QAggregationTests_InventoryItem(String variable) {
        super(AggregationTests.InventoryItem.class, forVariable(variable));
    }

    public QAggregationTests_InventoryItem(Path<? extends AggregationTests.InventoryItem> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAggregationTests_InventoryItem(PathMetadata metadata) {
        super(AggregationTests.InventoryItem.class, metadata);
    }

}

