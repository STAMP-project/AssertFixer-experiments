package org.springframework.data.mongodb.core.index;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMongoPersistentEntityIndexCreatorUnitTests_IndexedDocumentWrapper is a Querydsl query type for IndexedDocumentWrapper
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMongoPersistentEntityIndexCreatorUnitTests_IndexedDocumentWrapper extends EntityPathBase<MongoPersistentEntityIndexCreatorUnitTests.IndexedDocumentWrapper> {

    private static final long serialVersionUID = 1914438446L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMongoPersistentEntityIndexCreatorUnitTests_IndexedDocumentWrapper indexedDocumentWrapper = new QMongoPersistentEntityIndexCreatorUnitTests_IndexedDocumentWrapper("indexedDocumentWrapper");

    public final QMongoPersistentEntityIndexCreatorUnitTests_IndexedDocument indexedDocument;

    public QMongoPersistentEntityIndexCreatorUnitTests_IndexedDocumentWrapper(String variable) {
        this(MongoPersistentEntityIndexCreatorUnitTests.IndexedDocumentWrapper.class, forVariable(variable), INITS);
    }

    public QMongoPersistentEntityIndexCreatorUnitTests_IndexedDocumentWrapper(Path<? extends MongoPersistentEntityIndexCreatorUnitTests.IndexedDocumentWrapper> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMongoPersistentEntityIndexCreatorUnitTests_IndexedDocumentWrapper(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMongoPersistentEntityIndexCreatorUnitTests_IndexedDocumentWrapper(PathMetadata metadata, PathInits inits) {
        this(MongoPersistentEntityIndexCreatorUnitTests.IndexedDocumentWrapper.class, metadata, inits);
    }

    public QMongoPersistentEntityIndexCreatorUnitTests_IndexedDocumentWrapper(Class<? extends MongoPersistentEntityIndexCreatorUnitTests.IndexedDocumentWrapper> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.indexedDocument = inits.isInitialized("indexedDocument") ? new QMongoPersistentEntityIndexCreatorUnitTests_IndexedDocument(forProperty("indexedDocument")) : null;
    }

}

