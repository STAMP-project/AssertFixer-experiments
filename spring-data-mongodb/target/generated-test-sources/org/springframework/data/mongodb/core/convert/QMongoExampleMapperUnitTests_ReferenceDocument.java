package org.springframework.data.mongodb.core.convert;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMongoExampleMapperUnitTests_ReferenceDocument is a Querydsl query type for ReferenceDocument
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMongoExampleMapperUnitTests_ReferenceDocument extends EntityPathBase<MongoExampleMapperUnitTests.ReferenceDocument> {

    private static final long serialVersionUID = -958013267L;

    public static final QMongoExampleMapperUnitTests_ReferenceDocument referenceDocument = new QMongoExampleMapperUnitTests_ReferenceDocument("referenceDocument");

    public final StringPath id = createString("id");

    public final StringPath value = createString("value");

    public QMongoExampleMapperUnitTests_ReferenceDocument(String variable) {
        super(MongoExampleMapperUnitTests.ReferenceDocument.class, forVariable(variable));
    }

    public QMongoExampleMapperUnitTests_ReferenceDocument(Path<? extends MongoExampleMapperUnitTests.ReferenceDocument> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMongoExampleMapperUnitTests_ReferenceDocument(PathMetadata metadata) {
        super(MongoExampleMapperUnitTests.ReferenceDocument.class, metadata);
    }

}

