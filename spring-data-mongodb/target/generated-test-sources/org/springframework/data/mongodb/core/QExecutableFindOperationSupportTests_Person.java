package org.springframework.data.mongodb.core;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QExecutableFindOperationSupportTests_Person is a Querydsl query type for Person
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QExecutableFindOperationSupportTests_Person extends EntityPathBase<ExecutableFindOperationSupportTests.Person> {

    private static final long serialVersionUID = -112043453L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QExecutableFindOperationSupportTests_Person person = new QExecutableFindOperationSupportTests_Person("person");

    public final SimplePath<Object> ability = createSimple("ability", Object.class);

    public final QExecutableFindOperationSupportTests_Person father;

    public final StringPath firstname = createString("firstname");

    public final StringPath id = createString("id");

    public final StringPath lastname = createString("lastname");

    public QExecutableFindOperationSupportTests_Person(String variable) {
        this(ExecutableFindOperationSupportTests.Person.class, forVariable(variable), INITS);
    }

    public QExecutableFindOperationSupportTests_Person(Path<? extends ExecutableFindOperationSupportTests.Person> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QExecutableFindOperationSupportTests_Person(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QExecutableFindOperationSupportTests_Person(PathMetadata metadata, PathInits inits) {
        this(ExecutableFindOperationSupportTests.Person.class, metadata, inits);
    }

    public QExecutableFindOperationSupportTests_Person(Class<? extends ExecutableFindOperationSupportTests.Person> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.father = inits.isInitialized("father") ? new QExecutableFindOperationSupportTests_Person(forProperty("father"), inits.get("father")) : null;
    }

}

