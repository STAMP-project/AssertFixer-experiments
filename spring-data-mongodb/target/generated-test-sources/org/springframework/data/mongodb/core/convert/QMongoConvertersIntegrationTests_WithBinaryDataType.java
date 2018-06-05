package org.springframework.data.mongodb.core.convert;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMongoConvertersIntegrationTests_WithBinaryDataType is a Querydsl query type for WithBinaryDataType
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMongoConvertersIntegrationTests_WithBinaryDataType extends EntityPathBase<MongoConvertersIntegrationTests.WithBinaryDataType> {

    private static final long serialVersionUID = -574458538L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMongoConvertersIntegrationTests_WithBinaryDataType withBinaryDataType = new QMongoConvertersIntegrationTests_WithBinaryDataType("withBinaryDataType");

    public final org.bson.types.QBinary data;

    public final StringPath id = createString("id");

    public QMongoConvertersIntegrationTests_WithBinaryDataType(String variable) {
        this(MongoConvertersIntegrationTests.WithBinaryDataType.class, forVariable(variable), INITS);
    }

    public QMongoConvertersIntegrationTests_WithBinaryDataType(Path<? extends MongoConvertersIntegrationTests.WithBinaryDataType> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMongoConvertersIntegrationTests_WithBinaryDataType(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMongoConvertersIntegrationTests_WithBinaryDataType(PathMetadata metadata, PathInits inits) {
        this(MongoConvertersIntegrationTests.WithBinaryDataType.class, metadata, inits);
    }

    public QMongoConvertersIntegrationTests_WithBinaryDataType(Class<? extends MongoConvertersIntegrationTests.WithBinaryDataType> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.data = inits.isInitialized("data") ? new org.bson.types.QBinary(forProperty("data")) : null;
    }

}

