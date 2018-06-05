package org.springframework.data.mongodb.core.index;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_CycleOnLevelOneReferenced is a Querydsl query type for CycleOnLevelOneReferenced
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_CycleOnLevelOneReferenced extends BeanPath<MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.CycleOnLevelOneReferenced> {

    private static final long serialVersionUID = 291931459L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_CycleOnLevelOneReferenced cycleOnLevelOneReferenced = new QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_CycleOnLevelOneReferenced("cycleOnLevelOneReferenced");

    public final QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_CycleOnLevelOne cyclicReference;

    public final StringPath indexedProperty = createString("indexedProperty");

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_CycleOnLevelOneReferenced(String variable) {
        this(MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.CycleOnLevelOneReferenced.class, forVariable(variable), INITS);
    }

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_CycleOnLevelOneReferenced(Path<? extends MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.CycleOnLevelOneReferenced> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_CycleOnLevelOneReferenced(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_CycleOnLevelOneReferenced(PathMetadata metadata, PathInits inits) {
        this(MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.CycleOnLevelOneReferenced.class, metadata, inits);
    }

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_CycleOnLevelOneReferenced(Class<? extends MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.CycleOnLevelOneReferenced> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.cyclicReference = inits.isInitialized("cyclicReference") ? new QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_CycleOnLevelOne(forProperty("cyclicReference"), inits.get("cyclicReference")) : null;
    }

}

