package org.springframework.data.mongodb.core.mapping;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QBasicMongoPersistentEntityUnitTests_CustomDocumentAnnotation is a Querydsl query type for CustomDocumentAnnotation
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QBasicMongoPersistentEntityUnitTests_CustomDocumentAnnotation extends EntityPathBase<BasicMongoPersistentEntityUnitTests.CustomDocumentAnnotation> {

    private static final long serialVersionUID = -1700814430L;

    public static final QBasicMongoPersistentEntityUnitTests_CustomDocumentAnnotation customDocumentAnnotation = new QBasicMongoPersistentEntityUnitTests_CustomDocumentAnnotation("customDocumentAnnotation");

    public QBasicMongoPersistentEntityUnitTests_CustomDocumentAnnotation(String variable) {
        super(BasicMongoPersistentEntityUnitTests.CustomDocumentAnnotation.class, forVariable(variable));
    }

    public QBasicMongoPersistentEntityUnitTests_CustomDocumentAnnotation(Path<? extends BasicMongoPersistentEntityUnitTests.CustomDocumentAnnotation> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBasicMongoPersistentEntityUnitTests_CustomDocumentAnnotation(PathMetadata metadata) {
        super(BasicMongoPersistentEntityUnitTests.CustomDocumentAnnotation.class, metadata);
    }

}

