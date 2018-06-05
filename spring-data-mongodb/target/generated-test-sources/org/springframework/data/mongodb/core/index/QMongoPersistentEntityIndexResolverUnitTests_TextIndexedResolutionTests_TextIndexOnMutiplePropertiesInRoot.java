package org.springframework.data.mongodb.core.index;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMongoPersistentEntityIndexResolverUnitTests_TextIndexedResolutionTests_TextIndexOnMutiplePropertiesInRoot is a Querydsl query type for TextIndexOnMutiplePropertiesInRoot
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMongoPersistentEntityIndexResolverUnitTests_TextIndexedResolutionTests_TextIndexOnMutiplePropertiesInRoot extends EntityPathBase<MongoPersistentEntityIndexResolverUnitTests.TextIndexedResolutionTests.TextIndexOnMutiplePropertiesInRoot> {

    private static final long serialVersionUID = -1152137934L;

    public static final QMongoPersistentEntityIndexResolverUnitTests_TextIndexedResolutionTests_TextIndexOnMutiplePropertiesInRoot textIndexOnMutiplePropertiesInRoot = new QMongoPersistentEntityIndexResolverUnitTests_TextIndexedResolutionTests_TextIndexOnMutiplePropertiesInRoot("textIndexOnMutiplePropertiesInRoot");

    public final StringPath bar = createString("bar");

    public final StringPath foo = createString("foo");

    public QMongoPersistentEntityIndexResolverUnitTests_TextIndexedResolutionTests_TextIndexOnMutiplePropertiesInRoot(String variable) {
        super(MongoPersistentEntityIndexResolverUnitTests.TextIndexedResolutionTests.TextIndexOnMutiplePropertiesInRoot.class, forVariable(variable));
    }

    public QMongoPersistentEntityIndexResolverUnitTests_TextIndexedResolutionTests_TextIndexOnMutiplePropertiesInRoot(Path<? extends MongoPersistentEntityIndexResolverUnitTests.TextIndexedResolutionTests.TextIndexOnMutiplePropertiesInRoot> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMongoPersistentEntityIndexResolverUnitTests_TextIndexedResolutionTests_TextIndexOnMutiplePropertiesInRoot(PathMetadata metadata) {
        super(MongoPersistentEntityIndexResolverUnitTests.TextIndexedResolutionTests.TextIndexOnMutiplePropertiesInRoot.class, metadata);
    }

}

