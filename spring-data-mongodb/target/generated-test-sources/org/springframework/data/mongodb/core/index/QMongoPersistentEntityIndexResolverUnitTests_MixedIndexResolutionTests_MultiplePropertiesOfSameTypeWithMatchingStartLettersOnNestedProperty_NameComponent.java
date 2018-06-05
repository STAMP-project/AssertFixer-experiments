package org.springframework.data.mongodb.core.index;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_MultiplePropertiesOfSameTypeWithMatchingStartLettersOnNestedProperty_NameComponent is a Querydsl query type for NameComponent
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_MultiplePropertiesOfSameTypeWithMatchingStartLettersOnNestedProperty_NameComponent extends BeanPath<MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.MultiplePropertiesOfSameTypeWithMatchingStartLettersOnNestedProperty.NameComponent> {

    private static final long serialVersionUID = 614458580L;

    public static final QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_MultiplePropertiesOfSameTypeWithMatchingStartLettersOnNestedProperty_NameComponent nameComponent = new QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_MultiplePropertiesOfSameTypeWithMatchingStartLettersOnNestedProperty_NameComponent("nameComponent");

    public final StringPath name = createString("name");

    public final StringPath nameLast = createString("nameLast");

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_MultiplePropertiesOfSameTypeWithMatchingStartLettersOnNestedProperty_NameComponent(String variable) {
        super(MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.MultiplePropertiesOfSameTypeWithMatchingStartLettersOnNestedProperty.NameComponent.class, forVariable(variable));
    }

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_MultiplePropertiesOfSameTypeWithMatchingStartLettersOnNestedProperty_NameComponent(Path<? extends MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.MultiplePropertiesOfSameTypeWithMatchingStartLettersOnNestedProperty.NameComponent> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_MultiplePropertiesOfSameTypeWithMatchingStartLettersOnNestedProperty_NameComponent(PathMetadata metadata) {
        super(MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.MultiplePropertiesOfSameTypeWithMatchingStartLettersOnNestedProperty.NameComponent.class, metadata);
    }

}

