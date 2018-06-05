package org.springframework.data.mongodb.core.index;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMongoPersistentEntityIndexResolverUnitTests_GeoSpatialIndexResolutionTests_GeoSpatialIndexOnLevelTwo is a Querydsl query type for GeoSpatialIndexOnLevelTwo
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMongoPersistentEntityIndexResolverUnitTests_GeoSpatialIndexResolutionTests_GeoSpatialIndexOnLevelTwo extends EntityPathBase<MongoPersistentEntityIndexResolverUnitTests.GeoSpatialIndexResolutionTests.GeoSpatialIndexOnLevelTwo> {

    private static final long serialVersionUID = 375683259L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMongoPersistentEntityIndexResolverUnitTests_GeoSpatialIndexResolutionTests_GeoSpatialIndexOnLevelTwo geoSpatialIndexOnLevelTwo = new QMongoPersistentEntityIndexResolverUnitTests_GeoSpatialIndexResolutionTests_GeoSpatialIndexOnLevelTwo("geoSpatialIndexOnLevelTwo");

    public final QMongoPersistentEntityIndexResolverUnitTests_GeoSpatialIndexResolutionTests_GeoSpatialIndexOnLevelOne one;

    public QMongoPersistentEntityIndexResolverUnitTests_GeoSpatialIndexResolutionTests_GeoSpatialIndexOnLevelTwo(String variable) {
        this(MongoPersistentEntityIndexResolverUnitTests.GeoSpatialIndexResolutionTests.GeoSpatialIndexOnLevelTwo.class, forVariable(variable), INITS);
    }

    public QMongoPersistentEntityIndexResolverUnitTests_GeoSpatialIndexResolutionTests_GeoSpatialIndexOnLevelTwo(Path<? extends MongoPersistentEntityIndexResolverUnitTests.GeoSpatialIndexResolutionTests.GeoSpatialIndexOnLevelTwo> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMongoPersistentEntityIndexResolverUnitTests_GeoSpatialIndexResolutionTests_GeoSpatialIndexOnLevelTwo(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMongoPersistentEntityIndexResolverUnitTests_GeoSpatialIndexResolutionTests_GeoSpatialIndexOnLevelTwo(PathMetadata metadata, PathInits inits) {
        this(MongoPersistentEntityIndexResolverUnitTests.GeoSpatialIndexResolutionTests.GeoSpatialIndexOnLevelTwo.class, metadata, inits);
    }

    public QMongoPersistentEntityIndexResolverUnitTests_GeoSpatialIndexResolutionTests_GeoSpatialIndexOnLevelTwo(Class<? extends MongoPersistentEntityIndexResolverUnitTests.GeoSpatialIndexResolutionTests.GeoSpatialIndexOnLevelTwo> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.one = inits.isInitialized("one") ? new QMongoPersistentEntityIndexResolverUnitTests_GeoSpatialIndexResolutionTests_GeoSpatialIndexOnLevelOne(forProperty("one"), inits.get("one")) : null;
    }

}

