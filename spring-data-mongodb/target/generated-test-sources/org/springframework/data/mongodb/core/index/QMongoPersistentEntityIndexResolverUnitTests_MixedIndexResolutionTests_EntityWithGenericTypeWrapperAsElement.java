package org.springframework.data.mongodb.core.index;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_EntityWithGenericTypeWrapperAsElement is a Querydsl query type for EntityWithGenericTypeWrapperAsElement
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_EntityWithGenericTypeWrapperAsElement extends EntityPathBase<MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.EntityWithGenericTypeWrapperAsElement> {

    private static final long serialVersionUID = 1398181890L;

    public static final QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_EntityWithGenericTypeWrapperAsElement entityWithGenericTypeWrapperAsElement = new QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_EntityWithGenericTypeWrapperAsElement("entityWithGenericTypeWrapperAsElement");

    public final ListPath<MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.GenericEntityWrapper<MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.DocumentWithNamedIndex>, QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_GenericEntityWrapper> listWithGeneircTypeElement = this.<MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.GenericEntityWrapper<MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.DocumentWithNamedIndex>, QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_GenericEntityWrapper>createList("listWithGeneircTypeElement", MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.GenericEntityWrapper.class, QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_GenericEntityWrapper.class, PathInits.DIRECT2);

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_EntityWithGenericTypeWrapperAsElement(String variable) {
        super(MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.EntityWithGenericTypeWrapperAsElement.class, forVariable(variable));
    }

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_EntityWithGenericTypeWrapperAsElement(Path<? extends MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.EntityWithGenericTypeWrapperAsElement> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_EntityWithGenericTypeWrapperAsElement(PathMetadata metadata) {
        super(MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.EntityWithGenericTypeWrapperAsElement.class, metadata);
    }

}

