package org.springframework.data.mongodb.core.index;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMongoPersistentEntityIndexCreatorUnitTests_IndexedDocument is a Querydsl query type for IndexedDocument
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QMongoPersistentEntityIndexCreatorUnitTests_IndexedDocument extends BeanPath<MongoPersistentEntityIndexCreatorUnitTests.IndexedDocument> {

    private static final long serialVersionUID = 93087141L;

    public static final QMongoPersistentEntityIndexCreatorUnitTests_IndexedDocument indexedDocument = new QMongoPersistentEntityIndexCreatorUnitTests_IndexedDocument("indexedDocument");

    public final StringPath indexedValue = createString("indexedValue");

    public QMongoPersistentEntityIndexCreatorUnitTests_IndexedDocument(String variable) {
        super(MongoPersistentEntityIndexCreatorUnitTests.IndexedDocument.class, forVariable(variable));
    }

    public QMongoPersistentEntityIndexCreatorUnitTests_IndexedDocument(Path<? extends MongoPersistentEntityIndexCreatorUnitTests.IndexedDocument> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMongoPersistentEntityIndexCreatorUnitTests_IndexedDocument(PathMetadata metadata) {
        super(MongoPersistentEntityIndexCreatorUnitTests.IndexedDocument.class, metadata);
    }

}

