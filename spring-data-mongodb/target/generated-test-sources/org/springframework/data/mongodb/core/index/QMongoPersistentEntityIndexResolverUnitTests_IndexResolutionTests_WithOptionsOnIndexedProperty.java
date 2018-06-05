package org.springframework.data.mongodb.core.index;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMongoPersistentEntityIndexResolverUnitTests_IndexResolutionTests_WithOptionsOnIndexedProperty is a Querydsl query type for WithOptionsOnIndexedProperty
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMongoPersistentEntityIndexResolverUnitTests_IndexResolutionTests_WithOptionsOnIndexedProperty extends EntityPathBase<MongoPersistentEntityIndexResolverUnitTests.IndexResolutionTests.WithOptionsOnIndexedProperty> {

    private static final long serialVersionUID = 1173035437L;

    public static final QMongoPersistentEntityIndexResolverUnitTests_IndexResolutionTests_WithOptionsOnIndexedProperty withOptionsOnIndexedProperty = new QMongoPersistentEntityIndexResolverUnitTests_IndexResolutionTests_WithOptionsOnIndexedProperty("withOptionsOnIndexedProperty");

    public final StringPath indexedProperty = createString("indexedProperty");

    public QMongoPersistentEntityIndexResolverUnitTests_IndexResolutionTests_WithOptionsOnIndexedProperty(String variable) {
        super(MongoPersistentEntityIndexResolverUnitTests.IndexResolutionTests.WithOptionsOnIndexedProperty.class, forVariable(variable));
    }

    public QMongoPersistentEntityIndexResolverUnitTests_IndexResolutionTests_WithOptionsOnIndexedProperty(Path<? extends MongoPersistentEntityIndexResolverUnitTests.IndexResolutionTests.WithOptionsOnIndexedProperty> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMongoPersistentEntityIndexResolverUnitTests_IndexResolutionTests_WithOptionsOnIndexedProperty(PathMetadata metadata) {
        super(MongoPersistentEntityIndexResolverUnitTests.IndexResolutionTests.WithOptionsOnIndexedProperty.class, metadata);
    }

}

