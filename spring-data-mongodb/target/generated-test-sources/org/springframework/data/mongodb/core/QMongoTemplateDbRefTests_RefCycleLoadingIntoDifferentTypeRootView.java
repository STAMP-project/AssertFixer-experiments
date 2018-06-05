package org.springframework.data.mongodb.core;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMongoTemplateDbRefTests_RefCycleLoadingIntoDifferentTypeRootView is a Querydsl query type for RefCycleLoadingIntoDifferentTypeRootView
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMongoTemplateDbRefTests_RefCycleLoadingIntoDifferentTypeRootView extends EntityPathBase<MongoTemplateDbRefTests.RefCycleLoadingIntoDifferentTypeRootView> {

    private static final long serialVersionUID = -2032870213L;

    public static final QMongoTemplateDbRefTests_RefCycleLoadingIntoDifferentTypeRootView refCycleLoadingIntoDifferentTypeRootView = new QMongoTemplateDbRefTests_RefCycleLoadingIntoDifferentTypeRootView("refCycleLoadingIntoDifferentTypeRootView");

    public final StringPath content = createString("content");

    public final StringPath id = createString("id");

    public QMongoTemplateDbRefTests_RefCycleLoadingIntoDifferentTypeRootView(String variable) {
        super(MongoTemplateDbRefTests.RefCycleLoadingIntoDifferentTypeRootView.class, forVariable(variable));
    }

    public QMongoTemplateDbRefTests_RefCycleLoadingIntoDifferentTypeRootView(Path<? extends MongoTemplateDbRefTests.RefCycleLoadingIntoDifferentTypeRootView> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMongoTemplateDbRefTests_RefCycleLoadingIntoDifferentTypeRootView(PathMetadata metadata) {
        super(MongoTemplateDbRefTests.RefCycleLoadingIntoDifferentTypeRootView.class, metadata);
    }

}

