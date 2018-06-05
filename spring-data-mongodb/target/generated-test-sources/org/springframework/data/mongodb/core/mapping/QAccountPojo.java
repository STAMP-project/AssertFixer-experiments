package org.springframework.data.mongodb.core.mapping;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QAccountPojo is a Querydsl query type for AccountPojo
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QAccountPojo extends BeanPath<AccountPojo> {

    private static final long serialVersionUID = 1567957979L;

    public static final QAccountPojo accountPojo = new QAccountPojo("accountPojo");

    public final NumberPath<Float> balance = createNumber("balance", Float.class);

    public final StringPath type = createString("type");

    public QAccountPojo(String variable) {
        super(AccountPojo.class, forVariable(variable));
    }

    public QAccountPojo(Path<? extends AccountPojo> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAccountPojo(PathMetadata metadata) {
        super(AccountPojo.class, metadata);
    }

}

