package org.springframework.data.mongodb.core.index;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QTextIndexTests_TextIndexedDocumentWihtLanguageOverride is a Querydsl query type for TextIndexedDocumentWihtLanguageOverride
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QTextIndexTests_TextIndexedDocumentWihtLanguageOverride extends BeanPath<TextIndexTests.TextIndexedDocumentWihtLanguageOverride> {

    private static final long serialVersionUID = 1091054913L;

    public static final QTextIndexTests_TextIndexedDocumentWihtLanguageOverride textIndexedDocumentWihtLanguageOverride = new QTextIndexTests_TextIndexedDocumentWihtLanguageOverride("textIndexedDocumentWihtLanguageOverride");

    public final StringPath lang = createString("lang");

    public final StringPath nonTextIndexedProperty = createString("nonTextIndexedProperty");

    public final StringPath textIndexedPropertyInNestedDocument = createString("textIndexedPropertyInNestedDocument");

    public QTextIndexTests_TextIndexedDocumentWihtLanguageOverride(String variable) {
        super(TextIndexTests.TextIndexedDocumentWihtLanguageOverride.class, forVariable(variable));
    }

    public QTextIndexTests_TextIndexedDocumentWihtLanguageOverride(Path<? extends TextIndexTests.TextIndexedDocumentWihtLanguageOverride> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTextIndexTests_TextIndexedDocumentWihtLanguageOverride(PathMetadata metadata) {
        super(TextIndexTests.TextIndexedDocumentWihtLanguageOverride.class, metadata);
    }

}

