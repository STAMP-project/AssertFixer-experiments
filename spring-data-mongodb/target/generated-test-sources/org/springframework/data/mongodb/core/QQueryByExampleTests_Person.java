package org.springframework.data.mongodb.core;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QQueryByExampleTests_Person is a Querydsl query type for Person
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QQueryByExampleTests_Person extends EntityPathBase<QueryByExampleTests.Person> {

    private static final long serialVersionUID = 158974915L;

    public static final QQueryByExampleTests_Person person = new QQueryByExampleTests_Person("person");

    public final StringPath firstname = createString("firstname");

    public final StringPath id = createString("id");

    public final StringPath lastname = createString("lastname");

    public final StringPath middlename = createString("middlename");

    public QQueryByExampleTests_Person(String variable) {
        super(QueryByExampleTests.Person.class, forVariable(variable));
    }

    public QQueryByExampleTests_Person(Path<? extends QueryByExampleTests.Person> path) {
        super(path.getType(), path.getMetadata());
    }

    public QQueryByExampleTests_Person(PathMetadata metadata) {
        super(QueryByExampleTests.Person.class, metadata);
    }

}

