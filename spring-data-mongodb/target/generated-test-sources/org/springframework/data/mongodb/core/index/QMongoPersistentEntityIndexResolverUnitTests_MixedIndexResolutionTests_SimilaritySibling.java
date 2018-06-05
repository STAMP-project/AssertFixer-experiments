package org.springframework.data.mongodb.core.index;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_SimilaritySibling is a Querydsl query type for SimilaritySibling
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_SimilaritySibling extends BeanPath<MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.SimilaritySibling> {

    private static final long serialVersionUID = -617561086L;

    public static final QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_SimilaritySibling similaritySibling = new QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_SimilaritySibling("similaritySibling");

    public final StringPath similarThoughNotEqualNamedProperty = createString("similarThoughNotEqualNamedProperty");

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_SimilaritySibling(String variable) {
        super(MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.SimilaritySibling.class, forVariable(variable));
    }

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_SimilaritySibling(Path<? extends MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.SimilaritySibling> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_SimilaritySibling(PathMetadata metadata) {
        super(MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.SimilaritySibling.class, metadata);
    }

}

