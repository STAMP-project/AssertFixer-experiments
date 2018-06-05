package org.springframework.data.mongodb.core.index;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMongoPersistentEntityIndexResolverUnitTests_IndexResolutionTests_IndexOnLevelZeroWithExplicityNamedField is a Querydsl query type for IndexOnLevelZeroWithExplicityNamedField
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QMongoPersistentEntityIndexResolverUnitTests_IndexResolutionTests_IndexOnLevelZeroWithExplicityNamedField extends BeanPath<MongoPersistentEntityIndexResolverUnitTests.IndexResolutionTests.IndexOnLevelZeroWithExplicityNamedField> {

    private static final long serialVersionUID = -633107641L;

    public static final QMongoPersistentEntityIndexResolverUnitTests_IndexResolutionTests_IndexOnLevelZeroWithExplicityNamedField indexOnLevelZeroWithExplicityNamedField = new QMongoPersistentEntityIndexResolverUnitTests_IndexResolutionTests_IndexOnLevelZeroWithExplicityNamedField("indexOnLevelZeroWithExplicityNamedField");

    public final StringPath namedProperty = createString("namedProperty");

    public QMongoPersistentEntityIndexResolverUnitTests_IndexResolutionTests_IndexOnLevelZeroWithExplicityNamedField(String variable) {
        super(MongoPersistentEntityIndexResolverUnitTests.IndexResolutionTests.IndexOnLevelZeroWithExplicityNamedField.class, forVariable(variable));
    }

    public QMongoPersistentEntityIndexResolverUnitTests_IndexResolutionTests_IndexOnLevelZeroWithExplicityNamedField(Path<? extends MongoPersistentEntityIndexResolverUnitTests.IndexResolutionTests.IndexOnLevelZeroWithExplicityNamedField> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMongoPersistentEntityIndexResolverUnitTests_IndexResolutionTests_IndexOnLevelZeroWithExplicityNamedField(PathMetadata metadata) {
        super(MongoPersistentEntityIndexResolverUnitTests.IndexResolutionTests.IndexOnLevelZeroWithExplicityNamedField.class, metadata);
    }

}

