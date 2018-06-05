package org.springframework.data.mongodb.core.mapping;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QPrimitiveId is a Querydsl query type for PrimitiveId
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPrimitiveId extends EntityPathBase<PrimitiveId> {

    private static final long serialVersionUID = -1612061460L;

    public static final QPrimitiveId primitiveId = new QPrimitiveId("primitiveId");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath text = createString("text");

    public QPrimitiveId(String variable) {
        super(PrimitiveId.class, forVariable(variable));
    }

    public QPrimitiveId(Path<? extends PrimitiveId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPrimitiveId(PathMetadata metadata) {
        super(PrimitiveId.class, metadata);
    }

}

