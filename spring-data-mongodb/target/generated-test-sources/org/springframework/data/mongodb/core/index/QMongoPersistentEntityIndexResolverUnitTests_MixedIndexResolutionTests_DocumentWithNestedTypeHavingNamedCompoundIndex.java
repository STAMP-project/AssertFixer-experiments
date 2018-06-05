package org.springframework.data.mongodb.core.index;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_DocumentWithNestedTypeHavingNamedCompoundIndex is a Querydsl query type for DocumentWithNestedTypeHavingNamedCompoundIndex
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_DocumentWithNestedTypeHavingNamedCompoundIndex extends EntityPathBase<MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.DocumentWithNestedTypeHavingNamedCompoundIndex> {

    private static final long serialVersionUID = -1074400318L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_DocumentWithNestedTypeHavingNamedCompoundIndex documentWithNestedTypeHavingNamedCompoundIndex = new QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_DocumentWithNestedTypeHavingNamedCompoundIndex("documentWithNestedTypeHavingNamedCompoundIndex");

    public final QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_TypeWithNamedCompoundIndex propertyOfTypeHavingNamedCompoundIndex;

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_DocumentWithNestedTypeHavingNamedCompoundIndex(String variable) {
        this(MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.DocumentWithNestedTypeHavingNamedCompoundIndex.class, forVariable(variable), INITS);
    }

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_DocumentWithNestedTypeHavingNamedCompoundIndex(Path<? extends MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.DocumentWithNestedTypeHavingNamedCompoundIndex> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_DocumentWithNestedTypeHavingNamedCompoundIndex(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_DocumentWithNestedTypeHavingNamedCompoundIndex(PathMetadata metadata, PathInits inits) {
        this(MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.DocumentWithNestedTypeHavingNamedCompoundIndex.class, metadata, inits);
    }

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_DocumentWithNestedTypeHavingNamedCompoundIndex(Class<? extends MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.DocumentWithNestedTypeHavingNamedCompoundIndex> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.propertyOfTypeHavingNamedCompoundIndex = inits.isInitialized("propertyOfTypeHavingNamedCompoundIndex") ? new QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_TypeWithNamedCompoundIndex(forProperty("propertyOfTypeHavingNamedCompoundIndex")) : null;
    }

}

