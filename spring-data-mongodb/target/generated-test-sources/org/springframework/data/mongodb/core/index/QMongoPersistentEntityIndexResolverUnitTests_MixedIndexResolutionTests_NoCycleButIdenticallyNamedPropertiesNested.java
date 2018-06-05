package org.springframework.data.mongodb.core.index;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_NoCycleButIdenticallyNamedPropertiesNested is a Querydsl query type for NoCycleButIdenticallyNamedPropertiesNested
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_NoCycleButIdenticallyNamedPropertiesNested extends BeanPath<MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.NoCycleButIdenticallyNamedPropertiesNested> {

    private static final long serialVersionUID = -822998534L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_NoCycleButIdenticallyNamedPropertiesNested noCycleButIdenticallyNamedPropertiesNested = new QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_NoCycleButIdenticallyNamedPropertiesNested("noCycleButIdenticallyNamedPropertiesNested");

    public final QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_NoCycleButIndenticallNamedPropertiesDeeplyNested deep;

    public final StringPath foo = createString("foo");

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_NoCycleButIdenticallyNamedPropertiesNested(String variable) {
        this(MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.NoCycleButIdenticallyNamedPropertiesNested.class, forVariable(variable), INITS);
    }

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_NoCycleButIdenticallyNamedPropertiesNested(Path<? extends MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.NoCycleButIdenticallyNamedPropertiesNested> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_NoCycleButIdenticallyNamedPropertiesNested(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_NoCycleButIdenticallyNamedPropertiesNested(PathMetadata metadata, PathInits inits) {
        this(MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.NoCycleButIdenticallyNamedPropertiesNested.class, metadata, inits);
    }

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_NoCycleButIdenticallyNamedPropertiesNested(Class<? extends MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.NoCycleButIdenticallyNamedPropertiesNested> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.deep = inits.isInitialized("deep") ? new QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_NoCycleButIndenticallNamedPropertiesDeeplyNested(forProperty("deep")) : null;
    }

}

