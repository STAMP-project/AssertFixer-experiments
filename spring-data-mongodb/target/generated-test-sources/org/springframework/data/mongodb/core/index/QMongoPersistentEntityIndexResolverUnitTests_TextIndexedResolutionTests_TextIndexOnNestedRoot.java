package org.springframework.data.mongodb.core.index;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMongoPersistentEntityIndexResolverUnitTests_TextIndexedResolutionTests_TextIndexOnNestedRoot is a Querydsl query type for TextIndexOnNestedRoot
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMongoPersistentEntityIndexResolverUnitTests_TextIndexedResolutionTests_TextIndexOnNestedRoot extends EntityPathBase<MongoPersistentEntityIndexResolverUnitTests.TextIndexedResolutionTests.TextIndexOnNestedRoot> {

    private static final long serialVersionUID = 1044832077L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMongoPersistentEntityIndexResolverUnitTests_TextIndexedResolutionTests_TextIndexOnNestedRoot textIndexOnNestedRoot = new QMongoPersistentEntityIndexResolverUnitTests_TextIndexedResolutionTests_TextIndexOnNestedRoot("textIndexOnNestedRoot");

    public final StringPath bar = createString("bar");

    public final QMongoPersistentEntityIndexResolverUnitTests_TextIndexedResolutionTests_TextIndexOnNested nested;

    public QMongoPersistentEntityIndexResolverUnitTests_TextIndexedResolutionTests_TextIndexOnNestedRoot(String variable) {
        this(MongoPersistentEntityIndexResolverUnitTests.TextIndexedResolutionTests.TextIndexOnNestedRoot.class, forVariable(variable), INITS);
    }

    public QMongoPersistentEntityIndexResolverUnitTests_TextIndexedResolutionTests_TextIndexOnNestedRoot(Path<? extends MongoPersistentEntityIndexResolverUnitTests.TextIndexedResolutionTests.TextIndexOnNestedRoot> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMongoPersistentEntityIndexResolverUnitTests_TextIndexedResolutionTests_TextIndexOnNestedRoot(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMongoPersistentEntityIndexResolverUnitTests_TextIndexedResolutionTests_TextIndexOnNestedRoot(PathMetadata metadata, PathInits inits) {
        this(MongoPersistentEntityIndexResolverUnitTests.TextIndexedResolutionTests.TextIndexOnNestedRoot.class, metadata, inits);
    }

    public QMongoPersistentEntityIndexResolverUnitTests_TextIndexedResolutionTests_TextIndexOnNestedRoot(Class<? extends MongoPersistentEntityIndexResolverUnitTests.TextIndexedResolutionTests.TextIndexOnNestedRoot> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.nested = inits.isInitialized("nested") ? new QMongoPersistentEntityIndexResolverUnitTests_TextIndexedResolutionTests_TextIndexOnNested(forProperty("nested")) : null;
    }

}

