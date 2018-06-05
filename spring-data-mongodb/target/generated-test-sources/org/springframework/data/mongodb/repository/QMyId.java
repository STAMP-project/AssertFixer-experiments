package org.springframework.data.mongodb.repository;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMyId is a Querydsl query type for MyId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QMyId extends BeanPath<MyId> {

    private static final long serialVersionUID = 1495015794L;

    public static final QMyId myId = new QMyId("myId");

    public final StringPath val1 = createString("val1");

    public final StringPath val2 = createString("val2");

    public QMyId(String variable) {
        super(MyId.class, forVariable(variable));
    }

    public QMyId(Path<? extends MyId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMyId(PathMetadata metadata) {
        super(MyId.class, metadata);
    }

}

