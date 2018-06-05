package org.springframework.data.mongodb.core.index;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_MultiplePropertiesOfSameTypeWithMatchingStartLetters_NameComponent is a Querydsl query type for NameComponent
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_MultiplePropertiesOfSameTypeWithMatchingStartLetters_NameComponent extends BeanPath<MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.MultiplePropertiesOfSameTypeWithMatchingStartLetters.NameComponent> {

    private static final long serialVersionUID = 1575233097L;

    public static final QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_MultiplePropertiesOfSameTypeWithMatchingStartLetters_NameComponent nameComponent = new QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_MultiplePropertiesOfSameTypeWithMatchingStartLetters_NameComponent("nameComponent");

    public final StringPath component = createString("component");

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_MultiplePropertiesOfSameTypeWithMatchingStartLetters_NameComponent(String variable) {
        super(MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.MultiplePropertiesOfSameTypeWithMatchingStartLetters.NameComponent.class, forVariable(variable));
    }

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_MultiplePropertiesOfSameTypeWithMatchingStartLetters_NameComponent(Path<? extends MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.MultiplePropertiesOfSameTypeWithMatchingStartLetters.NameComponent> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_MultiplePropertiesOfSameTypeWithMatchingStartLetters_NameComponent(PathMetadata metadata) {
        super(MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.MultiplePropertiesOfSameTypeWithMatchingStartLetters.NameComponent.class, metadata);
    }

}

