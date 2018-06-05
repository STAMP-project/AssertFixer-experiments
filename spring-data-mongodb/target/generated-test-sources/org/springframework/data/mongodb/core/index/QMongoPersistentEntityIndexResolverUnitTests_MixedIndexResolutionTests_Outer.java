package org.springframework.data.mongodb.core.index;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_Outer is a Querydsl query type for Outer
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_Outer extends EntityPathBase<MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.Outer> {

    private static final long serialVersionUID = 848342686L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_Outer outer = new QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_Outer("outer");

    public final QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_Inner inner;

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_Outer(String variable) {
        this(MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.Outer.class, forVariable(variable), INITS);
    }

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_Outer(Path<? extends MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.Outer> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_Outer(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_Outer(PathMetadata metadata, PathInits inits) {
        this(MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.Outer.class, metadata, inits);
    }

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_Outer(Class<? extends MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.Outer> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.inner = inits.isInitialized("inner") ? new QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_Inner(forProperty("inner"), inits.get("inner")) : null;
    }

}

