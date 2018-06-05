package org.springframework.data.mongodb.core.index;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMongoPersistentEntityIndexCreatorUnitTests_Person is a Querydsl query type for Person
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMongoPersistentEntityIndexCreatorUnitTests_Person extends EntityPathBase<MongoPersistentEntityIndexCreatorUnitTests.Person> {

    private static final long serialVersionUID = -802285892L;

    public static final QMongoPersistentEntityIndexCreatorUnitTests_Person person = new QMongoPersistentEntityIndexCreatorUnitTests_Person("person");

    public final StringPath field = createString("field");

    public QMongoPersistentEntityIndexCreatorUnitTests_Person(String variable) {
        super(MongoPersistentEntityIndexCreatorUnitTests.Person.class, forVariable(variable));
    }

    public QMongoPersistentEntityIndexCreatorUnitTests_Person(Path<? extends MongoPersistentEntityIndexCreatorUnitTests.Person> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMongoPersistentEntityIndexCreatorUnitTests_Person(PathMetadata metadata) {
        super(MongoPersistentEntityIndexCreatorUnitTests.Person.class, metadata);
    }

}

