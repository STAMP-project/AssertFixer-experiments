package org.springframework.data.mongodb.core.index;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_NoCycleButIndenticallNamedPropertiesDeeplyNested is a Querydsl query type for NoCycleButIndenticallNamedPropertiesDeeplyNested
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_NoCycleButIndenticallNamedPropertiesDeeplyNested extends BeanPath<MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.NoCycleButIndenticallNamedPropertiesDeeplyNested> {

    private static final long serialVersionUID = -1771945766L;

    public static final QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_NoCycleButIndenticallNamedPropertiesDeeplyNested noCycleButIndenticallNamedPropertiesDeeplyNested = new QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_NoCycleButIndenticallNamedPropertiesDeeplyNested("noCycleButIndenticallNamedPropertiesDeeplyNested");

    public final StringPath foo = createString("foo");

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_NoCycleButIndenticallNamedPropertiesDeeplyNested(String variable) {
        super(MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.NoCycleButIndenticallNamedPropertiesDeeplyNested.class, forVariable(variable));
    }

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_NoCycleButIndenticallNamedPropertiesDeeplyNested(Path<? extends MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.NoCycleButIndenticallNamedPropertiesDeeplyNested> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_NoCycleButIndenticallNamedPropertiesDeeplyNested(PathMetadata metadata) {
        super(MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.NoCycleButIndenticallNamedPropertiesDeeplyNested.class, metadata);
    }

}

