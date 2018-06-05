package org.springframework.data.mongodb.core.index;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMongoPersistentEntityIndexCreatorIntegrationTests_RecursiveGenericType is a Querydsl query type for RecursiveGenericType
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMongoPersistentEntityIndexCreatorIntegrationTests_RecursiveGenericType extends EntityPathBase<MongoPersistentEntityIndexCreatorIntegrationTests.RecursiveGenericType<?>> {

    private static final long serialVersionUID = -1071025302L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMongoPersistentEntityIndexCreatorIntegrationTests_RecursiveGenericType recursiveGenericType = new QMongoPersistentEntityIndexCreatorIntegrationTests_RecursiveGenericType("recursiveGenericType");

    public final StringPath firstName = createString("firstName");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QMongoPersistentEntityIndexCreatorIntegrationTests_RecursiveGenericType referrer;

    @SuppressWarnings({"all", "rawtypes", "unchecked"})
    public QMongoPersistentEntityIndexCreatorIntegrationTests_RecursiveGenericType(String variable) {
        this((Class) MongoPersistentEntityIndexCreatorIntegrationTests.RecursiveGenericType.class, forVariable(variable), INITS);
    }

    @SuppressWarnings({"all", "rawtypes", "unchecked"})
    public QMongoPersistentEntityIndexCreatorIntegrationTests_RecursiveGenericType(Path<? extends MongoPersistentEntityIndexCreatorIntegrationTests.RecursiveGenericType> path) {
        this((Class) path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMongoPersistentEntityIndexCreatorIntegrationTests_RecursiveGenericType(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    @SuppressWarnings({"all", "rawtypes", "unchecked"})
    public QMongoPersistentEntityIndexCreatorIntegrationTests_RecursiveGenericType(PathMetadata metadata, PathInits inits) {
        this((Class) MongoPersistentEntityIndexCreatorIntegrationTests.RecursiveGenericType.class, metadata, inits);
    }

    public QMongoPersistentEntityIndexCreatorIntegrationTests_RecursiveGenericType(Class<? extends MongoPersistentEntityIndexCreatorIntegrationTests.RecursiveGenericType<?>> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.referrer = inits.isInitialized("referrer") ? new QMongoPersistentEntityIndexCreatorIntegrationTests_RecursiveGenericType(forProperty("referrer"), inits.get("referrer")) : null;
    }

}

