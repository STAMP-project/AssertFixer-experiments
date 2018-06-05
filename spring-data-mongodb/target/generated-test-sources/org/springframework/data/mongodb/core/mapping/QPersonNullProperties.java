package org.springframework.data.mongodb.core.mapping;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPersonNullProperties is a Querydsl query type for PersonNullProperties
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPersonNullProperties extends EntityPathBase<PersonNullProperties> {

    private static final long serialVersionUID = -7426171L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPersonNullProperties personNullProperties = new QPersonNullProperties("personNullProperties");

    public final QBasePerson _super = new QBasePerson(this);

    //inherited
    public final StringPath firstName = _super.firstName;

    public final org.bson.types.QObjectId id;

    //inherited
    public final StringPath lastName = _super.lastName;

    //inherited
    public final NumberPath<Integer> ssn = _super.ssn;

    public QPersonNullProperties(String variable) {
        this(PersonNullProperties.class, forVariable(variable), INITS);
    }

    public QPersonNullProperties(Path<? extends PersonNullProperties> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPersonNullProperties(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPersonNullProperties(PathMetadata metadata, PathInits inits) {
        this(PersonNullProperties.class, metadata, inits);
    }

    public QPersonNullProperties(Class<? extends PersonNullProperties> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.id = inits.isInitialized("id") ? new org.bson.types.QObjectId(forProperty("id")) : null;
    }

}

