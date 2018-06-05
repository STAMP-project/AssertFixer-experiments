package org.springframework.data.mongodb.core.index;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QReactiveMongoPersistentEntityIndexCreatorUnitTests_Person is a Querydsl query type for Person
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QReactiveMongoPersistentEntityIndexCreatorUnitTests_Person extends EntityPathBase<ReactiveMongoPersistentEntityIndexCreatorUnitTests.Person> {

    private static final long serialVersionUID = 465134275L;

    public static final QReactiveMongoPersistentEntityIndexCreatorUnitTests_Person person = new QReactiveMongoPersistentEntityIndexCreatorUnitTests_Person("person");

    public final StringPath field = createString("field");

    public QReactiveMongoPersistentEntityIndexCreatorUnitTests_Person(String variable) {
        super(ReactiveMongoPersistentEntityIndexCreatorUnitTests.Person.class, forVariable(variable));
    }

    public QReactiveMongoPersistentEntityIndexCreatorUnitTests_Person(Path<? extends ReactiveMongoPersistentEntityIndexCreatorUnitTests.Person> path) {
        super(path.getType(), path.getMetadata());
    }

    public QReactiveMongoPersistentEntityIndexCreatorUnitTests_Person(PathMetadata metadata) {
        super(ReactiveMongoPersistentEntityIndexCreatorUnitTests.Person.class, metadata);
    }

}

