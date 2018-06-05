package org.springframework.data.mongodb.core.index;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMongoPersistentEntityIndexResolverUnitTests_TextIndexedResolutionTests_TextIndexOnNested is a Querydsl query type for TextIndexOnNested
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QMongoPersistentEntityIndexResolverUnitTests_TextIndexedResolutionTests_TextIndexOnNested extends BeanPath<MongoPersistentEntityIndexResolverUnitTests.TextIndexedResolutionTests.TextIndexOnNested> {

    private static final long serialVersionUID = -978401333L;

    public static final QMongoPersistentEntityIndexResolverUnitTests_TextIndexedResolutionTests_TextIndexOnNested textIndexOnNested = new QMongoPersistentEntityIndexResolverUnitTests_TextIndexedResolutionTests_TextIndexOnNested("textIndexOnNested");

    public final StringPath foo = createString("foo");

    public QMongoPersistentEntityIndexResolverUnitTests_TextIndexedResolutionTests_TextIndexOnNested(String variable) {
        super(MongoPersistentEntityIndexResolverUnitTests.TextIndexedResolutionTests.TextIndexOnNested.class, forVariable(variable));
    }

    public QMongoPersistentEntityIndexResolverUnitTests_TextIndexedResolutionTests_TextIndexOnNested(Path<? extends MongoPersistentEntityIndexResolverUnitTests.TextIndexedResolutionTests.TextIndexOnNested> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMongoPersistentEntityIndexResolverUnitTests_TextIndexedResolutionTests_TextIndexOnNested(PathMetadata metadata) {
        super(MongoPersistentEntityIndexResolverUnitTests.TextIndexedResolutionTests.TextIndexOnNested.class, metadata);
    }

}

