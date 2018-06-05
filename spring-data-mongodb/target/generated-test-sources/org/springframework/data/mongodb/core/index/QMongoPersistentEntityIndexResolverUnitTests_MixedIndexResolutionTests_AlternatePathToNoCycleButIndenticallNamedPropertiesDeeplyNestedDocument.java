package org.springframework.data.mongodb.core.index;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_AlternatePathToNoCycleButIndenticallNamedPropertiesDeeplyNestedDocument is a Querydsl query type for AlternatePathToNoCycleButIndenticallNamedPropertiesDeeplyNestedDocument
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_AlternatePathToNoCycleButIndenticallNamedPropertiesDeeplyNestedDocument extends BeanPath<MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.AlternatePathToNoCycleButIndenticallNamedPropertiesDeeplyNestedDocument> {

    private static final long serialVersionUID = 2046204213L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_AlternatePathToNoCycleButIndenticallNamedPropertiesDeeplyNestedDocument alternatePathToNoCycleButIndenticallNamedPropertiesDeeplyNestedDocument = new QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_AlternatePathToNoCycleButIndenticallNamedPropertiesDeeplyNestedDocument("alternatePathToNoCycleButIndenticallNamedPropertiesDeeplyNestedDocument");

    public final QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_NoCycleButIndenticallNamedPropertiesDeeplyNested propertyWithIndexedStructure;

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_AlternatePathToNoCycleButIndenticallNamedPropertiesDeeplyNestedDocument(String variable) {
        this(MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.AlternatePathToNoCycleButIndenticallNamedPropertiesDeeplyNestedDocument.class, forVariable(variable), INITS);
    }

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_AlternatePathToNoCycleButIndenticallNamedPropertiesDeeplyNestedDocument(Path<? extends MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.AlternatePathToNoCycleButIndenticallNamedPropertiesDeeplyNestedDocument> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_AlternatePathToNoCycleButIndenticallNamedPropertiesDeeplyNestedDocument(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_AlternatePathToNoCycleButIndenticallNamedPropertiesDeeplyNestedDocument(PathMetadata metadata, PathInits inits) {
        this(MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.AlternatePathToNoCycleButIndenticallNamedPropertiesDeeplyNestedDocument.class, metadata, inits);
    }

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_AlternatePathToNoCycleButIndenticallNamedPropertiesDeeplyNestedDocument(Class<? extends MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.AlternatePathToNoCycleButIndenticallNamedPropertiesDeeplyNestedDocument> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.propertyWithIndexedStructure = inits.isInitialized("propertyWithIndexedStructure") ? new QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_NoCycleButIndenticallNamedPropertiesDeeplyNested(forProperty("propertyWithIndexedStructure")) : null;
    }

}

