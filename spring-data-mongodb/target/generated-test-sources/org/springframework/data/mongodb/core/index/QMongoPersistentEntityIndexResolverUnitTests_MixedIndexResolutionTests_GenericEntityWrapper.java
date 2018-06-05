package org.springframework.data.mongodb.core.index;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_GenericEntityWrapper is a Querydsl query type for GenericEntityWrapper
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_GenericEntityWrapper extends BeanPath<MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.GenericEntityWrapper<?>> {

    private static final long serialVersionUID = -2062498282L;

    public static final QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_GenericEntityWrapper genericEntityWrapper = new QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_GenericEntityWrapper("genericEntityWrapper");

    public final SimplePath<Object> entity = createSimple("entity", Object.class);

    @SuppressWarnings({"all", "rawtypes", "unchecked"})
    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_GenericEntityWrapper(String variable) {
        super((Class) MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.GenericEntityWrapper.class, forVariable(variable));
    }

    @SuppressWarnings({"all", "rawtypes", "unchecked"})
    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_GenericEntityWrapper(Path<? extends MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.GenericEntityWrapper> path) {
        super((Class) path.getType(), path.getMetadata());
    }

    @SuppressWarnings({"all", "rawtypes", "unchecked"})
    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_GenericEntityWrapper(PathMetadata metadata) {
        super((Class) MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.GenericEntityWrapper.class, metadata);
    }

}

