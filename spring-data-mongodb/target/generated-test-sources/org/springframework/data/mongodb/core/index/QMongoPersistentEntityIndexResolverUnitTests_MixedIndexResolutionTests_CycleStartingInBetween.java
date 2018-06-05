package org.springframework.data.mongodb.core.index;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_CycleStartingInBetween is a Querydsl query type for CycleStartingInBetween
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_CycleStartingInBetween extends EntityPathBase<MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.CycleStartingInBetween> {

    private static final long serialVersionUID = -1652668742L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_CycleStartingInBetween cycleStartingInBetween = new QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_CycleStartingInBetween("cycleStartingInBetween");

    public final QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_CycleOnLevelOne referenceToCycleStart;

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_CycleStartingInBetween(String variable) {
        this(MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.CycleStartingInBetween.class, forVariable(variable), INITS);
    }

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_CycleStartingInBetween(Path<? extends MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.CycleStartingInBetween> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_CycleStartingInBetween(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_CycleStartingInBetween(PathMetadata metadata, PathInits inits) {
        this(MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.CycleStartingInBetween.class, metadata, inits);
    }

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_CycleStartingInBetween(Class<? extends MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.CycleStartingInBetween> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.referenceToCycleStart = inits.isInitialized("referenceToCycleStart") ? new QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_CycleOnLevelOne(forProperty("referenceToCycleStart"), inits.get("referenceToCycleStart")) : null;
    }

}

