package org.springframework.data.mongodb.core;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QReactiveRemoveOperationSupportTests_Person is a Querydsl query type for Person
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QReactiveRemoveOperationSupportTests_Person extends EntityPathBase<ReactiveRemoveOperationSupportTests.Person> {

    private static final long serialVersionUID = 1201014525L;

    public static final QReactiveRemoveOperationSupportTests_Person person = new QReactiveRemoveOperationSupportTests_Person("person");

    public final StringPath firstname = createString("firstname");

    public final StringPath id = createString("id");

    public QReactiveRemoveOperationSupportTests_Person(String variable) {
        super(ReactiveRemoveOperationSupportTests.Person.class, forVariable(variable));
    }

    public QReactiveRemoveOperationSupportTests_Person(Path<? extends ReactiveRemoveOperationSupportTests.Person> path) {
        super(path.getType(), path.getMetadata());
    }

    public QReactiveRemoveOperationSupportTests_Person(PathMetadata metadata) {
        super(ReactiveRemoveOperationSupportTests.Person.class, metadata);
    }

}

