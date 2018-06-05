package org.springframework.data.mongodb.core.index;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_DocumentWithNestedTypeHavingNamedIndex is a Querydsl query type for DocumentWithNestedTypeHavingNamedIndex
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_DocumentWithNestedTypeHavingNamedIndex extends EntityPathBase<MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.DocumentWithNestedTypeHavingNamedIndex> {

    private static final long serialVersionUID = 1657693613L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_DocumentWithNestedTypeHavingNamedIndex documentWithNestedTypeHavingNamedIndex = new QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_DocumentWithNestedTypeHavingNamedIndex("documentWithNestedTypeHavingNamedIndex");

    public final QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_TypeWithNamedIndex propertyOfTypeHavingNamedIndex;

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_DocumentWithNestedTypeHavingNamedIndex(String variable) {
        this(MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.DocumentWithNestedTypeHavingNamedIndex.class, forVariable(variable), INITS);
    }

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_DocumentWithNestedTypeHavingNamedIndex(Path<? extends MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.DocumentWithNestedTypeHavingNamedIndex> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_DocumentWithNestedTypeHavingNamedIndex(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_DocumentWithNestedTypeHavingNamedIndex(PathMetadata metadata, PathInits inits) {
        this(MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.DocumentWithNestedTypeHavingNamedIndex.class, metadata, inits);
    }

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_DocumentWithNestedTypeHavingNamedIndex(Class<? extends MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.DocumentWithNestedTypeHavingNamedIndex> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.propertyOfTypeHavingNamedIndex = inits.isInitialized("propertyOfTypeHavingNamedIndex") ? new QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_TypeWithNamedIndex(forProperty("propertyOfTypeHavingNamedIndex")) : null;
    }

}

