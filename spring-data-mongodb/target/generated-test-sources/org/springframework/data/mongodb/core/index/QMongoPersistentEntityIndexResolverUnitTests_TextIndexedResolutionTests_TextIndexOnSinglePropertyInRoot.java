package org.springframework.data.mongodb.core.index;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMongoPersistentEntityIndexResolverUnitTests_TextIndexedResolutionTests_TextIndexOnSinglePropertyInRoot is a Querydsl query type for TextIndexOnSinglePropertyInRoot
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMongoPersistentEntityIndexResolverUnitTests_TextIndexedResolutionTests_TextIndexOnSinglePropertyInRoot extends EntityPathBase<MongoPersistentEntityIndexResolverUnitTests.TextIndexedResolutionTests.TextIndexOnSinglePropertyInRoot> {

    private static final long serialVersionUID = -1564060648L;

    public static final QMongoPersistentEntityIndexResolverUnitTests_TextIndexedResolutionTests_TextIndexOnSinglePropertyInRoot textIndexOnSinglePropertyInRoot = new QMongoPersistentEntityIndexResolverUnitTests_TextIndexedResolutionTests_TextIndexOnSinglePropertyInRoot("textIndexOnSinglePropertyInRoot");

    public final StringPath bar = createString("bar");

    public final StringPath foo = createString("foo");

    public QMongoPersistentEntityIndexResolverUnitTests_TextIndexedResolutionTests_TextIndexOnSinglePropertyInRoot(String variable) {
        super(MongoPersistentEntityIndexResolverUnitTests.TextIndexedResolutionTests.TextIndexOnSinglePropertyInRoot.class, forVariable(variable));
    }

    public QMongoPersistentEntityIndexResolverUnitTests_TextIndexedResolutionTests_TextIndexOnSinglePropertyInRoot(Path<? extends MongoPersistentEntityIndexResolverUnitTests.TextIndexedResolutionTests.TextIndexOnSinglePropertyInRoot> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMongoPersistentEntityIndexResolverUnitTests_TextIndexedResolutionTests_TextIndexOnSinglePropertyInRoot(PathMetadata metadata) {
        super(MongoPersistentEntityIndexResolverUnitTests.TextIndexedResolutionTests.TextIndexOnSinglePropertyInRoot.class, metadata);
    }

}

