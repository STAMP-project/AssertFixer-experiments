package org.springframework.data.mongodb.core.index;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMongoPersistentEntityIndexResolverUnitTests_TextIndexedResolutionTests_DocumentWithLanguageOverride is a Querydsl query type for DocumentWithLanguageOverride
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMongoPersistentEntityIndexResolverUnitTests_TextIndexedResolutionTests_DocumentWithLanguageOverride extends EntityPathBase<MongoPersistentEntityIndexResolverUnitTests.TextIndexedResolutionTests.DocumentWithLanguageOverride> {

    private static final long serialVersionUID = -103619947L;

    public static final QMongoPersistentEntityIndexResolverUnitTests_TextIndexedResolutionTests_DocumentWithLanguageOverride documentWithLanguageOverride = new QMongoPersistentEntityIndexResolverUnitTests_TextIndexedResolutionTests_DocumentWithLanguageOverride("documentWithLanguageOverride");

    public final StringPath foo = createString("foo");

    public final StringPath lang = createString("lang");

    public QMongoPersistentEntityIndexResolverUnitTests_TextIndexedResolutionTests_DocumentWithLanguageOverride(String variable) {
        super(MongoPersistentEntityIndexResolverUnitTests.TextIndexedResolutionTests.DocumentWithLanguageOverride.class, forVariable(variable));
    }

    public QMongoPersistentEntityIndexResolverUnitTests_TextIndexedResolutionTests_DocumentWithLanguageOverride(Path<? extends MongoPersistentEntityIndexResolverUnitTests.TextIndexedResolutionTests.DocumentWithLanguageOverride> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMongoPersistentEntityIndexResolverUnitTests_TextIndexedResolutionTests_DocumentWithLanguageOverride(PathMetadata metadata) {
        super(MongoPersistentEntityIndexResolverUnitTests.TextIndexedResolutionTests.DocumentWithLanguageOverride.class, metadata);
    }

}

