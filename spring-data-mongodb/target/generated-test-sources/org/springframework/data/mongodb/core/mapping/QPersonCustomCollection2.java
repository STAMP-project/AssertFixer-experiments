package org.springframework.data.mongodb.core.mapping;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QPersonCustomCollection2 is a Querydsl query type for PersonCustomCollection2
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPersonCustomCollection2 extends EntityPathBase<PersonCustomCollection2> {

    private static final long serialVersionUID = 899180504L;

    public static final QPersonCustomCollection2 personCustomCollection2 = new QPersonCustomCollection2("personCustomCollection2");

    public final QBasePerson _super = new QBasePerson(this);

    //inherited
    public final StringPath firstName = _super.firstName;

    public final StringPath id = createString("id");

    //inherited
    public final StringPath lastName = _super.lastName;

    //inherited
    public final NumberPath<Integer> ssn = _super.ssn;

    public QPersonCustomCollection2(String variable) {
        super(PersonCustomCollection2.class, forVariable(variable));
    }

    public QPersonCustomCollection2(Path<? extends PersonCustomCollection2> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPersonCustomCollection2(PathMetadata metadata) {
        super(PersonCustomCollection2.class, metadata);
    }

}

