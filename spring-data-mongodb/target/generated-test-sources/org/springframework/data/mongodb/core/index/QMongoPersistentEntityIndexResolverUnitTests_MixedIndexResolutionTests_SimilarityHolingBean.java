package org.springframework.data.mongodb.core.index;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_SimilarityHolingBean is a Querydsl query type for SimilarityHolingBean
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_SimilarityHolingBean extends EntityPathBase<MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.SimilarityHolingBean> {

    private static final long serialVersionUID = -494158451L;

    public static final QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_SimilarityHolingBean similarityHolingBean = new QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_SimilarityHolingBean("similarityHolingBean");

    public final ListPath<MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.SimilaritySibling, QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_SimilaritySibling> listOfSimilarilyNamedEntities = this.<MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.SimilaritySibling, QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_SimilaritySibling>createList("listOfSimilarilyNamedEntities", MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.SimilaritySibling.class, QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_SimilaritySibling.class, PathInits.DIRECT2);

    public final StringPath normalProperty = createString("normalProperty");

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_SimilarityHolingBean(String variable) {
        super(MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.SimilarityHolingBean.class, forVariable(variable));
    }

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_SimilarityHolingBean(Path<? extends MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.SimilarityHolingBean> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_SimilarityHolingBean(PathMetadata metadata) {
        super(MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.SimilarityHolingBean.class, metadata);
    }

}

