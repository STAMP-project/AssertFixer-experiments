package org.springframework.data.mongodb.core.index;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_NoCycleButIdenticallyNamedProperties is a Querydsl query type for NoCycleButIdenticallyNamedProperties
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_NoCycleButIdenticallyNamedProperties extends EntityPathBase<MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.NoCycleButIdenticallyNamedProperties> {

    private static final long serialVersionUID = 76473123L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_NoCycleButIdenticallyNamedProperties noCycleButIdenticallyNamedProperties = new QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_NoCycleButIdenticallyNamedProperties("noCycleButIdenticallyNamedProperties");

    public final StringPath foo = createString("foo");

    public final QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_NoCycleButIdenticallyNamedPropertiesNested reference;

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_NoCycleButIdenticallyNamedProperties(String variable) {
        this(MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.NoCycleButIdenticallyNamedProperties.class, forVariable(variable), INITS);
    }

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_NoCycleButIdenticallyNamedProperties(Path<? extends MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.NoCycleButIdenticallyNamedProperties> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_NoCycleButIdenticallyNamedProperties(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_NoCycleButIdenticallyNamedProperties(PathMetadata metadata, PathInits inits) {
        this(MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.NoCycleButIdenticallyNamedProperties.class, metadata, inits);
    }

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_NoCycleButIdenticallyNamedProperties(Class<? extends MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.NoCycleButIdenticallyNamedProperties> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.reference = inits.isInitialized("reference") ? new QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_NoCycleButIdenticallyNamedPropertiesNested(forProperty("reference"), inits.get("reference")) : null;
    }

}

