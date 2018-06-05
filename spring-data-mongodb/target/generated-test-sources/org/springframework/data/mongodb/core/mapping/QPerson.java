package org.springframework.data.mongodb.core.mapping;

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
public class QPerson extends EntityPathBase<Person<? extends Address>> {

    private static final long serialVersionUID = 342491275L;

    public static final QPerson person = new QPerson("person");

    public final ListPath<Account, QAccount> accounts = this.<Account, QAccount>createList("accounts", Account.class, QAccount.class, PathInits.DIRECT2);

    public final NumberPath<Integer> accountTotal = createNumber("accountTotal", Integer.class);

    // custom
    public final QAddress address = new QAddress(forProperty("address"));

    public final NumberPath<Integer> age = createNumber("age", Integer.class);

    public final StringPath firstName = createString("firstName");

    public final StringPath id = createString("id");

    public final StringPath lastName = createString("lastName");

    public final NumberPath<Integer> ssn = createNumber("ssn", Integer.class);

    @SuppressWarnings({"all", "rawtypes", "unchecked"})
    public QPerson(String variable) {
        super((Class) Person.class, forVariable(variable));
    }

    @SuppressWarnings({"all", "rawtypes", "unchecked"})
    public QPerson(Path<? extends Person> path) {
        super((Class) path.getType(), path.getMetadata());
    }

    @SuppressWarnings({"all", "rawtypes", "unchecked"})
    public QPerson(PathMetadata metadata) {
        super((Class) Person.class, metadata);
    }

}

