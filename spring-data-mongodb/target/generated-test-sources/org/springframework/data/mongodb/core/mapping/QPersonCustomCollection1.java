package org.springframework.data.mongodb.core.mapping;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QPersonCustomCollection1 is a Querydsl query type for PersonCustomCollection1
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPersonCustomCollection1 extends EntityPathBase<PersonCustomCollection1> {

    private static final long serialVersionUID = 899180503L;

    public static final QPersonCustomCollection1 personCustomCollection1 = new QPersonCustomCollection1("personCustomCollection1");

    public final QBasePerson _super = new QBasePerson(this);

    //inherited
    public final StringPath firstName = _super.firstName;

    public final StringPath id = createString("id");

    //inherited
    public final StringPath lastName = _super.lastName;

    //inherited
    public final NumberPath<Integer> ssn = _super.ssn;

    public QPersonCustomCollection1(String variable) {
        super(PersonCustomCollection1.class, forVariable(variable));
    }

    public QPersonCustomCollection1(Path<? extends PersonCustomCollection1> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPersonCustomCollection1(PathMetadata metadata) {
        super(PersonCustomCollection1.class, metadata);
    }

}

