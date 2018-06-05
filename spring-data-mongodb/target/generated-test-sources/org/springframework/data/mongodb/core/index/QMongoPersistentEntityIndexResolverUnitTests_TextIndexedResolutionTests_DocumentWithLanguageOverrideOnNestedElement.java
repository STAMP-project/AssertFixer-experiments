package org.springframework.data.mongodb.core.index;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMongoPersistentEntityIndexResolverUnitTests_TextIndexedResolutionTests_DocumentWithLanguageOverrideOnNestedElement is a Querydsl query type for DocumentWithLanguageOverrideOnNestedElement
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMongoPersistentEntityIndexResolverUnitTests_TextIndexedResolutionTests_DocumentWithLanguageOverrideOnNestedElement extends EntityPathBase<MongoPersistentEntityIndexResolverUnitTests.TextIndexedResolutionTests.DocumentWithLanguageOverrideOnNestedElement> {

    private static final long serialVersionUID = 466370321L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMongoPersistentEntityIndexResolverUnitTests_TextIndexedResolutionTests_DocumentWithLanguageOverrideOnNestedElement documentWithLanguageOverrideOnNestedElement = new QMongoPersistentEntityIndexResolverUnitTests_TextIndexedResolutionTests_DocumentWithLanguageOverrideOnNestedElement("documentWithLanguageOverrideOnNestedElement");

    public final QMongoPersistentEntityIndexResolverUnitTests_TextIndexedResolutionTests_DocumentWithLanguageOverride nested;

    public QMongoPersistentEntityIndexResolverUnitTests_TextIndexedResolutionTests_DocumentWithLanguageOverrideOnNestedElement(String variable) {
        this(MongoPersistentEntityIndexResolverUnitTests.TextIndexedResolutionTests.DocumentWithLanguageOverrideOnNestedElement.class, forVariable(variable), INITS);
    }

    public QMongoPersistentEntityIndexResolverUnitTests_TextIndexedResolutionTests_DocumentWithLanguageOverrideOnNestedElement(Path<? extends MongoPersistentEntityIndexResolverUnitTests.TextIndexedResolutionTests.DocumentWithLanguageOverrideOnNestedElement> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMongoPersistentEntityIndexResolverUnitTests_TextIndexedResolutionTests_DocumentWithLanguageOverrideOnNestedElement(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMongoPersistentEntityIndexResolverUnitTests_TextIndexedResolutionTests_DocumentWithLanguageOverrideOnNestedElement(PathMetadata metadata, PathInits inits) {
        this(MongoPersistentEntityIndexResolverUnitTests.TextIndexedResolutionTests.DocumentWithLanguageOverrideOnNestedElement.class, metadata, inits);
    }

    public QMongoPersistentEntityIndexResolverUnitTests_TextIndexedResolutionTests_DocumentWithLanguageOverrideOnNestedElement(Class<? extends MongoPersistentEntityIndexResolverUnitTests.TextIndexedResolutionTests.DocumentWithLanguageOverrideOnNestedElement> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.nested = inits.isInitialized("nested") ? new QMongoPersistentEntityIndexResolverUnitTests_TextIndexedResolutionTests_DocumentWithLanguageOverride(forProperty("nested")) : null;
    }

}

