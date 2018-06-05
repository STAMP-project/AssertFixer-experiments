package org.springframework.data.mongodb.core;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QReactiveFindOperationSupportTests_Planet is a Querydsl query type for Planet
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QReactiveFindOperationSupportTests_Planet extends EntityPathBase<ReactiveFindOperationSupportTests.Planet> {

    private static final long serialVersionUID = -804923211L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QReactiveFindOperationSupportTests_Planet planet = new QReactiveFindOperationSupportTests_Planet("planet");

    public final org.springframework.data.geo.QPoint coordinates;

    public final StringPath name = createString("name");

    public QReactiveFindOperationSupportTests_Planet(String variable) {
        this(ReactiveFindOperationSupportTests.Planet.class, forVariable(variable), INITS);
    }

    public QReactiveFindOperationSupportTests_Planet(Path<? extends ReactiveFindOperationSupportTests.Planet> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QReactiveFindOperationSupportTests_Planet(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QReactiveFindOperationSupportTests_Planet(PathMetadata metadata, PathInits inits) {
        this(ReactiveFindOperationSupportTests.Planet.class, metadata, inits);
    }

    public QReactiveFindOperationSupportTests_Planet(Class<? extends ReactiveFindOperationSupportTests.Planet> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.coordinates = inits.isInitialized("coordinates") ? new org.springframework.data.geo.QPoint(forProperty("coordinates")) : null;
    }

}

