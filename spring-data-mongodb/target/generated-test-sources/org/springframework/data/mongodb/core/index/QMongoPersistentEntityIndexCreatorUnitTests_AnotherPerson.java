package org.springframework.data.mongodb.core.index;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMongoPersistentEntityIndexCreatorUnitTests_AnotherPerson is a Querydsl query type for AnotherPerson
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMongoPersistentEntityIndexCreatorUnitTests_AnotherPerson extends EntityPathBase<MongoPersistentEntityIndexCreatorUnitTests.AnotherPerson> {

    private static final long serialVersionUID = -864275727L;

    public static final QMongoPersistentEntityIndexCreatorUnitTests_AnotherPerson anotherPerson = new QMongoPersistentEntityIndexCreatorUnitTests_AnotherPerson("anotherPerson");

    public final StringPath lastname = createString("lastname");

    public QMongoPersistentEntityIndexCreatorUnitTests_AnotherPerson(String variable) {
        super(MongoPersistentEntityIndexCreatorUnitTests.AnotherPerson.class, forVariable(variable));
    }

    public QMongoPersistentEntityIndexCreatorUnitTests_AnotherPerson(Path<? extends MongoPersistentEntityIndexCreatorUnitTests.AnotherPerson> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMongoPersistentEntityIndexCreatorUnitTests_AnotherPerson(PathMetadata metadata) {
        super(MongoPersistentEntityIndexCreatorUnitTests.AnotherPerson.class, metadata);
    }

}

