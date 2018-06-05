package org.springframework.data.mongodb.core;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QClientSessionTests_SomeDoc is a Querydsl query type for SomeDoc
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QClientSessionTests_SomeDoc extends EntityPathBase<ClientSessionTests.SomeDoc> {

    private static final long serialVersionUID = 990075202L;

    public static final QClientSessionTests_SomeDoc someDoc = new QClientSessionTests_SomeDoc("someDoc");

    public final StringPath id = createString("id");

    public final StringPath value = createString("value");

    public QClientSessionTests_SomeDoc(String variable) {
        super(ClientSessionTests.SomeDoc.class, forVariable(variable));
    }

    public QClientSessionTests_SomeDoc(Path<? extends ClientSessionTests.SomeDoc> path) {
        super(path.getType(), path.getMetadata());
    }

    public QClientSessionTests_SomeDoc(PathMetadata metadata) {
        super(ClientSessionTests.SomeDoc.class, metadata);
    }

}

