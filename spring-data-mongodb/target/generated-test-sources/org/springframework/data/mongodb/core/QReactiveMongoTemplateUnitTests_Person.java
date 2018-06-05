package org.springframework.data.mongodb.core;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QReactiveMongoTemplateUnitTests_Person is a Querydsl query type for Person
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QReactiveMongoTemplateUnitTests_Person extends EntityPathBase<ReactiveMongoTemplateUnitTests.Person> {

    private static final long serialVersionUID = 983065573L;

    public static final QReactiveMongoTemplateUnitTests_Person person = new QReactiveMongoTemplateUnitTests_Person("person");

    public final StringPath firstname = createString("firstname");

    public final StringPath id = createString("id");

    public QReactiveMongoTemplateUnitTests_Person(String variable) {
        super(ReactiveMongoTemplateUnitTests.Person.class, forVariable(variable));
    }

    public QReactiveMongoTemplateUnitTests_Person(Path<? extends ReactiveMongoTemplateUnitTests.Person> path) {
        super(path.getType(), path.getMetadata());
    }

    public QReactiveMongoTemplateUnitTests_Person(PathMetadata metadata) {
        super(ReactiveMongoTemplateUnitTests.Person.class, metadata);
    }

}

