package org.springframework.data.mongodb.core.index;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMongoPersistentEntityIndexResolverUnitTests_TextIndexedResolutionTests_TextIndexedDocumentWithComposedAnnotation is a Querydsl query type for TextIndexedDocumentWithComposedAnnotation
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMongoPersistentEntityIndexResolverUnitTests_TextIndexedResolutionTests_TextIndexedDocumentWithComposedAnnotation extends EntityPathBase<MongoPersistentEntityIndexResolverUnitTests.TextIndexedResolutionTests.TextIndexedDocumentWithComposedAnnotation> {

    private static final long serialVersionUID = 635739574L;

    public static final QMongoPersistentEntityIndexResolverUnitTests_TextIndexedResolutionTests_TextIndexedDocumentWithComposedAnnotation textIndexedDocumentWithComposedAnnotation = new QMongoPersistentEntityIndexResolverUnitTests_TextIndexedResolutionTests_TextIndexedDocumentWithComposedAnnotation("textIndexedDocumentWithComposedAnnotation");

    public final StringPath foo = createString("foo");

    public final StringPath lang = createString("lang");

    public QMongoPersistentEntityIndexResolverUnitTests_TextIndexedResolutionTests_TextIndexedDocumentWithComposedAnnotation(String variable) {
        super(MongoPersistentEntityIndexResolverUnitTests.TextIndexedResolutionTests.TextIndexedDocumentWithComposedAnnotation.class, forVariable(variable));
    }

    public QMongoPersistentEntityIndexResolverUnitTests_TextIndexedResolutionTests_TextIndexedDocumentWithComposedAnnotation(Path<? extends MongoPersistentEntityIndexResolverUnitTests.TextIndexedResolutionTests.TextIndexedDocumentWithComposedAnnotation> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMongoPersistentEntityIndexResolverUnitTests_TextIndexedResolutionTests_TextIndexedDocumentWithComposedAnnotation(PathMetadata metadata) {
        super(MongoPersistentEntityIndexResolverUnitTests.TextIndexedResolutionTests.TextIndexedDocumentWithComposedAnnotation.class, metadata);
    }

}

