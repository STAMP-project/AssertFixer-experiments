package org.springframework.data.mongodb.core;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMongoTemplateDbRefTests_RefCycleLoadingIntoDifferentTypeRoot is a Querydsl query type for RefCycleLoadingIntoDifferentTypeRoot
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMongoTemplateDbRefTests_RefCycleLoadingIntoDifferentTypeRoot extends EntityPathBase<MongoTemplateDbRefTests.RefCycleLoadingIntoDifferentTypeRoot> {

    private static final long serialVersionUID = -1179805450L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMongoTemplateDbRefTests_RefCycleLoadingIntoDifferentTypeRoot refCycleLoadingIntoDifferentTypeRoot = new QMongoTemplateDbRefTests_RefCycleLoadingIntoDifferentTypeRoot("refCycleLoadingIntoDifferentTypeRoot");

    public final StringPath content = createString("content");

    public final StringPath id = createString("id");

    public final QMongoTemplateDbRefTests_RefCycleLoadingIntoDifferentTypeIntermediate refToIntermediate;

    public QMongoTemplateDbRefTests_RefCycleLoadingIntoDifferentTypeRoot(String variable) {
        this(MongoTemplateDbRefTests.RefCycleLoadingIntoDifferentTypeRoot.class, forVariable(variable), INITS);
    }

    public QMongoTemplateDbRefTests_RefCycleLoadingIntoDifferentTypeRoot(Path<? extends MongoTemplateDbRefTests.RefCycleLoadingIntoDifferentTypeRoot> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMongoTemplateDbRefTests_RefCycleLoadingIntoDifferentTypeRoot(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMongoTemplateDbRefTests_RefCycleLoadingIntoDifferentTypeRoot(PathMetadata metadata, PathInits inits) {
        this(MongoTemplateDbRefTests.RefCycleLoadingIntoDifferentTypeRoot.class, metadata, inits);
    }

    public QMongoTemplateDbRefTests_RefCycleLoadingIntoDifferentTypeRoot(Class<? extends MongoTemplateDbRefTests.RefCycleLoadingIntoDifferentTypeRoot> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.refToIntermediate = inits.isInitialized("refToIntermediate") ? new QMongoTemplateDbRefTests_RefCycleLoadingIntoDifferentTypeIntermediate(forProperty("refToIntermediate"), inits.get("refToIntermediate")) : null;
    }

}

