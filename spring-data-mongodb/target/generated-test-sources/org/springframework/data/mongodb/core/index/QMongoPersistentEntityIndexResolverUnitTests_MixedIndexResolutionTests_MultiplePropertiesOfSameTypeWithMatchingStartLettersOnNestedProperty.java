package org.springframework.data.mongodb.core.index;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_MultiplePropertiesOfSameTypeWithMatchingStartLettersOnNestedProperty is a Querydsl query type for MultiplePropertiesOfSameTypeWithMatchingStartLettersOnNestedProperty
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_MultiplePropertiesOfSameTypeWithMatchingStartLettersOnNestedProperty extends EntityPathBase<MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.MultiplePropertiesOfSameTypeWithMatchingStartLettersOnNestedProperty> {

    private static final long serialVersionUID = 1546665904L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_MultiplePropertiesOfSameTypeWithMatchingStartLettersOnNestedProperty multiplePropertiesOfSameTypeWithMatchingStartLettersOnNestedProperty = new QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_MultiplePropertiesOfSameTypeWithMatchingStartLettersOnNestedProperty("multiplePropertiesOfSameTypeWithMatchingStartLettersOnNestedProperty");

    public final QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_MultiplePropertiesOfSameTypeWithMatchingStartLettersOnNestedProperty_NameComponent component;

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_MultiplePropertiesOfSameTypeWithMatchingStartLettersOnNestedProperty(String variable) {
        this(MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.MultiplePropertiesOfSameTypeWithMatchingStartLettersOnNestedProperty.class, forVariable(variable), INITS);
    }

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_MultiplePropertiesOfSameTypeWithMatchingStartLettersOnNestedProperty(Path<? extends MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.MultiplePropertiesOfSameTypeWithMatchingStartLettersOnNestedProperty> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_MultiplePropertiesOfSameTypeWithMatchingStartLettersOnNestedProperty(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_MultiplePropertiesOfSameTypeWithMatchingStartLettersOnNestedProperty(PathMetadata metadata, PathInits inits) {
        this(MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.MultiplePropertiesOfSameTypeWithMatchingStartLettersOnNestedProperty.class, metadata, inits);
    }

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_MultiplePropertiesOfSameTypeWithMatchingStartLettersOnNestedProperty(Class<? extends MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.MultiplePropertiesOfSameTypeWithMatchingStartLettersOnNestedProperty> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.component = inits.isInitialized("component") ? new QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_MultiplePropertiesOfSameTypeWithMatchingStartLettersOnNestedProperty_NameComponent(forProperty("component")) : null;
    }

}

