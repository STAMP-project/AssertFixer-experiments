package org.springframework.data.mongodb.core.mapping;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QBasePerson is a Querydsl query type for BasePerson
 */
@Generated("com.querydsl.codegen.SupertypeSerializer")
public class QBasePerson extends EntityPathBase<BasePerson> {

    private static final long serialVersionUID = 2014660540L;

    public static final QBasePerson basePerson = new QBasePerson("basePerson");

    public final StringPath firstName = createString("firstName");

    public final StringPath lastName = createString("lastName");

    public final NumberPath<Integer> ssn = createNumber("ssn", Integer.class);

    public QBasePerson(String variable) {
        super(BasePerson.class, forVariable(variable));
    }

    public QBasePerson(Path<? extends BasePerson> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBasePerson(PathMetadata metadata) {
        super(BasePerson.class, metadata);
    }

}

