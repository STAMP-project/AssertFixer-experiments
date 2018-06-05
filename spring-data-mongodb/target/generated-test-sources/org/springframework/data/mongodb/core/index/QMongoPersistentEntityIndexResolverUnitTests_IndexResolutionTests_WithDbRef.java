package org.springframework.data.mongodb.core.index;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMongoPersistentEntityIndexResolverUnitTests_IndexResolutionTests_WithDbRef is a Querydsl query type for WithDbRef
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMongoPersistentEntityIndexResolverUnitTests_IndexResolutionTests_WithDbRef extends EntityPathBase<MongoPersistentEntityIndexResolverUnitTests.IndexResolutionTests.WithDbRef> {

    private static final long serialVersionUID = 1900257041L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMongoPersistentEntityIndexResolverUnitTests_IndexResolutionTests_WithDbRef withDbRef = new QMongoPersistentEntityIndexResolverUnitTests_IndexResolutionTests_WithDbRef("withDbRef");

    public final QMongoPersistentEntityIndexResolverUnitTests_IndexResolutionTests_NoIndex indexedDbRef;

    public QMongoPersistentEntityIndexResolverUnitTests_IndexResolutionTests_WithDbRef(String variable) {
        this(MongoPersistentEntityIndexResolverUnitTests.IndexResolutionTests.WithDbRef.class, forVariable(variable), INITS);
    }

    public QMongoPersistentEntityIndexResolverUnitTests_IndexResolutionTests_WithDbRef(Path<? extends MongoPersistentEntityIndexResolverUnitTests.IndexResolutionTests.WithDbRef> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMongoPersistentEntityIndexResolverUnitTests_IndexResolutionTests_WithDbRef(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMongoPersistentEntityIndexResolverUnitTests_IndexResolutionTests_WithDbRef(PathMetadata metadata, PathInits inits) {
        this(MongoPersistentEntityIndexResolverUnitTests.IndexResolutionTests.WithDbRef.class, metadata, inits);
    }

    public QMongoPersistentEntityIndexResolverUnitTests_IndexResolutionTests_WithDbRef(Class<? extends MongoPersistentEntityIndexResolverUnitTests.IndexResolutionTests.WithDbRef> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.indexedDbRef = inits.isInitialized("indexedDbRef") ? new QMongoPersistentEntityIndexResolverUnitTests_IndexResolutionTests_NoIndex(forProperty("indexedDbRef")) : null;
    }

}

