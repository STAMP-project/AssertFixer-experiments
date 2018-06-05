package org.springframework.data.mongodb.repository.support;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSimpleMongoRepositoryTests_PersonExtended is a Querydsl query type for PersonExtended
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSimpleMongoRepositoryTests_PersonExtended extends EntityPathBase<SimpleMongoRepositoryTests.PersonExtended> {

    private static final long serialVersionUID = 617621917L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSimpleMongoRepositoryTests_PersonExtended personExtended = new QSimpleMongoRepositoryTests_PersonExtended("personExtended");

    public final org.springframework.data.mongodb.repository.QPerson _super;

    // inherited
    public final org.springframework.data.mongodb.repository.QAddress address;

    //inherited
    public final NumberPath<Integer> age;

    // inherited
    public final org.springframework.data.mongodb.repository.QUser coworker;

    //inherited
    public final DateTimePath<java.util.Date> createdAt;

    // inherited
    public final org.springframework.data.mongodb.repository.QUser creator;

    // custom
    // inherited
    public final org.springframework.data.mongodb.repository.QCredentials credentials;

    //inherited
    public final StringPath email;

    //inherited
    public final ListPath<org.springframework.data.mongodb.repository.User, org.springframework.data.mongodb.repository.QUser> fans;

    //inherited
    public final StringPath firstname;

    //inherited
    public final StringPath id;

    //inherited
    public final StringPath lastname;

    // inherited
    public final org.springframework.data.geo.QPoint location;

    //inherited
    public final StringPath name;

    //inherited
    public final ListPath<org.springframework.data.mongodb.repository.User, org.springframework.data.mongodb.repository.QUser> realFans;

    //inherited
    public final EnumPath<org.springframework.data.mongodb.repository.Person.Sex> sex;

    //inherited
    public final SetPath<org.springframework.data.mongodb.repository.Address, org.springframework.data.mongodb.repository.QAddress> shippingAddresses;

    //inherited
    public final ListPath<String, StringPath> skills;

    //inherited
    public final ComparablePath<java.util.UUID> uniqueId;

    public QSimpleMongoRepositoryTests_PersonExtended(String variable) {
        this(SimpleMongoRepositoryTests.PersonExtended.class, forVariable(variable), INITS);
    }

    public QSimpleMongoRepositoryTests_PersonExtended(Path<? extends SimpleMongoRepositoryTests.PersonExtended> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QSimpleMongoRepositoryTests_PersonExtended(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QSimpleMongoRepositoryTests_PersonExtended(PathMetadata metadata, PathInits inits) {
        this(SimpleMongoRepositoryTests.PersonExtended.class, metadata, inits);
    }

    public QSimpleMongoRepositoryTests_PersonExtended(Class<? extends SimpleMongoRepositoryTests.PersonExtended> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new org.springframework.data.mongodb.repository.QPerson(type, metadata, inits);
        this.address = _super.address;
        this.age = _super.age;
        this.coworker = _super.coworker;
        this.createdAt = _super.createdAt;
        this.creator = _super.creator;
        this.credentials = _super.credentials;
        this.email = _super.email;
        this.fans = _super.fans;
        this.firstname = _super.firstname;
        this.id = _super.id;
        this.lastname = _super.lastname;
        this.location = _super.location;
        this.name = _super.name;
        this.realFans = _super.realFans;
        this.sex = _super.sex;
        this.shippingAddresses = _super.shippingAddresses;
        this.skills = _super.skills;
        this.uniqueId = _super.uniqueId;
    }

}

