package org.springframework.data.mongodb.core.index;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_DocumentWithNestedDocumentHavingNamedCompoundIndex is a Querydsl query type for DocumentWithNestedDocumentHavingNamedCompoundIndex
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_DocumentWithNestedDocumentHavingNamedCompoundIndex extends EntityPathBase<MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.DocumentWithNestedDocumentHavingNamedCompoundIndex> {

    private static final long serialVersionUID = 2040578083L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_DocumentWithNestedDocumentHavingNamedCompoundIndex documentWithNestedDocumentHavingNamedCompoundIndex = new QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_DocumentWithNestedDocumentHavingNamedCompoundIndex("documentWithNestedDocumentHavingNamedCompoundIndex");

    public final QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_DocumentWithNamedCompoundIndex propertyOfTypeHavingNamedCompoundIndex;

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_DocumentWithNestedDocumentHavingNamedCompoundIndex(String variable) {
        this(MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.DocumentWithNestedDocumentHavingNamedCompoundIndex.class, forVariable(variable), INITS);
    }

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_DocumentWithNestedDocumentHavingNamedCompoundIndex(Path<? extends MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.DocumentWithNestedDocumentHavingNamedCompoundIndex> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_DocumentWithNestedDocumentHavingNamedCompoundIndex(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_DocumentWithNestedDocumentHavingNamedCompoundIndex(PathMetadata metadata, PathInits inits) {
        this(MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.DocumentWithNestedDocumentHavingNamedCompoundIndex.class, metadata, inits);
    }

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_DocumentWithNestedDocumentHavingNamedCompoundIndex(Class<? extends MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.DocumentWithNestedDocumentHavingNamedCompoundIndex> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.propertyOfTypeHavingNamedCompoundIndex = inits.isInitialized("propertyOfTypeHavingNamedCompoundIndex") ? new QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_DocumentWithNamedCompoundIndex(forProperty("propertyOfTypeHavingNamedCompoundIndex")) : null;
    }

}

