package org.springframework.data.mongodb.core.index;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMongoPersistentEntityIndexResolverUnitTests_TextIndexedResolutionTests_DocumentWithNoTextIndexPropertyButReservedFieldLanguageAnnotated is a Querydsl query type for DocumentWithNoTextIndexPropertyButReservedFieldLanguageAnnotated
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMongoPersistentEntityIndexResolverUnitTests_TextIndexedResolutionTests_DocumentWithNoTextIndexPropertyButReservedFieldLanguageAnnotated extends EntityPathBase<MongoPersistentEntityIndexResolverUnitTests.TextIndexedResolutionTests.DocumentWithNoTextIndexPropertyButReservedFieldLanguageAnnotated> {

    private static final long serialVersionUID = -1053530265L;

    public static final QMongoPersistentEntityIndexResolverUnitTests_TextIndexedResolutionTests_DocumentWithNoTextIndexPropertyButReservedFieldLanguageAnnotated documentWithNoTextIndexPropertyButReservedFieldLanguageAnnotated = new QMongoPersistentEntityIndexResolverUnitTests_TextIndexedResolutionTests_DocumentWithNoTextIndexPropertyButReservedFieldLanguageAnnotated("documentWithNoTextIndexPropertyButReservedFieldLanguageAnnotated");

    public final StringPath lang = createString("lang");

    public QMongoPersistentEntityIndexResolverUnitTests_TextIndexedResolutionTests_DocumentWithNoTextIndexPropertyButReservedFieldLanguageAnnotated(String variable) {
        super(MongoPersistentEntityIndexResolverUnitTests.TextIndexedResolutionTests.DocumentWithNoTextIndexPropertyButReservedFieldLanguageAnnotated.class, forVariable(variable));
    }

    public QMongoPersistentEntityIndexResolverUnitTests_TextIndexedResolutionTests_DocumentWithNoTextIndexPropertyButReservedFieldLanguageAnnotated(Path<? extends MongoPersistentEntityIndexResolverUnitTests.TextIndexedResolutionTests.DocumentWithNoTextIndexPropertyButReservedFieldLanguageAnnotated> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMongoPersistentEntityIndexResolverUnitTests_TextIndexedResolutionTests_DocumentWithNoTextIndexPropertyButReservedFieldLanguageAnnotated(PathMetadata metadata) {
        super(MongoPersistentEntityIndexResolverUnitTests.TextIndexedResolutionTests.DocumentWithNoTextIndexPropertyButReservedFieldLanguageAnnotated.class, metadata);
    }

}

