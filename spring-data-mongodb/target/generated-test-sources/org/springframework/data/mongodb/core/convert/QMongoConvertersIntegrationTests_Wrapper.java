package org.springframework.data.mongodb.core.convert;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMongoConvertersIntegrationTests_Wrapper is a Querydsl query type for Wrapper
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMongoConvertersIntegrationTests_Wrapper extends EntityPathBase<MongoConvertersIntegrationTests.Wrapper> {

    private static final long serialVersionUID = 291657640L;

    public static final QMongoConvertersIntegrationTests_Wrapper wrapper = new QMongoConvertersIntegrationTests_Wrapper("wrapper");

    public final StringPath id = createString("id");

    public final ComparablePath<java.util.UUID> uuid = createComparable("uuid", java.util.UUID.class);

    public QMongoConvertersIntegrationTests_Wrapper(String variable) {
        super(MongoConvertersIntegrationTests.Wrapper.class, forVariable(variable));
    }

    public QMongoConvertersIntegrationTests_Wrapper(Path<? extends MongoConvertersIntegrationTests.Wrapper> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMongoConvertersIntegrationTests_Wrapper(PathMetadata metadata) {
        super(MongoConvertersIntegrationTests.Wrapper.class, metadata);
    }

}

