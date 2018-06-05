package org.springframework.data.mongodb.core.mapping;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCustomCollectionWithIndex is a Querydsl query type for CustomCollectionWithIndex
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCustomCollectionWithIndex extends EntityPathBase<CustomCollectionWithIndex> {

    private static final long serialVersionUID = 1642448519L;

    public static final QCustomCollectionWithIndex customCollectionWithIndex = new QCustomCollectionWithIndex("customCollectionWithIndex");

    public final StringPath id = createString("id");

    public final StringPath name = createString("name");

    public QCustomCollectionWithIndex(String variable) {
        super(CustomCollectionWithIndex.class, forVariable(variable));
    }

    public QCustomCollectionWithIndex(Path<? extends CustomCollectionWithIndex> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCustomCollectionWithIndex(PathMetadata metadata) {
        super(CustomCollectionWithIndex.class, metadata);
    }

}

