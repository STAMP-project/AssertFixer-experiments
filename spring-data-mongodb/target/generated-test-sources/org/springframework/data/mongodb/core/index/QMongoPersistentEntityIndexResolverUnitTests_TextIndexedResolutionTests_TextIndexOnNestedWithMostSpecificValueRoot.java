package org.springframework.data.mongodb.core.index;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMongoPersistentEntityIndexResolverUnitTests_TextIndexedResolutionTests_TextIndexOnNestedWithMostSpecificValueRoot is a Querydsl query type for TextIndexOnNestedWithMostSpecificValueRoot
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMongoPersistentEntityIndexResolverUnitTests_TextIndexedResolutionTests_TextIndexOnNestedWithMostSpecificValueRoot extends EntityPathBase<MongoPersistentEntityIndexResolverUnitTests.TextIndexedResolutionTests.TextIndexOnNestedWithMostSpecificValueRoot> {

    private static final long serialVersionUID = 1500661997L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMongoPersistentEntityIndexResolverUnitTests_TextIndexedResolutionTests_TextIndexOnNestedWithMostSpecificValueRoot textIndexOnNestedWithMostSpecificValueRoot = new QMongoPersistentEntityIndexResolverUnitTests_TextIndexedResolutionTests_TextIndexOnNestedWithMostSpecificValueRoot("textIndexOnNestedWithMostSpecificValueRoot");

    public final QMongoPersistentEntityIndexResolverUnitTests_TextIndexedResolutionTests_TextIndexOnNestedWithMostSpecificValue nested;

    public QMongoPersistentEntityIndexResolverUnitTests_TextIndexedResolutionTests_TextIndexOnNestedWithMostSpecificValueRoot(String variable) {
        this(MongoPersistentEntityIndexResolverUnitTests.TextIndexedResolutionTests.TextIndexOnNestedWithMostSpecificValueRoot.class, forVariable(variable), INITS);
    }

    public QMongoPersistentEntityIndexResolverUnitTests_TextIndexedResolutionTests_TextIndexOnNestedWithMostSpecificValueRoot(Path<? extends MongoPersistentEntityIndexResolverUnitTests.TextIndexedResolutionTests.TextIndexOnNestedWithMostSpecificValueRoot> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMongoPersistentEntityIndexResolverUnitTests_TextIndexedResolutionTests_TextIndexOnNestedWithMostSpecificValueRoot(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMongoPersistentEntityIndexResolverUnitTests_TextIndexedResolutionTests_TextIndexOnNestedWithMostSpecificValueRoot(PathMetadata metadata, PathInits inits) {
        this(MongoPersistentEntityIndexResolverUnitTests.TextIndexedResolutionTests.TextIndexOnNestedWithMostSpecificValueRoot.class, metadata, inits);
    }

    public QMongoPersistentEntityIndexResolverUnitTests_TextIndexedResolutionTests_TextIndexOnNestedWithMostSpecificValueRoot(Class<? extends MongoPersistentEntityIndexResolverUnitTests.TextIndexedResolutionTests.TextIndexOnNestedWithMostSpecificValueRoot> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.nested = inits.isInitialized("nested") ? new QMongoPersistentEntityIndexResolverUnitTests_TextIndexedResolutionTests_TextIndexOnNestedWithMostSpecificValue(forProperty("nested")) : null;
    }

}

