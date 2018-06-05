package org.springframework.data.mongodb.core;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QExecutableFindOperationSupportTests_Planet is a Querydsl query type for Planet
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QExecutableFindOperationSupportTests_Planet extends EntityPathBase<ExecutableFindOperationSupportTests.Planet> {

    private static final long serialVersionUID = -106090362L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QExecutableFindOperationSupportTests_Planet planet = new QExecutableFindOperationSupportTests_Planet("planet");

    public final org.springframework.data.geo.QPoint coordinates;

    public final StringPath name = createString("name");

    public QExecutableFindOperationSupportTests_Planet(String variable) {
        this(ExecutableFindOperationSupportTests.Planet.class, forVariable(variable), INITS);
    }

    public QExecutableFindOperationSupportTests_Planet(Path<? extends ExecutableFindOperationSupportTests.Planet> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QExecutableFindOperationSupportTests_Planet(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QExecutableFindOperationSupportTests_Planet(PathMetadata metadata, PathInits inits) {
        this(ExecutableFindOperationSupportTests.Planet.class, metadata, inits);
    }

    public QExecutableFindOperationSupportTests_Planet(Class<? extends ExecutableFindOperationSupportTests.Planet> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.coordinates = inits.isInitialized("coordinates") ? new org.springframework.data.geo.QPoint(forProperty("coordinates")) : null;
    }

}

