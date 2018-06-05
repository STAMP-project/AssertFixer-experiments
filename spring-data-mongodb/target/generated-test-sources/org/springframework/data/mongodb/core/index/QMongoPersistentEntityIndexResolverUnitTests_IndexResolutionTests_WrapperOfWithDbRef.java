package org.springframework.data.mongodb.core.index;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMongoPersistentEntityIndexResolverUnitTests_IndexResolutionTests_WrapperOfWithDbRef is a Querydsl query type for WrapperOfWithDbRef
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMongoPersistentEntityIndexResolverUnitTests_IndexResolutionTests_WrapperOfWithDbRef extends EntityPathBase<MongoPersistentEntityIndexResolverUnitTests.IndexResolutionTests.WrapperOfWithDbRef> {

    private static final long serialVersionUID = 2076802211L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMongoPersistentEntityIndexResolverUnitTests_IndexResolutionTests_WrapperOfWithDbRef wrapperOfWithDbRef = new QMongoPersistentEntityIndexResolverUnitTests_IndexResolutionTests_WrapperOfWithDbRef("wrapperOfWithDbRef");

    public final QMongoPersistentEntityIndexResolverUnitTests_IndexResolutionTests_WithDbRef nested;

    public QMongoPersistentEntityIndexResolverUnitTests_IndexResolutionTests_WrapperOfWithDbRef(String variable) {
        this(MongoPersistentEntityIndexResolverUnitTests.IndexResolutionTests.WrapperOfWithDbRef.class, forVariable(variable), INITS);
    }

    public QMongoPersistentEntityIndexResolverUnitTests_IndexResolutionTests_WrapperOfWithDbRef(Path<? extends MongoPersistentEntityIndexResolverUnitTests.IndexResolutionTests.WrapperOfWithDbRef> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMongoPersistentEntityIndexResolverUnitTests_IndexResolutionTests_WrapperOfWithDbRef(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMongoPersistentEntityIndexResolverUnitTests_IndexResolutionTests_WrapperOfWithDbRef(PathMetadata metadata, PathInits inits) {
        this(MongoPersistentEntityIndexResolverUnitTests.IndexResolutionTests.WrapperOfWithDbRef.class, metadata, inits);
    }

    public QMongoPersistentEntityIndexResolverUnitTests_IndexResolutionTests_WrapperOfWithDbRef(Class<? extends MongoPersistentEntityIndexResolverUnitTests.IndexResolutionTests.WrapperOfWithDbRef> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.nested = inits.isInitialized("nested") ? new QMongoPersistentEntityIndexResolverUnitTests_IndexResolutionTests_WithDbRef(forProperty("nested"), inits.get("nested")) : null;
    }

}

