package org.springframework.data.mongodb.core.index;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMongoPersistentEntityIndexResolverUnitTests_TextIndexedResolutionTests_TextIndexOnNestedWithWeightRoot is a Querydsl query type for TextIndexOnNestedWithWeightRoot
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMongoPersistentEntityIndexResolverUnitTests_TextIndexedResolutionTests_TextIndexOnNestedWithWeightRoot extends EntityPathBase<MongoPersistentEntityIndexResolverUnitTests.TextIndexedResolutionTests.TextIndexOnNestedWithWeightRoot> {

    private static final long serialVersionUID = -1120100981L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMongoPersistentEntityIndexResolverUnitTests_TextIndexedResolutionTests_TextIndexOnNestedWithWeightRoot textIndexOnNestedWithWeightRoot = new QMongoPersistentEntityIndexResolverUnitTests_TextIndexedResolutionTests_TextIndexOnNestedWithWeightRoot("textIndexOnNestedWithWeightRoot");

    public final QMongoPersistentEntityIndexResolverUnitTests_TextIndexedResolutionTests_TextIndexOnNested nested;

    public QMongoPersistentEntityIndexResolverUnitTests_TextIndexedResolutionTests_TextIndexOnNestedWithWeightRoot(String variable) {
        this(MongoPersistentEntityIndexResolverUnitTests.TextIndexedResolutionTests.TextIndexOnNestedWithWeightRoot.class, forVariable(variable), INITS);
    }

    public QMongoPersistentEntityIndexResolverUnitTests_TextIndexedResolutionTests_TextIndexOnNestedWithWeightRoot(Path<? extends MongoPersistentEntityIndexResolverUnitTests.TextIndexedResolutionTests.TextIndexOnNestedWithWeightRoot> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMongoPersistentEntityIndexResolverUnitTests_TextIndexedResolutionTests_TextIndexOnNestedWithWeightRoot(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMongoPersistentEntityIndexResolverUnitTests_TextIndexedResolutionTests_TextIndexOnNestedWithWeightRoot(PathMetadata metadata, PathInits inits) {
        this(MongoPersistentEntityIndexResolverUnitTests.TextIndexedResolutionTests.TextIndexOnNestedWithWeightRoot.class, metadata, inits);
    }

    public QMongoPersistentEntityIndexResolverUnitTests_TextIndexedResolutionTests_TextIndexOnNestedWithWeightRoot(Class<? extends MongoPersistentEntityIndexResolverUnitTests.TextIndexedResolutionTests.TextIndexOnNestedWithWeightRoot> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.nested = inits.isInitialized("nested") ? new QMongoPersistentEntityIndexResolverUnitTests_TextIndexedResolutionTests_TextIndexOnNested(forProperty("nested")) : null;
    }

}

