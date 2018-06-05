package org.springframework.data.mongodb.core;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QReactiveInsertOperationSupportUnitTests_Person is a Querydsl query type for Person
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QReactiveInsertOperationSupportUnitTests_Person extends EntityPathBase<ReactiveInsertOperationSupportUnitTests.Person> {

    private static final long serialVersionUID = -1591296170L;

    public static final QReactiveInsertOperationSupportUnitTests_Person person = new QReactiveInsertOperationSupportUnitTests_Person("person");

    public final StringPath firstname = createString("firstname");

    public final StringPath id = createString("id");

    public QReactiveInsertOperationSupportUnitTests_Person(String variable) {
        super(ReactiveInsertOperationSupportUnitTests.Person.class, forVariable(variable));
    }

    public QReactiveInsertOperationSupportUnitTests_Person(Path<? extends ReactiveInsertOperationSupportUnitTests.Person> path) {
        super(path.getType(), path.getMetadata());
    }

    public QReactiveInsertOperationSupportUnitTests_Person(PathMetadata metadata) {
        super(ReactiveInsertOperationSupportUnitTests.Person.class, metadata);
    }

}

