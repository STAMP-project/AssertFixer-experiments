package org.springframework.data.mongodb.core.index;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMongoPersistentEntityIndexResolverUnitTests_IndexResolutionTests_IndexOnLevelOneWithExplicitlyNamedField is a Querydsl query type for IndexOnLevelOneWithExplicitlyNamedField
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMongoPersistentEntityIndexResolverUnitTests_IndexResolutionTests_IndexOnLevelOneWithExplicitlyNamedField extends EntityPathBase<MongoPersistentEntityIndexResolverUnitTests.IndexResolutionTests.IndexOnLevelOneWithExplicitlyNamedField> {

    private static final long serialVersionUID = -102098147L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMongoPersistentEntityIndexResolverUnitTests_IndexResolutionTests_IndexOnLevelOneWithExplicitlyNamedField indexOnLevelOneWithExplicitlyNamedField = new QMongoPersistentEntityIndexResolverUnitTests_IndexResolutionTests_IndexOnLevelOneWithExplicitlyNamedField("indexOnLevelOneWithExplicitlyNamedField");

    public final QMongoPersistentEntityIndexResolverUnitTests_IndexResolutionTests_IndexOnLevelZeroWithExplicityNamedField zero;

    public QMongoPersistentEntityIndexResolverUnitTests_IndexResolutionTests_IndexOnLevelOneWithExplicitlyNamedField(String variable) {
        this(MongoPersistentEntityIndexResolverUnitTests.IndexResolutionTests.IndexOnLevelOneWithExplicitlyNamedField.class, forVariable(variable), INITS);
    }

    public QMongoPersistentEntityIndexResolverUnitTests_IndexResolutionTests_IndexOnLevelOneWithExplicitlyNamedField(Path<? extends MongoPersistentEntityIndexResolverUnitTests.IndexResolutionTests.IndexOnLevelOneWithExplicitlyNamedField> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMongoPersistentEntityIndexResolverUnitTests_IndexResolutionTests_IndexOnLevelOneWithExplicitlyNamedField(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMongoPersistentEntityIndexResolverUnitTests_IndexResolutionTests_IndexOnLevelOneWithExplicitlyNamedField(PathMetadata metadata, PathInits inits) {
        this(MongoPersistentEntityIndexResolverUnitTests.IndexResolutionTests.IndexOnLevelOneWithExplicitlyNamedField.class, metadata, inits);
    }

    public QMongoPersistentEntityIndexResolverUnitTests_IndexResolutionTests_IndexOnLevelOneWithExplicitlyNamedField(Class<? extends MongoPersistentEntityIndexResolverUnitTests.IndexResolutionTests.IndexOnLevelOneWithExplicitlyNamedField> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.zero = inits.isInitialized("zero") ? new QMongoPersistentEntityIndexResolverUnitTests_IndexResolutionTests_IndexOnLevelZeroWithExplicityNamedField(forProperty("zero")) : null;
    }

}

