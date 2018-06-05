package org.springframework.data.mongodb.core.index;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_SelfCyclingViaCollectionType is a Querydsl query type for SelfCyclingViaCollectionType
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_SelfCyclingViaCollectionType extends EntityPathBase<MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.SelfCyclingViaCollectionType> {

    private static final long serialVersionUID = 1117927084L;

    public static final QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_SelfCyclingViaCollectionType selfCyclingViaCollectionType = new QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_SelfCyclingViaCollectionType("selfCyclingViaCollectionType");

    public final ListPath<MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.SelfCyclingViaCollectionType, QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_SelfCyclingViaCollectionType> cyclic = this.<MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.SelfCyclingViaCollectionType, QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_SelfCyclingViaCollectionType>createList("cyclic", MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.SelfCyclingViaCollectionType.class, QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_SelfCyclingViaCollectionType.class, PathInits.DIRECT2);

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_SelfCyclingViaCollectionType(String variable) {
        super(MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.SelfCyclingViaCollectionType.class, forVariable(variable));
    }

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_SelfCyclingViaCollectionType(Path<? extends MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.SelfCyclingViaCollectionType> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_SelfCyclingViaCollectionType(PathMetadata metadata) {
        super(MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.SelfCyclingViaCollectionType.class, metadata);
    }

}

