package org.springframework.data.mongodb.core;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QReactiveMongoTemplateUnitTests_PersonExtended is a Querydsl query type for PersonExtended
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QReactiveMongoTemplateUnitTests_PersonExtended extends EntityPathBase<ReactiveMongoTemplateUnitTests.PersonExtended> {

    private static final long serialVersionUID = -770801602L;

    public static final QReactiveMongoTemplateUnitTests_PersonExtended personExtended = new QReactiveMongoTemplateUnitTests_PersonExtended("personExtended");

    public final QReactiveMongoTemplateUnitTests_Person _super = new QReactiveMongoTemplateUnitTests_Person(this);

    //inherited
    public final StringPath firstname = _super.firstname;

    //inherited
    public final StringPath id = _super.id;

    public final StringPath lastname = createString("lastname");

    public QReactiveMongoTemplateUnitTests_PersonExtended(String variable) {
        super(ReactiveMongoTemplateUnitTests.PersonExtended.class, forVariable(variable));
    }

    public QReactiveMongoTemplateUnitTests_PersonExtended(Path<? extends ReactiveMongoTemplateUnitTests.PersonExtended> path) {
        super(path.getType(), path.getMetadata());
    }

    public QReactiveMongoTemplateUnitTests_PersonExtended(PathMetadata metadata) {
        super(ReactiveMongoTemplateUnitTests.PersonExtended.class, metadata);
    }

}

