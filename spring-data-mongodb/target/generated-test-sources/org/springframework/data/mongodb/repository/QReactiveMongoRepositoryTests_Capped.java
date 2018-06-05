package org.springframework.data.mongodb.repository;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QReactiveMongoRepositoryTests_Capped is a Querydsl query type for Capped
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QReactiveMongoRepositoryTests_Capped extends EntityPathBase<ReactiveMongoRepositoryTests.Capped> {

    private static final long serialVersionUID = 1558725988L;

    public static final QReactiveMongoRepositoryTests_Capped capped = new QReactiveMongoRepositoryTests_Capped("capped");

    public final StringPath id = createString("id");

    public final StringPath key = createString("key");

    public final NumberPath<Double> random = createNumber("random", Double.class);

    public QReactiveMongoRepositoryTests_Capped(String variable) {
        super(ReactiveMongoRepositoryTests.Capped.class, forVariable(variable));
    }

    public QReactiveMongoRepositoryTests_Capped(Path<? extends ReactiveMongoRepositoryTests.Capped> path) {
        super(path.getType(), path.getMetadata());
    }

    public QReactiveMongoRepositoryTests_Capped(PathMetadata metadata) {
        super(ReactiveMongoRepositoryTests.Capped.class, metadata);
    }

}

