package org.springframework.data.mongodb.core;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMongoTemplateUnitTests_PersonExtended is a Querydsl query type for PersonExtended
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMongoTemplateUnitTests_PersonExtended extends EntityPathBase<MongoTemplateUnitTests.PersonExtended> {

    private static final long serialVersionUID = 477756855L;

    public static final QMongoTemplateUnitTests_PersonExtended personExtended = new QMongoTemplateUnitTests_PersonExtended("personExtended");

    public final QMongoTemplateUnitTests_Person _super = new QMongoTemplateUnitTests_Person(this);

    //inherited
    public final StringPath firstname = _super.firstname;

    //inherited
    public final StringPath id = _super.id;

    public final StringPath lastname = createString("lastname");

    public QMongoTemplateUnitTests_PersonExtended(String variable) {
        super(MongoTemplateUnitTests.PersonExtended.class, forVariable(variable));
    }

    public QMongoTemplateUnitTests_PersonExtended(Path<? extends MongoTemplateUnitTests.PersonExtended> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMongoTemplateUnitTests_PersonExtended(PathMetadata metadata) {
        super(MongoTemplateUnitTests.PersonExtended.class, metadata);
    }

}

