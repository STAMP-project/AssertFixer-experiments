package org.springframework.data.mongodb.core.index;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_MultipleObjectsOfSameType is a Querydsl query type for MultipleObjectsOfSameType
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_MultipleObjectsOfSameType extends EntityPathBase<MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.MultipleObjectsOfSameType> {

    private static final long serialVersionUID = -519979426L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_MultipleObjectsOfSameType multipleObjectsOfSameType = new QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_MultipleObjectsOfSameType("multipleObjectsOfSameType");

    public final QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_SelfCyclingViaCollectionType cycleOne;

    public final QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_SelfCyclingViaCollectionType cycleTwo;

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_MultipleObjectsOfSameType(String variable) {
        this(MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.MultipleObjectsOfSameType.class, forVariable(variable), INITS);
    }

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_MultipleObjectsOfSameType(Path<? extends MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.MultipleObjectsOfSameType> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_MultipleObjectsOfSameType(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_MultipleObjectsOfSameType(PathMetadata metadata, PathInits inits) {
        this(MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.MultipleObjectsOfSameType.class, metadata, inits);
    }

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_MultipleObjectsOfSameType(Class<? extends MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.MultipleObjectsOfSameType> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.cycleOne = inits.isInitialized("cycleOne") ? new QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_SelfCyclingViaCollectionType(forProperty("cycleOne")) : null;
        this.cycleTwo = inits.isInitialized("cycleTwo") ? new QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_SelfCyclingViaCollectionType(forProperty("cycleTwo")) : null;
    }

}

