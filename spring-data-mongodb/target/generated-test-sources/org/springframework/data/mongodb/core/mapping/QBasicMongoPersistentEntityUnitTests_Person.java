package org.springframework.data.mongodb.core.mapping;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QBasicMongoPersistentEntityUnitTests_Person is a Querydsl query type for Person
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QBasicMongoPersistentEntityUnitTests_Person extends EntityPathBase<BasicMongoPersistentEntityUnitTests.Person> {

    private static final long serialVersionUID = 1161316540L;

    public static final QBasicMongoPersistentEntityUnitTests_Person person = new QBasicMongoPersistentEntityUnitTests_Person("person");

    public final QBasicMongoPersistentEntityUnitTests_Contact _super = new QBasicMongoPersistentEntityUnitTests_Contact(this);

    public QBasicMongoPersistentEntityUnitTests_Person(String variable) {
        super(BasicMongoPersistentEntityUnitTests.Person.class, forVariable(variable));
    }

    public QBasicMongoPersistentEntityUnitTests_Person(Path<? extends BasicMongoPersistentEntityUnitTests.Person> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBasicMongoPersistentEntityUnitTests_Person(PathMetadata metadata) {
        super(BasicMongoPersistentEntityUnitTests.Person.class, metadata);
    }

}

