package org.springframework.data.mongodb.core.index;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_TypeWithNamedCompoundIndex is a Querydsl query type for TypeWithNamedCompoundIndex
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_TypeWithNamedCompoundIndex extends BeanPath<MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.TypeWithNamedCompoundIndex> {

    private static final long serialVersionUID = -45363157L;

    public static final QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_TypeWithNamedCompoundIndex typeWithNamedCompoundIndex = new QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_TypeWithNamedCompoundIndex("typeWithNamedCompoundIndex");

    public final StringPath property = createString("property");

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_TypeWithNamedCompoundIndex(String variable) {
        super(MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.TypeWithNamedCompoundIndex.class, forVariable(variable));
    }

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_TypeWithNamedCompoundIndex(Path<? extends MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.TypeWithNamedCompoundIndex> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_TypeWithNamedCompoundIndex(PathMetadata metadata) {
        super(MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.TypeWithNamedCompoundIndex.class, metadata);
    }

}

