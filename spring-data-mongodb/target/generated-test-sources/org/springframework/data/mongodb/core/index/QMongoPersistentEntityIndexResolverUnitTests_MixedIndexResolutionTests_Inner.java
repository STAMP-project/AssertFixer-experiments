package org.springframework.data.mongodb.core.index;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_Inner is a Querydsl query type for Inner
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_Inner extends EntityPathBase<MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.Inner> {

    private static final long serialVersionUID = 842587257L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_Inner inner = new QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_Inner("inner");

    public final QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_Outer outer;

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_Inner(String variable) {
        this(MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.Inner.class, forVariable(variable), INITS);
    }

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_Inner(Path<? extends MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.Inner> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_Inner(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_Inner(PathMetadata metadata, PathInits inits) {
        this(MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.Inner.class, metadata, inits);
    }

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_Inner(Class<? extends MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.Inner> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.outer = inits.isInitialized("outer") ? new QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_Outer(forProperty("outer"), inits.get("outer")) : null;
    }

}

