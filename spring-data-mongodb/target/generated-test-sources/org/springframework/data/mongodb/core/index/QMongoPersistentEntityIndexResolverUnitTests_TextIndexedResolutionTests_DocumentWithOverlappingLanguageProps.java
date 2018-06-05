package org.springframework.data.mongodb.core.index;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMongoPersistentEntityIndexResolverUnitTests_TextIndexedResolutionTests_DocumentWithOverlappingLanguageProps is a Querydsl query type for DocumentWithOverlappingLanguageProps
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMongoPersistentEntityIndexResolverUnitTests_TextIndexedResolutionTests_DocumentWithOverlappingLanguageProps extends EntityPathBase<MongoPersistentEntityIndexResolverUnitTests.TextIndexedResolutionTests.DocumentWithOverlappingLanguageProps> {

    private static final long serialVersionUID = 642674064L;

    public static final QMongoPersistentEntityIndexResolverUnitTests_TextIndexedResolutionTests_DocumentWithOverlappingLanguageProps documentWithOverlappingLanguageProps = new QMongoPersistentEntityIndexResolverUnitTests_TextIndexedResolutionTests_DocumentWithOverlappingLanguageProps("documentWithOverlappingLanguageProps");

    public final StringPath foo = createString("foo");

    public final StringPath lang = createString("lang");

    public final StringPath language = createString("language");

    public QMongoPersistentEntityIndexResolverUnitTests_TextIndexedResolutionTests_DocumentWithOverlappingLanguageProps(String variable) {
        super(MongoPersistentEntityIndexResolverUnitTests.TextIndexedResolutionTests.DocumentWithOverlappingLanguageProps.class, forVariable(variable));
    }

    public QMongoPersistentEntityIndexResolverUnitTests_TextIndexedResolutionTests_DocumentWithOverlappingLanguageProps(Path<? extends MongoPersistentEntityIndexResolverUnitTests.TextIndexedResolutionTests.DocumentWithOverlappingLanguageProps> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMongoPersistentEntityIndexResolverUnitTests_TextIndexedResolutionTests_DocumentWithOverlappingLanguageProps(PathMetadata metadata) {
        super(MongoPersistentEntityIndexResolverUnitTests.TextIndexedResolutionTests.DocumentWithOverlappingLanguageProps.class, metadata);
    }

}

