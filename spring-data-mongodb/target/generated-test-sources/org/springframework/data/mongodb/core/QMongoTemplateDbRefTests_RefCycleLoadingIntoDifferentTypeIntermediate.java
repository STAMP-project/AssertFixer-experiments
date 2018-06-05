package org.springframework.data.mongodb.core;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMongoTemplateDbRefTests_RefCycleLoadingIntoDifferentTypeIntermediate is a Querydsl query type for RefCycleLoadingIntoDifferentTypeIntermediate
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMongoTemplateDbRefTests_RefCycleLoadingIntoDifferentTypeIntermediate extends EntityPathBase<MongoTemplateDbRefTests.RefCycleLoadingIntoDifferentTypeIntermediate> {

    private static final long serialVersionUID = -1912961779L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMongoTemplateDbRefTests_RefCycleLoadingIntoDifferentTypeIntermediate refCycleLoadingIntoDifferentTypeIntermediate = new QMongoTemplateDbRefTests_RefCycleLoadingIntoDifferentTypeIntermediate("refCycleLoadingIntoDifferentTypeIntermediate");

    public final StringPath id = createString("id");

    public final QMongoTemplateDbRefTests_RefCycleLoadingIntoDifferentTypeRootView refToRootView;

    public QMongoTemplateDbRefTests_RefCycleLoadingIntoDifferentTypeIntermediate(String variable) {
        this(MongoTemplateDbRefTests.RefCycleLoadingIntoDifferentTypeIntermediate.class, forVariable(variable), INITS);
    }

    public QMongoTemplateDbRefTests_RefCycleLoadingIntoDifferentTypeIntermediate(Path<? extends MongoTemplateDbRefTests.RefCycleLoadingIntoDifferentTypeIntermediate> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMongoTemplateDbRefTests_RefCycleLoadingIntoDifferentTypeIntermediate(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMongoTemplateDbRefTests_RefCycleLoadingIntoDifferentTypeIntermediate(PathMetadata metadata, PathInits inits) {
        this(MongoTemplateDbRefTests.RefCycleLoadingIntoDifferentTypeIntermediate.class, metadata, inits);
    }

    public QMongoTemplateDbRefTests_RefCycleLoadingIntoDifferentTypeIntermediate(Class<? extends MongoTemplateDbRefTests.RefCycleLoadingIntoDifferentTypeIntermediate> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.refToRootView = inits.isInitialized("refToRootView") ? new QMongoTemplateDbRefTests_RefCycleLoadingIntoDifferentTypeRootView(forProperty("refToRootView")) : null;
    }

}

