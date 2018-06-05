package org.springframework.data.mongodb.core.index;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMongoPersistentEntityIndexResolverUnitTests_TextIndexedResolutionTests_DocumentWithNoTextIndexPropertyButReservedFieldLanguage is a Querydsl query type for DocumentWithNoTextIndexPropertyButReservedFieldLanguage
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMongoPersistentEntityIndexResolverUnitTests_TextIndexedResolutionTests_DocumentWithNoTextIndexPropertyButReservedFieldLanguage extends EntityPathBase<MongoPersistentEntityIndexResolverUnitTests.TextIndexedResolutionTests.DocumentWithNoTextIndexPropertyButReservedFieldLanguage> {

    private static final long serialVersionUID = -1429301199L;

    public static final QMongoPersistentEntityIndexResolverUnitTests_TextIndexedResolutionTests_DocumentWithNoTextIndexPropertyButReservedFieldLanguage documentWithNoTextIndexPropertyButReservedFieldLanguage = new QMongoPersistentEntityIndexResolverUnitTests_TextIndexedResolutionTests_DocumentWithNoTextIndexPropertyButReservedFieldLanguage("documentWithNoTextIndexPropertyButReservedFieldLanguage");

    public final StringPath language = createString("language");

    public QMongoPersistentEntityIndexResolverUnitTests_TextIndexedResolutionTests_DocumentWithNoTextIndexPropertyButReservedFieldLanguage(String variable) {
        super(MongoPersistentEntityIndexResolverUnitTests.TextIndexedResolutionTests.DocumentWithNoTextIndexPropertyButReservedFieldLanguage.class, forVariable(variable));
    }

    public QMongoPersistentEntityIndexResolverUnitTests_TextIndexedResolutionTests_DocumentWithNoTextIndexPropertyButReservedFieldLanguage(Path<? extends MongoPersistentEntityIndexResolverUnitTests.TextIndexedResolutionTests.DocumentWithNoTextIndexPropertyButReservedFieldLanguage> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMongoPersistentEntityIndexResolverUnitTests_TextIndexedResolutionTests_DocumentWithNoTextIndexPropertyButReservedFieldLanguage(PathMetadata metadata) {
        super(MongoPersistentEntityIndexResolverUnitTests.TextIndexedResolutionTests.DocumentWithNoTextIndexPropertyButReservedFieldLanguage.class, metadata);
    }

}

