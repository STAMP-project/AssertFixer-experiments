package org.springframework.data.mongodb.core;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QExecutableUpdateOperationSupportTests_Person is a Querydsl query type for Person
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QExecutableUpdateOperationSupportTests_Person extends EntityPathBase<ExecutableUpdateOperationSupportTests.Person> {

    private static final long serialVersionUID = -727415469L;

    public static final QExecutableUpdateOperationSupportTests_Person person = new QExecutableUpdateOperationSupportTests_Person("person");

    public final StringPath firstname = createString("firstname");

    public final StringPath id = createString("id");

    public QExecutableUpdateOperationSupportTests_Person(String variable) {
        super(ExecutableUpdateOperationSupportTests.Person.class, forVariable(variable));
    }

    public QExecutableUpdateOperationSupportTests_Person(Path<? extends ExecutableUpdateOperationSupportTests.Person> path) {
        super(path.getType(), path.getMetadata());
    }

    public QExecutableUpdateOperationSupportTests_Person(PathMetadata metadata) {
        super(ExecutableUpdateOperationSupportTests.Person.class, metadata);
    }

}

