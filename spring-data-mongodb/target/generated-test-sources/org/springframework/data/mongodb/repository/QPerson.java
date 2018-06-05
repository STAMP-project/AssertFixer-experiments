package org.springframework.data.mongodb.repository;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPerson is a Querydsl query type for Person
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPerson extends EntityPathBase<Person> {

    private static final long serialVersionUID = -2035209696L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPerson person = new QPerson("person");

    public final QContact _super = new QContact(this);

    public final QAddress address;

    public final NumberPath<Integer> age = createNumber("age", Integer.class);

    public final QUser coworker;

    public final DateTimePath<java.util.Date> createdAt = createDateTime("createdAt", java.util.Date.class);

    public final QUser creator;

    // custom
    public final QCredentials credentials = new QCredentials(forProperty("credentials"));

    public final StringPath email = createString("email");

    public final ListPath<User, QUser> fans = this.<User, QUser>createList("fans", User.class, QUser.class, PathInits.DIRECT2);

    public final StringPath firstname = createString("firstname");

    //inherited
    public final StringPath id = _super.id;

    public final StringPath lastname = createString("lastname");

    public final org.springframework.data.geo.QPoint location;

    public final StringPath name = createString("name");

    public final ListPath<User, QUser> realFans = this.<User, QUser>createList("realFans", User.class, QUser.class, PathInits.DIRECT2);

    public final EnumPath<Person.Sex> sex = createEnum("sex", Person.Sex.class);

    public final SetPath<Address, QAddress> shippingAddresses = this.<Address, QAddress>createSet("shippingAddresses", Address.class, QAddress.class, PathInits.DIRECT2);

    public final ListPath<String, StringPath> skills = this.<String, StringPath>createList("skills", String.class, StringPath.class, PathInits.DIRECT2);

    public final ComparablePath<java.util.UUID> uniqueId = createComparable("uniqueId", java.util.UUID.class);

    public QPerson(String variable) {
        this(Person.class, forVariable(variable), INITS);
    }

    public QPerson(Path<? extends Person> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPerson(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPerson(PathMetadata metadata, PathInits inits) {
        this(Person.class, metadata, inits);
    }

    public QPerson(Class<? extends Person> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.address = inits.isInitialized("address") ? new QAddress(forProperty("address")) : null;
        this.coworker = inits.isInitialized("coworker") ? new QUser(forProperty("coworker")) : null;
        this.creator = inits.isInitialized("creator") ? new QUser(forProperty("creator")) : null;
        this.location = inits.isInitialized("location") ? new org.springframework.data.geo.QPoint(forProperty("location")) : null;
    }

}

