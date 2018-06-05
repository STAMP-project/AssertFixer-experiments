package org.springframework.data.mongodb.core.convert;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMongoConvertersIntegrationTests_WithBinaryDataInArray is a Querydsl query type for WithBinaryDataInArray
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMongoConvertersIntegrationTests_WithBinaryDataInArray extends EntityPathBase<MongoConvertersIntegrationTests.WithBinaryDataInArray> {

    private static final long serialVersionUID = 219936920L;

    public static final QMongoConvertersIntegrationTests_WithBinaryDataInArray withBinaryDataInArray = new QMongoConvertersIntegrationTests_WithBinaryDataInArray("withBinaryDataInArray");

    public final ArrayPath<byte[], Byte> data = createArray("data", byte[].class);

    public final StringPath id = createString("id");

    public QMongoConvertersIntegrationTests_WithBinaryDataInArray(String variable) {
        super(MongoConvertersIntegrationTests.WithBinaryDataInArray.class, forVariable(variable));
    }

    public QMongoConvertersIntegrationTests_WithBinaryDataInArray(Path<? extends MongoConvertersIntegrationTests.WithBinaryDataInArray> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMongoConvertersIntegrationTests_WithBinaryDataInArray(PathMetadata metadata) {
        super(MongoConvertersIntegrationTests.WithBinaryDataInArray.class, metadata);
    }

}

