package org.springframework.data.mongodb.core.mapping;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QGeneratedId is a Querydsl query type for GeneratedId
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QGeneratedId extends EntityPathBase<GeneratedId> {

    private static final long serialVersionUID = 1588651924L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QGeneratedId generatedId = new QGeneratedId("generatedId");

    public final org.bson.types.QObjectId id;

    public final StringPath name = createString("name");

    public QGeneratedId(String variable) {
        this(GeneratedId.class, forVariable(variable), INITS);
    }

    public QGeneratedId(Path<? extends GeneratedId> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QGeneratedId(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QGeneratedId(PathMetadata metadata, PathInits inits) {
        this(GeneratedId.class, metadata, inits);
    }

    public QGeneratedId(Class<? extends GeneratedId> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.id = inits.isInitialized("id") ? new org.bson.types.QObjectId(forProperty("id")) : null;
    }

}

