package org.springframework.data.mongodb.core.index;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTextIndexTests_TextIndexedDocumentRoot is a Querydsl query type for TextIndexedDocumentRoot
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTextIndexTests_TextIndexedDocumentRoot extends EntityPathBase<TextIndexTests.TextIndexedDocumentRoot> {

    private static final long serialVersionUID = -486287007L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTextIndexTests_TextIndexedDocumentRoot textIndexedDocumentRoot = new QTextIndexTests_TextIndexedDocumentRoot("textIndexedDocumentRoot");

    public final QTextIndexTests_TextIndexedDocumentWihtLanguageOverride nestedDocument;

    public final StringPath textIndexedPropertyWithDefaultWeight = createString("textIndexedPropertyWithDefaultWeight");

    public final StringPath textIndexedPropertyWithWeight = createString("textIndexedPropertyWithWeight");

    public QTextIndexTests_TextIndexedDocumentRoot(String variable) {
        this(TextIndexTests.TextIndexedDocumentRoot.class, forVariable(variable), INITS);
    }

    public QTextIndexTests_TextIndexedDocumentRoot(Path<? extends TextIndexTests.TextIndexedDocumentRoot> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QTextIndexTests_TextIndexedDocumentRoot(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QTextIndexTests_TextIndexedDocumentRoot(PathMetadata metadata, PathInits inits) {
        this(TextIndexTests.TextIndexedDocumentRoot.class, metadata, inits);
    }

    public QTextIndexTests_TextIndexedDocumentRoot(Class<? extends TextIndexTests.TextIndexedDocumentRoot> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.nestedDocument = inits.isInitialized("nestedDocument") ? new QTextIndexTests_TextIndexedDocumentWihtLanguageOverride(forProperty("nestedDocument")) : null;
    }

}

