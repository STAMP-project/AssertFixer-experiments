package org.springframework.data.mongodb.core;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QExecutableInsertOperationSupportUnitTests_Person is a Querydsl query type for Person
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QExecutableInsertOperationSupportUnitTests_Person extends EntityPathBase<ExecutableInsertOperationSupportUnitTests.Person> {

    private static final long serialVersionUID = 531052135L;

    public static final QExecutableInsertOperationSupportUnitTests_Person person = new QExecutableInsertOperationSupportUnitTests_Person("person");

    public final StringPath firstname = createString("firstname");

    public final StringPath id = createString("id");

    public QExecutableInsertOperationSupportUnitTests_Person(String variable) {
        super(ExecutableInsertOperationSupportUnitTests.Person.class, forVariable(variable));
    }

    public QExecutableInsertOperationSupportUnitTests_Person(Path<? extends ExecutableInsertOperationSupportUnitTests.Person> path) {
        super(path.getType(), path.getMetadata());
    }

    public QExecutableInsertOperationSupportUnitTests_Person(PathMetadata metadata) {
        super(ExecutableInsertOperationSupportUnitTests.Person.class, metadata);
    }

}

