package org.springframework.data.mongodb.core.index;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMongoPersistentEntityIndexResolverUnitTests_IndexResolutionTests_NoIndex is a Querydsl query type for NoIndex
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMongoPersistentEntityIndexResolverUnitTests_IndexResolutionTests_NoIndex extends EntityPathBase<MongoPersistentEntityIndexResolverUnitTests.IndexResolutionTests.NoIndex> {

    private static final long serialVersionUID = 1085254931L;

    public static final QMongoPersistentEntityIndexResolverUnitTests_IndexResolutionTests_NoIndex noIndex = new QMongoPersistentEntityIndexResolverUnitTests_IndexResolutionTests_NoIndex("noIndex");

    public final StringPath id = createString("id");

    public QMongoPersistentEntityIndexResolverUnitTests_IndexResolutionTests_NoIndex(String variable) {
        super(MongoPersistentEntityIndexResolverUnitTests.IndexResolutionTests.NoIndex.class, forVariable(variable));
    }

    public QMongoPersistentEntityIndexResolverUnitTests_IndexResolutionTests_NoIndex(Path<? extends MongoPersistentEntityIndexResolverUnitTests.IndexResolutionTests.NoIndex> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMongoPersistentEntityIndexResolverUnitTests_IndexResolutionTests_NoIndex(PathMetadata metadata) {
        super(MongoPersistentEntityIndexResolverUnitTests.IndexResolutionTests.NoIndex.class, metadata);
    }

}

