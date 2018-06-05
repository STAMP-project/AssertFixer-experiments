package org.springframework.data.mongodb.core.index;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_DocumentWithNestedDocumentHavingNamedIndex is a Querydsl query type for DocumentWithNestedDocumentHavingNamedIndex
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_DocumentWithNestedDocumentHavingNamedIndex extends EntityPathBase<MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.DocumentWithNestedDocumentHavingNamedIndex> {

    private static final long serialVersionUID = 1100489486L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_DocumentWithNestedDocumentHavingNamedIndex documentWithNestedDocumentHavingNamedIndex = new QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_DocumentWithNestedDocumentHavingNamedIndex("documentWithNestedDocumentHavingNamedIndex");

    public final QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_DocumentWithNamedIndex propertyOfTypeHavingNamedIndex;

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_DocumentWithNestedDocumentHavingNamedIndex(String variable) {
        this(MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.DocumentWithNestedDocumentHavingNamedIndex.class, forVariable(variable), INITS);
    }

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_DocumentWithNestedDocumentHavingNamedIndex(Path<? extends MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.DocumentWithNestedDocumentHavingNamedIndex> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_DocumentWithNestedDocumentHavingNamedIndex(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_DocumentWithNestedDocumentHavingNamedIndex(PathMetadata metadata, PathInits inits) {
        this(MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.DocumentWithNestedDocumentHavingNamedIndex.class, metadata, inits);
    }

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_DocumentWithNestedDocumentHavingNamedIndex(Class<? extends MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.DocumentWithNestedDocumentHavingNamedIndex> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.propertyOfTypeHavingNamedIndex = inits.isInitialized("propertyOfTypeHavingNamedIndex") ? new QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_DocumentWithNamedIndex(forProperty("propertyOfTypeHavingNamedIndex")) : null;
    }

}

