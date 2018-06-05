package org.springframework.data.mongodb.core.mapping;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QPersonMultiDimArrays is a Querydsl query type for PersonMultiDimArrays
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPersonMultiDimArrays extends EntityPathBase<PersonMultiDimArrays> {

    private static final long serialVersionUID = -1337107436L;

    public static final QPersonMultiDimArrays personMultiDimArrays = new QPersonMultiDimArrays("personMultiDimArrays");

    public final QBasePerson _super = new QBasePerson(this);

    //inherited
    public final StringPath firstName = _super.firstName;

    public final ArrayPath<String[][], String[]> grid = createArray("grid", String[][].class);

    public final StringPath id = createString("id");

    //inherited
    public final StringPath lastName = _super.lastName;

    //inherited
    public final NumberPath<Integer> ssn = _super.ssn;

    public QPersonMultiDimArrays(String variable) {
        super(PersonMultiDimArrays.class, forVariable(variable));
    }

    public QPersonMultiDimArrays(Path<? extends PersonMultiDimArrays> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPersonMultiDimArrays(PathMetadata metadata) {
        super(PersonMultiDimArrays.class, metadata);
    }

}

