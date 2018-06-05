package org.springframework.data.mongodb.core;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QReactiveUpdateOperationSupportTests_Person is a Querydsl query type for Person
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QReactiveUpdateOperationSupportTests_Person extends EntityPathBase<ReactiveUpdateOperationSupportTests.Person> {

    private static final long serialVersionUID = 2004082114L;

    public static final QReactiveUpdateOperationSupportTests_Person person = new QReactiveUpdateOperationSupportTests_Person("person");

    public final StringPath firstname = createString("firstname");

    public final StringPath id = createString("id");

    public QReactiveUpdateOperationSupportTests_Person(String variable) {
        super(ReactiveUpdateOperationSupportTests.Person.class, forVariable(variable));
    }

    public QReactiveUpdateOperationSupportTests_Person(Path<? extends ReactiveUpdateOperationSupportTests.Person> path) {
        super(path.getType(), path.getMetadata());
    }

    public QReactiveUpdateOperationSupportTests_Person(PathMetadata metadata) {
        super(ReactiveUpdateOperationSupportTests.Person.class, metadata);
    }

}

