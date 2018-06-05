package org.springframework.data.mongodb.core.index;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_CycleOnLevelOne is a Querydsl query type for CycleOnLevelOne
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_CycleOnLevelOne extends EntityPathBase<MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.CycleOnLevelOne> {

    private static final long serialVersionUID = 1389128490L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_CycleOnLevelOne cycleOnLevelOne = new QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_CycleOnLevelOne("cycleOnLevelOne");

    public final QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_CycleOnLevelOneReferenced reference;

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_CycleOnLevelOne(String variable) {
        this(MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.CycleOnLevelOne.class, forVariable(variable), INITS);
    }

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_CycleOnLevelOne(Path<? extends MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.CycleOnLevelOne> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_CycleOnLevelOne(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_CycleOnLevelOne(PathMetadata metadata, PathInits inits) {
        this(MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.CycleOnLevelOne.class, metadata, inits);
    }

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_CycleOnLevelOne(Class<? extends MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.CycleOnLevelOne> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.reference = inits.isInitialized("reference") ? new QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_CycleOnLevelOneReferenced(forProperty("reference"), inits.get("reference")) : null;
    }

}

