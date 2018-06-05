package org.springframework.data.mongodb.core.schema;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMongoJsonSchemaTests_Person is a Querydsl query type for Person
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMongoJsonSchemaTests_Person extends EntityPathBase<MongoJsonSchemaTests.Person> {

    private static final long serialVersionUID = 146539336L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMongoJsonSchemaTests_Person person = new QMongoJsonSchemaTests_Person("person");

    public final QMongoJsonSchemaTests_Address address;

    public final StringPath firstname = createString("firstname");

    public final StringPath lastname = createString("lastname");

    public QMongoJsonSchemaTests_Person(String variable) {
        this(MongoJsonSchemaTests.Person.class, forVariable(variable), INITS);
    }

    public QMongoJsonSchemaTests_Person(Path<? extends MongoJsonSchemaTests.Person> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMongoJsonSchemaTests_Person(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMongoJsonSchemaTests_Person(PathMetadata metadata, PathInits inits) {
        this(MongoJsonSchemaTests.Person.class, metadata, inits);
    }

    public QMongoJsonSchemaTests_Person(Class<? extends MongoJsonSchemaTests.Person> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.address = inits.isInitialized("address") ? new QMongoJsonSchemaTests_Address(forProperty("address")) : null;
    }

}

