package org.springframework.data.mongodb.core.schema;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QReactiveMongoJsonSchemaTests_Address is a Querydsl query type for Address
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QReactiveMongoJsonSchemaTests_Address extends BeanPath<ReactiveMongoJsonSchemaTests.Address> {

    private static final long serialVersionUID = -1059890438L;

    public static final QReactiveMongoJsonSchemaTests_Address address = new QReactiveMongoJsonSchemaTests_Address("address");

    public final StringPath city = createString("city");

    public final StringPath postCode = createString("postCode");

    public final StringPath street = createString("street");

    public QReactiveMongoJsonSchemaTests_Address(String variable) {
        super(ReactiveMongoJsonSchemaTests.Address.class, forVariable(variable));
    }

    public QReactiveMongoJsonSchemaTests_Address(Path<? extends ReactiveMongoJsonSchemaTests.Address> path) {
        super(path.getType(), path.getMetadata());
    }

    public QReactiveMongoJsonSchemaTests_Address(PathMetadata metadata) {
        super(ReactiveMongoJsonSchemaTests.Address.class, metadata);
    }

}

