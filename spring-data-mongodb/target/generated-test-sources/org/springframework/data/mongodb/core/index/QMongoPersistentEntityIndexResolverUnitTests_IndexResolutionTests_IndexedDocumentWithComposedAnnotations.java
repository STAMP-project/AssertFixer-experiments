package org.springframework.data.mongodb.core.index;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMongoPersistentEntityIndexResolverUnitTests_IndexResolutionTests_IndexedDocumentWithComposedAnnotations is a Querydsl query type for IndexedDocumentWithComposedAnnotations
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMongoPersistentEntityIndexResolverUnitTests_IndexResolutionTests_IndexedDocumentWithComposedAnnotations extends EntityPathBase<MongoPersistentEntityIndexResolverUnitTests.IndexResolutionTests.IndexedDocumentWithComposedAnnotations> {

    private static final long serialVersionUID = -348631170L;

    public static final QMongoPersistentEntityIndexResolverUnitTests_IndexResolutionTests_IndexedDocumentWithComposedAnnotations indexedDocumentWithComposedAnnotations = new QMongoPersistentEntityIndexResolverUnitTests_IndexResolutionTests_IndexedDocumentWithComposedAnnotations("indexedDocumentWithComposedAnnotations");

    public final StringPath fieldWithDifferentIndexName = createString("fieldWithDifferentIndexName");

    public final StringPath fieldWithMyIndexName = createString("fieldWithMyIndexName");

    public final StringPath id = createString("id");

    public QMongoPersistentEntityIndexResolverUnitTests_IndexResolutionTests_IndexedDocumentWithComposedAnnotations(String variable) {
        super(MongoPersistentEntityIndexResolverUnitTests.IndexResolutionTests.IndexedDocumentWithComposedAnnotations.class, forVariable(variable));
    }

    public QMongoPersistentEntityIndexResolverUnitTests_IndexResolutionTests_IndexedDocumentWithComposedAnnotations(Path<? extends MongoPersistentEntityIndexResolverUnitTests.IndexResolutionTests.IndexedDocumentWithComposedAnnotations> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMongoPersistentEntityIndexResolverUnitTests_IndexResolutionTests_IndexedDocumentWithComposedAnnotations(PathMetadata metadata) {
        super(MongoPersistentEntityIndexResolverUnitTests.IndexResolutionTests.IndexedDocumentWithComposedAnnotations.class, metadata);
    }

}

