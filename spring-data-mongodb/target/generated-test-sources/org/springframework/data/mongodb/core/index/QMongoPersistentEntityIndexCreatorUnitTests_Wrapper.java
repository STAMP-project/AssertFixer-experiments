package org.springframework.data.mongodb.core.index;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMongoPersistentEntityIndexCreatorUnitTests_Wrapper is a Querydsl query type for Wrapper
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMongoPersistentEntityIndexCreatorUnitTests_Wrapper extends EntityPathBase<MongoPersistentEntityIndexCreatorUnitTests.Wrapper> {

    private static final long serialVersionUID = -1122077172L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMongoPersistentEntityIndexCreatorUnitTests_Wrapper wrapper = new QMongoPersistentEntityIndexCreatorUnitTests_Wrapper("wrapper");

    public final QMongoPersistentEntityIndexCreatorUnitTests_Company company;

    public final StringPath id = createString("id");

    public QMongoPersistentEntityIndexCreatorUnitTests_Wrapper(String variable) {
        this(MongoPersistentEntityIndexCreatorUnitTests.Wrapper.class, forVariable(variable), INITS);
    }

    public QMongoPersistentEntityIndexCreatorUnitTests_Wrapper(Path<? extends MongoPersistentEntityIndexCreatorUnitTests.Wrapper> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMongoPersistentEntityIndexCreatorUnitTests_Wrapper(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMongoPersistentEntityIndexCreatorUnitTests_Wrapper(PathMetadata metadata, PathInits inits) {
        this(MongoPersistentEntityIndexCreatorUnitTests.Wrapper.class, metadata, inits);
    }

    public QMongoPersistentEntityIndexCreatorUnitTests_Wrapper(Class<? extends MongoPersistentEntityIndexCreatorUnitTests.Wrapper> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.company = inits.isInitialized("company") ? new QMongoPersistentEntityIndexCreatorUnitTests_Company(forProperty("company")) : null;
    }

}

