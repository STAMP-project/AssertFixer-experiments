package org.springframework.data.mongodb.core.mapping;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QDetectedCollectionWithIndex is a Querydsl query type for DetectedCollectionWithIndex
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QDetectedCollectionWithIndex extends EntityPathBase<DetectedCollectionWithIndex> {

    private static final long serialVersionUID = -398066346L;

    public static final QDetectedCollectionWithIndex detectedCollectionWithIndex = new QDetectedCollectionWithIndex("detectedCollectionWithIndex");

    public final StringPath id = createString("id");

    public final StringPath name = createString("name");

    public QDetectedCollectionWithIndex(String variable) {
        super(DetectedCollectionWithIndex.class, forVariable(variable));
    }

    public QDetectedCollectionWithIndex(Path<? extends DetectedCollectionWithIndex> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDetectedCollectionWithIndex(PathMetadata metadata) {
        super(DetectedCollectionWithIndex.class, metadata);
    }

}

