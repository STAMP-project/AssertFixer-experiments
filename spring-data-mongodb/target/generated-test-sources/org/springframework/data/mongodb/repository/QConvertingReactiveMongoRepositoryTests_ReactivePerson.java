package org.springframework.data.mongodb.repository;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QConvertingReactiveMongoRepositoryTests_ReactivePerson is a Querydsl query type for ReactivePerson
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QConvertingReactiveMongoRepositoryTests_ReactivePerson extends EntityPathBase<ConvertingReactiveMongoRepositoryTests.ReactivePerson> {

    private static final long serialVersionUID = 1895376646L;

    public static final QConvertingReactiveMongoRepositoryTests_ReactivePerson reactivePerson = new QConvertingReactiveMongoRepositoryTests_ReactivePerson("reactivePerson");

    public final NumberPath<Integer> age = createNumber("age", Integer.class);

    public final StringPath firstname = createString("firstname");

    public final StringPath id = createString("id");

    public final StringPath lastname = createString("lastname");

    public QConvertingReactiveMongoRepositoryTests_ReactivePerson(String variable) {
        super(ConvertingReactiveMongoRepositoryTests.ReactivePerson.class, forVariable(variable));
    }

    public QConvertingReactiveMongoRepositoryTests_ReactivePerson(Path<? extends ConvertingReactiveMongoRepositoryTests.ReactivePerson> path) {
        super(path.getType(), path.getMetadata());
    }

    public QConvertingReactiveMongoRepositoryTests_ReactivePerson(PathMetadata metadata) {
        super(ConvertingReactiveMongoRepositoryTests.ReactivePerson.class, metadata);
    }

}

