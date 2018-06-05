package org.springframework.data.mongodb.core.index;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_OuterDocumentReferingToIndexedPropertyViaDifferentNonCyclingPaths is a Querydsl query type for OuterDocumentReferingToIndexedPropertyViaDifferentNonCyclingPaths
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_OuterDocumentReferingToIndexedPropertyViaDifferentNonCyclingPaths extends EntityPathBase<MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.OuterDocumentReferingToIndexedPropertyViaDifferentNonCyclingPaths> {

    private static final long serialVersionUID = -1422618179L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_OuterDocumentReferingToIndexedPropertyViaDifferentNonCyclingPaths outerDocumentReferingToIndexedPropertyViaDifferentNonCyclingPaths = new QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_OuterDocumentReferingToIndexedPropertyViaDifferentNonCyclingPaths("outerDocumentReferingToIndexedPropertyViaDifferentNonCyclingPaths");

    public final QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_NoCycleButIndenticallNamedPropertiesDeeplyNested path1;

    public final QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_AlternatePathToNoCycleButIndenticallNamedPropertiesDeeplyNestedDocument path2;

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_OuterDocumentReferingToIndexedPropertyViaDifferentNonCyclingPaths(String variable) {
        this(MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.OuterDocumentReferingToIndexedPropertyViaDifferentNonCyclingPaths.class, forVariable(variable), INITS);
    }

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_OuterDocumentReferingToIndexedPropertyViaDifferentNonCyclingPaths(Path<? extends MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.OuterDocumentReferingToIndexedPropertyViaDifferentNonCyclingPaths> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_OuterDocumentReferingToIndexedPropertyViaDifferentNonCyclingPaths(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_OuterDocumentReferingToIndexedPropertyViaDifferentNonCyclingPaths(PathMetadata metadata, PathInits inits) {
        this(MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.OuterDocumentReferingToIndexedPropertyViaDifferentNonCyclingPaths.class, metadata, inits);
    }

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_OuterDocumentReferingToIndexedPropertyViaDifferentNonCyclingPaths(Class<? extends MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.OuterDocumentReferingToIndexedPropertyViaDifferentNonCyclingPaths> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.path1 = inits.isInitialized("path1") ? new QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_NoCycleButIndenticallNamedPropertiesDeeplyNested(forProperty("path1")) : null;
        this.path2 = inits.isInitialized("path2") ? new QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_AlternatePathToNoCycleButIndenticallNamedPropertiesDeeplyNestedDocument(forProperty("path2"), inits.get("path2")) : null;
    }

}

