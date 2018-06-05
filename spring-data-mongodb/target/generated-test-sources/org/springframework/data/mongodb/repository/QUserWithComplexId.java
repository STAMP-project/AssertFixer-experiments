package org.springframework.data.mongodb.repository;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserWithComplexId is a Querydsl query type for UserWithComplexId
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUserWithComplexId extends EntityPathBase<UserWithComplexId> {

    private static final long serialVersionUID = -103298545L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUserWithComplexId userWithComplexId = new QUserWithComplexId("userWithComplexId");

    public final StringPath firstname = createString("firstname");

    public final QMyId id;

    public QUserWithComplexId(String variable) {
        this(UserWithComplexId.class, forVariable(variable), INITS);
    }

    public QUserWithComplexId(Path<? extends UserWithComplexId> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUserWithComplexId(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUserWithComplexId(PathMetadata metadata, PathInits inits) {
        this(UserWithComplexId.class, metadata, inits);
    }

    public QUserWithComplexId(Class<? extends UserWithComplexId> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.id = inits.isInitialized("id") ? new QMyId(forProperty("id")) : null;
    }

}

