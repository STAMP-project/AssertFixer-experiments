package org.springframework.data.mongodb.core;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QExecutableMapReduceOperationSupportUnitTests_Person is a Querydsl query type for Person
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QExecutableMapReduceOperationSupportUnitTests_Person extends EntityPathBase<ExecutableMapReduceOperationSupportUnitTests.Person> {

    private static final long serialVersionUID = -1707249008L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QExecutableMapReduceOperationSupportUnitTests_Person person = new QExecutableMapReduceOperationSupportUnitTests_Person("person");

    public final SimplePath<Object> ability = createSimple("ability", Object.class);

    public final QExecutableMapReduceOperationSupportUnitTests_Person father;

    public final StringPath firstname = createString("firstname");

    public final StringPath id = createString("id");

    public final StringPath lastname = createString("lastname");

    public QExecutableMapReduceOperationSupportUnitTests_Person(String variable) {
        this(ExecutableMapReduceOperationSupportUnitTests.Person.class, forVariable(variable), INITS);
    }

    public QExecutableMapReduceOperationSupportUnitTests_Person(Path<? extends ExecutableMapReduceOperationSupportUnitTests.Person> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QExecutableMapReduceOperationSupportUnitTests_Person(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QExecutableMapReduceOperationSupportUnitTests_Person(PathMetadata metadata, PathInits inits) {
        this(ExecutableMapReduceOperationSupportUnitTests.Person.class, metadata, inits);
    }

    public QExecutableMapReduceOperationSupportUnitTests_Person(Class<? extends ExecutableMapReduceOperationSupportUnitTests.Person> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.father = inits.isInitialized("father") ? new QExecutableMapReduceOperationSupportUnitTests_Person(forProperty("father"), inits.get("father")) : null;
    }

}

