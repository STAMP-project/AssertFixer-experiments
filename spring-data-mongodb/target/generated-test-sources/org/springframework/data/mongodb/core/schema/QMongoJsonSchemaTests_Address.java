package org.springframework.data.mongodb.core.schema;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMongoJsonSchemaTests_Address is a Querydsl query type for Address
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QMongoJsonSchemaTests_Address extends BeanPath<MongoJsonSchemaTests.Address> {

    private static final long serialVersionUID = -221498783L;

    public static final QMongoJsonSchemaTests_Address address = new QMongoJsonSchemaTests_Address("address");

    public final StringPath city = createString("city");

    public final StringPath postCode = createString("postCode");

    public final StringPath street = createString("street");

    public QMongoJsonSchemaTests_Address(String variable) {
        super(MongoJsonSchemaTests.Address.class, forVariable(variable));
    }

    public QMongoJsonSchemaTests_Address(Path<? extends MongoJsonSchemaTests.Address> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMongoJsonSchemaTests_Address(PathMetadata metadata) {
        super(MongoJsonSchemaTests.Address.class, metadata);
    }

}

