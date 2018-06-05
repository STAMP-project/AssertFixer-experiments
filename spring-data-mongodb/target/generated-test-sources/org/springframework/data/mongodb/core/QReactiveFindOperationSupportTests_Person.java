package org.springframework.data.mongodb.core;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QReactiveFindOperationSupportTests_Person is a Querydsl query type for Person
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QReactiveFindOperationSupportTests_Person extends EntityPathBase<ReactiveFindOperationSupportTests.Person> {

    private static final long serialVersionUID = -810876302L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QReactiveFindOperationSupportTests_Person person = new QReactiveFindOperationSupportTests_Person("person");

    public final SimplePath<Object> ability = createSimple("ability", Object.class);

    public final QReactiveFindOperationSupportTests_Person father;

    public final StringPath firstname = createString("firstname");

    public final StringPath id = createString("id");

    public final StringPath lastname = createString("lastname");

    public QReactiveFindOperationSupportTests_Person(String variable) {
        this(ReactiveFindOperationSupportTests.Person.class, forVariable(variable), INITS);
    }

    public QReactiveFindOperationSupportTests_Person(Path<? extends ReactiveFindOperationSupportTests.Person> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QReactiveFindOperationSupportTests_Person(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QReactiveFindOperationSupportTests_Person(PathMetadata metadata, PathInits inits) {
        this(ReactiveFindOperationSupportTests.Person.class, metadata, inits);
    }

    public QReactiveFindOperationSupportTests_Person(Class<? extends ReactiveFindOperationSupportTests.Person> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.father = inits.isInitialized("father") ? new QReactiveFindOperationSupportTests_Person(forProperty("father"), inits.get("father")) : null;
    }

}

