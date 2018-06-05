package org.springframework.data.mongodb.core.index;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_NoCycleManyPathsToDeepValueObject is a Querydsl query type for NoCycleManyPathsToDeepValueObject
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_NoCycleManyPathsToDeepValueObject extends EntityPathBase<MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.NoCycleManyPathsToDeepValueObject> {

    private static final long serialVersionUID = 202871970L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_NoCycleManyPathsToDeepValueObject noCycleManyPathsToDeepValueObject = new QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_NoCycleManyPathsToDeepValueObject("noCycleManyPathsToDeepValueObject");

    public final QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_NoCycleLevel2 l2;

    public final QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_NoCycleLevel3 l3;

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_NoCycleManyPathsToDeepValueObject(String variable) {
        this(MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.NoCycleManyPathsToDeepValueObject.class, forVariable(variable), INITS);
    }

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_NoCycleManyPathsToDeepValueObject(Path<? extends MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.NoCycleManyPathsToDeepValueObject> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_NoCycleManyPathsToDeepValueObject(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_NoCycleManyPathsToDeepValueObject(PathMetadata metadata, PathInits inits) {
        this(MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.NoCycleManyPathsToDeepValueObject.class, metadata, inits);
    }

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_NoCycleManyPathsToDeepValueObject(Class<? extends MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.NoCycleManyPathsToDeepValueObject> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.l2 = inits.isInitialized("l2") ? new QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_NoCycleLevel2(forProperty("l2"), inits.get("l2")) : null;
        this.l3 = inits.isInitialized("l3") ? new QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_NoCycleLevel3(forProperty("l3")) : null;
    }

}

