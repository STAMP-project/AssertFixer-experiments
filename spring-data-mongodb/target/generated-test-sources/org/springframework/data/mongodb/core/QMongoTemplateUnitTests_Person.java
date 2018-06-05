package org.springframework.data.mongodb.core;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMongoTemplateUnitTests_Person is a Querydsl query type for Person
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMongoTemplateUnitTests_Person extends EntityPathBase<MongoTemplateUnitTests.Person> {

    private static final long serialVersionUID = 1594976862L;

    public static final QMongoTemplateUnitTests_Person person = new QMongoTemplateUnitTests_Person("person");

    public final StringPath firstname = createString("firstname");

    public final StringPath id = createString("id");

    public QMongoTemplateUnitTests_Person(String variable) {
        super(MongoTemplateUnitTests.Person.class, forVariable(variable));
    }

    public QMongoTemplateUnitTests_Person(Path<? extends MongoTemplateUnitTests.Person> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMongoTemplateUnitTests_Person(PathMetadata metadata) {
        super(MongoTemplateUnitTests.Person.class, metadata);
    }

}

