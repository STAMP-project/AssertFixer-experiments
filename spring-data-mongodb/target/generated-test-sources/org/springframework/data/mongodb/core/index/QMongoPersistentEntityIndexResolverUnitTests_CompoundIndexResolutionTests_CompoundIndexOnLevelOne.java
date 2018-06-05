package org.springframework.data.mongodb.core.index;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMongoPersistentEntityIndexResolverUnitTests_CompoundIndexResolutionTests_CompoundIndexOnLevelOne is a Querydsl query type for CompoundIndexOnLevelOne
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMongoPersistentEntityIndexResolverUnitTests_CompoundIndexResolutionTests_CompoundIndexOnLevelOne extends EntityPathBase<MongoPersistentEntityIndexResolverUnitTests.CompoundIndexResolutionTests.CompoundIndexOnLevelOne> {

    private static final long serialVersionUID = 1944003157L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMongoPersistentEntityIndexResolverUnitTests_CompoundIndexResolutionTests_CompoundIndexOnLevelOne compoundIndexOnLevelOne = new QMongoPersistentEntityIndexResolverUnitTests_CompoundIndexResolutionTests_CompoundIndexOnLevelOne("compoundIndexOnLevelOne");

    public final QMongoPersistentEntityIndexResolverUnitTests_CompoundIndexResolutionTests_CompoundIndexOnLevelZero zero;

    public QMongoPersistentEntityIndexResolverUnitTests_CompoundIndexResolutionTests_CompoundIndexOnLevelOne(String variable) {
        this(MongoPersistentEntityIndexResolverUnitTests.CompoundIndexResolutionTests.CompoundIndexOnLevelOne.class, forVariable(variable), INITS);
    }

    public QMongoPersistentEntityIndexResolverUnitTests_CompoundIndexResolutionTests_CompoundIndexOnLevelOne(Path<? extends MongoPersistentEntityIndexResolverUnitTests.CompoundIndexResolutionTests.CompoundIndexOnLevelOne> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMongoPersistentEntityIndexResolverUnitTests_CompoundIndexResolutionTests_CompoundIndexOnLevelOne(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMongoPersistentEntityIndexResolverUnitTests_CompoundIndexResolutionTests_CompoundIndexOnLevelOne(PathMetadata metadata, PathInits inits) {
        this(MongoPersistentEntityIndexResolverUnitTests.CompoundIndexResolutionTests.CompoundIndexOnLevelOne.class, metadata, inits);
    }

    public QMongoPersistentEntityIndexResolverUnitTests_CompoundIndexResolutionTests_CompoundIndexOnLevelOne(Class<? extends MongoPersistentEntityIndexResolverUnitTests.CompoundIndexResolutionTests.CompoundIndexOnLevelOne> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.zero = inits.isInitialized("zero") ? new QMongoPersistentEntityIndexResolverUnitTests_CompoundIndexResolutionTests_CompoundIndexOnLevelZero(forProperty("zero")) : null;
    }

}

