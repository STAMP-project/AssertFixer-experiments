package org.springframework.data.mongodb.core.index;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_DocumentWithNamedIndex is a Querydsl query type for DocumentWithNamedIndex
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_DocumentWithNamedIndex extends EntityPathBase<MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.DocumentWithNamedIndex> {

    private static final long serialVersionUID = -1285097289L;

    public static final QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_DocumentWithNamedIndex documentWithNamedIndex = new QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_DocumentWithNamedIndex("documentWithNamedIndex");

    public final StringPath property = createString("property");

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_DocumentWithNamedIndex(String variable) {
        super(MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.DocumentWithNamedIndex.class, forVariable(variable));
    }

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_DocumentWithNamedIndex(Path<? extends MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.DocumentWithNamedIndex> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMongoPersistentEntityIndexResolverUnitTests_MixedIndexResolutionTests_DocumentWithNamedIndex(PathMetadata metadata) {
        super(MongoPersistentEntityIndexResolverUnitTests.MixedIndexResolutionTests.DocumentWithNamedIndex.class, metadata);
    }

}

