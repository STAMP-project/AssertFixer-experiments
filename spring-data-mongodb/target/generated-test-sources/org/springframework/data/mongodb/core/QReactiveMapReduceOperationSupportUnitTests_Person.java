package org.springframework.data.mongodb.core;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QReactiveMapReduceOperationSupportUnitTests_Person is a Querydsl query type for Person
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QReactiveMapReduceOperationSupportUnitTests_Person extends EntityPathBase<ReactiveMapReduceOperationSupportUnitTests.Person> {

    private static final long serialVersionUID = 1922928449L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QReactiveMapReduceOperationSupportUnitTests_Person person = new QReactiveMapReduceOperationSupportUnitTests_Person("person");

    public final SimplePath<Object> ability = createSimple("ability", Object.class);

    public final QReactiveMapReduceOperationSupportUnitTests_Person father;

    public final StringPath firstname = createString("firstname");

    public final StringPath id = createString("id");

    public final StringPath lastname = createString("lastname");

    public QReactiveMapReduceOperationSupportUnitTests_Person(String variable) {
        this(ReactiveMapReduceOperationSupportUnitTests.Person.class, forVariable(variable), INITS);
    }

    public QReactiveMapReduceOperationSupportUnitTests_Person(Path<? extends ReactiveMapReduceOperationSupportUnitTests.Person> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QReactiveMapReduceOperationSupportUnitTests_Person(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QReactiveMapReduceOperationSupportUnitTests_Person(PathMetadata metadata, PathInits inits) {
        this(ReactiveMapReduceOperationSupportUnitTests.Person.class, metadata, inits);
    }

    public QReactiveMapReduceOperationSupportUnitTests_Person(Class<? extends ReactiveMapReduceOperationSupportUnitTests.Person> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.father = inits.isInitialized("father") ? new QReactiveMapReduceOperationSupportUnitTests_Person(forProperty("father"), inits.get("father")) : null;
    }

}

