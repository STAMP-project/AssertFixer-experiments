package org.springframework.data.mongodb.core.mapping;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPersonMapProperty is a Querydsl query type for PersonMapProperty
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPersonMapProperty extends EntityPathBase<PersonMapProperty> {

    private static final long serialVersionUID = 302071238L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPersonMapProperty personMapProperty = new QPersonMapProperty("personMapProperty");

    public final QBasePerson _super = new QBasePerson(this);

    public final MapPath<String, AccountPojo, QAccountPojo> accounts = this.<String, AccountPojo, QAccountPojo>createMap("accounts", String.class, AccountPojo.class, QAccountPojo.class);

    //inherited
    public final StringPath firstName = _super.firstName;

    public final org.bson.types.QObjectId id;

    //inherited
    public final StringPath lastName = _super.lastName;

    //inherited
    public final NumberPath<Integer> ssn = _super.ssn;

    public QPersonMapProperty(String variable) {
        this(PersonMapProperty.class, forVariable(variable), INITS);
    }

    public QPersonMapProperty(Path<? extends PersonMapProperty> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPersonMapProperty(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPersonMapProperty(PathMetadata metadata, PathInits inits) {
        this(PersonMapProperty.class, metadata, inits);
    }

    public QPersonMapProperty(Class<? extends PersonMapProperty> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.id = inits.isInitialized("id") ? new org.bson.types.QObjectId(forProperty("id")) : null;
    }

}

