package org.springframework.data.mongodb.core.index;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMongoPersistentEntityIndexResolverUnitTests_TextIndexedResolutionTests_TextIndexOnNestedWithMostSpecificValue is a Querydsl query type for TextIndexOnNestedWithMostSpecificValue
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QMongoPersistentEntityIndexResolverUnitTests_TextIndexedResolutionTests_TextIndexOnNestedWithMostSpecificValue extends BeanPath<MongoPersistentEntityIndexResolverUnitTests.TextIndexedResolutionTests.TextIndexOnNestedWithMostSpecificValue> {

    private static final long serialVersionUID = 1833959787L;

    public static final QMongoPersistentEntityIndexResolverUnitTests_TextIndexedResolutionTests_TextIndexOnNestedWithMostSpecificValue textIndexOnNestedWithMostSpecificValue = new QMongoPersistentEntityIndexResolverUnitTests_TextIndexedResolutionTests_TextIndexOnNestedWithMostSpecificValue("textIndexOnNestedWithMostSpecificValue");

    public final StringPath bar = createString("bar");

    public final StringPath foo = createString("foo");

    public QMongoPersistentEntityIndexResolverUnitTests_TextIndexedResolutionTests_TextIndexOnNestedWithMostSpecificValue(String variable) {
        super(MongoPersistentEntityIndexResolverUnitTests.TextIndexedResolutionTests.TextIndexOnNestedWithMostSpecificValue.class, forVariable(variable));
    }

    public QMongoPersistentEntityIndexResolverUnitTests_TextIndexedResolutionTests_TextIndexOnNestedWithMostSpecificValue(Path<? extends MongoPersistentEntityIndexResolverUnitTests.TextIndexedResolutionTests.TextIndexOnNestedWithMostSpecificValue> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMongoPersistentEntityIndexResolverUnitTests_TextIndexedResolutionTests_TextIndexOnNestedWithMostSpecificValue(PathMetadata metadata) {
        super(MongoPersistentEntityIndexResolverUnitTests.TextIndexedResolutionTests.TextIndexOnNestedWithMostSpecificValue.class, metadata);
    }

}

