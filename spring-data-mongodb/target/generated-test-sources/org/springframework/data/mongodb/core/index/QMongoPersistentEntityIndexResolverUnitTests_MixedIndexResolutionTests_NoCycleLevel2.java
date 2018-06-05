package org.springframework.data.mongodb.core.index;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_NoCycleLevel2 is a Querydsl query type for NoCycleLevel2
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_NoCycleLevel2 extends BeanPath<MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.NoCycleLevel2> {

    private static final long serialVersionUID = -1429112746L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_NoCycleLevel2 noCycleLevel2 = new QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_NoCycleLevel2("noCycleLevel2");

    public final QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_NoCycleLevel3 l3;

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_NoCycleLevel2(String variable) {
        this(MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.NoCycleLevel2.class, forVariable(variable), INITS);
    }

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_NoCycleLevel2(Path<? extends MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.NoCycleLevel2> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_NoCycleLevel2(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_NoCycleLevel2(PathMetadata metadata, PathInits inits) {
        this(MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.NoCycleLevel2.class, metadata, inits);
    }

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_NoCycleLevel2(Class<? extends MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.NoCycleLevel2> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.l3 = inits.isInitialized("l3") ? new QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_NoCycleLevel3(forProperty("l3")) : null;
    }

}

