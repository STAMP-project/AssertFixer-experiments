package org.springframework.data.mongodb.core.mapping;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QBasicMongoPersistentEntityUnitTests_ComposedDocumentAnnotation is a Querydsl query type for ComposedDocumentAnnotation
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QBasicMongoPersistentEntityUnitTests_ComposedDocumentAnnotation extends EntityPathBase<BasicMongoPersistentEntityUnitTests.ComposedDocumentAnnotation> {

    private static final long serialVersionUID = -1601551549L;

    public static final QBasicMongoPersistentEntityUnitTests_ComposedDocumentAnnotation composedDocumentAnnotation = new QBasicMongoPersistentEntityUnitTests_ComposedDocumentAnnotation("composedDocumentAnnotation");

    public QBasicMongoPersistentEntityUnitTests_ComposedDocumentAnnotation(String variable) {
        super(BasicMongoPersistentEntityUnitTests.ComposedDocumentAnnotation.class, forVariable(variable));
    }

    public QBasicMongoPersistentEntityUnitTests_ComposedDocumentAnnotation(Path<? extends BasicMongoPersistentEntityUnitTests.ComposedDocumentAnnotation> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBasicMongoPersistentEntityUnitTests_ComposedDocumentAnnotation(PathMetadata metadata) {
        super(BasicMongoPersistentEntityUnitTests.ComposedDocumentAnnotation.class, metadata);
    }

}

