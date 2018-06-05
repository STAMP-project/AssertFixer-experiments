package org.springframework.data.mongodb.core.index;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_TypeWithNamedIndex is a Querydsl query type for TypeWithNamedIndex
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_TypeWithNamedIndex extends BeanPath<MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.TypeWithNamedIndex> {

    private static final long serialVersionUID = -1875395818L;

    public static final QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_TypeWithNamedIndex typeWithNamedIndex = new QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_TypeWithNamedIndex("typeWithNamedIndex");

    public final StringPath property = createString("property");

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_TypeWithNamedIndex(String variable) {
        super(MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.TypeWithNamedIndex.class, forVariable(variable));
    }

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_TypeWithNamedIndex(Path<? extends MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.TypeWithNamedIndex> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_TypeWithNamedIndex(PathMetadata metadata) {
        super(MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.TypeWithNamedIndex.class, metadata);
    }

}

