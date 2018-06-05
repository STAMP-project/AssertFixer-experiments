package org.springframework.data.mongodb.core;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QExecutableRemoveOperationSupportTests_Person is a Querydsl query type for Person
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QExecutableRemoveOperationSupportTests_Person extends EntityPathBase<ExecutableRemoveOperationSupportTests.Person> {

    private static final long serialVersionUID = -1530483058L;

    public static final QExecutableRemoveOperationSupportTests_Person person = new QExecutableRemoveOperationSupportTests_Person("person");

    public final StringPath firstname = createString("firstname");

    public final StringPath id = createString("id");

    public QExecutableRemoveOperationSupportTests_Person(String variable) {
        super(ExecutableRemoveOperationSupportTests.Person.class, forVariable(variable));
    }

    public QExecutableRemoveOperationSupportTests_Person(Path<? extends ExecutableRemoveOperationSupportTests.Person> path) {
        super(path.getType(), path.getMetadata());
    }

    public QExecutableRemoveOperationSupportTests_Person(PathMetadata metadata) {
        super(ExecutableRemoveOperationSupportTests.Person.class, metadata);
    }

}

