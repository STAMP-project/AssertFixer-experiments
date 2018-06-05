package org.springframework.data.mongodb.core.schema;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QReactiveMongoJsonSchemaTests_Person is a Querydsl query type for Person
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QReactiveMongoJsonSchemaTests_Person extends EntityPathBase<ReactiveMongoJsonSchemaTests.Person> {

    private static final long serialVersionUID = -850336881L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QReactiveMongoJsonSchemaTests_Person person = new QReactiveMongoJsonSchemaTests_Person("person");

    public final QReactiveMongoJsonSchemaTests_Address address;

    public final StringPath firstname = createString("firstname");

    public final StringPath lastname = createString("lastname");

    public QReactiveMongoJsonSchemaTests_Person(String variable) {
        this(ReactiveMongoJsonSchemaTests.Person.class, forVariable(variable), INITS);
    }

    public QReactiveMongoJsonSchemaTests_Person(Path<? extends ReactiveMongoJsonSchemaTests.Person> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QReactiveMongoJsonSchemaTests_Person(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QReactiveMongoJsonSchemaTests_Person(PathMetadata metadata, PathInits inits) {
        this(ReactiveMongoJsonSchemaTests.Person.class, metadata, inits);
    }

    public QReactiveMongoJsonSchemaTests_Person(Class<? extends ReactiveMongoJsonSchemaTests.Person> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.address = inits.isInitialized("address") ? new QReactiveMongoJsonSchemaTests_Address(forProperty("address")) : null;
    }

}

