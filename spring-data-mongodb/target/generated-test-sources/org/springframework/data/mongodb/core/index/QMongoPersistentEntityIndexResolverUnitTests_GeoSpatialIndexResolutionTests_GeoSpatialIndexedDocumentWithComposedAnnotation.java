package org.springframework.data.mongodb.core.index;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMongoPersistentEntityIndexResolverUnitTests_GeoSpatialIndexResolutionTests_GeoSpatialIndexedDocumentWithComposedAnnotation is a Querydsl query type for GeoSpatialIndexedDocumentWithComposedAnnotation
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMongoPersistentEntityIndexResolverUnitTests_GeoSpatialIndexResolutionTests_GeoSpatialIndexedDocumentWithComposedAnnotation extends EntityPathBase<MongoPersistentEntityIndexResolverUnitTests.GeoSpatialIndexResolutionTests.GeoSpatialIndexedDocumentWithComposedAnnotation> {

    private static final long serialVersionUID = 33692469L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMongoPersistentEntityIndexResolverUnitTests_GeoSpatialIndexResolutionTests_GeoSpatialIndexedDocumentWithComposedAnnotation geoSpatialIndexedDocumentWithComposedAnnotation = new QMongoPersistentEntityIndexResolverUnitTests_GeoSpatialIndexResolutionTests_GeoSpatialIndexedDocumentWithComposedAnnotation("geoSpatialIndexedDocumentWithComposedAnnotation");

    public final org.springframework.data.geo.QPoint location;

    public QMongoPersistentEntityIndexResolverUnitTests_GeoSpatialIndexResolutionTests_GeoSpatialIndexedDocumentWithComposedAnnotation(String variable) {
        this(MongoPersistentEntityIndexResolverUnitTests.GeoSpatialIndexResolutionTests.GeoSpatialIndexedDocumentWithComposedAnnotation.class, forVariable(variable), INITS);
    }

    public QMongoPersistentEntityIndexResolverUnitTests_GeoSpatialIndexResolutionTests_GeoSpatialIndexedDocumentWithComposedAnnotation(Path<? extends MongoPersistentEntityIndexResolverUnitTests.GeoSpatialIndexResolutionTests.GeoSpatialIndexedDocumentWithComposedAnnotation> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMongoPersistentEntityIndexResolverUnitTests_GeoSpatialIndexResolutionTests_GeoSpatialIndexedDocumentWithComposedAnnotation(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMongoPersistentEntityIndexResolverUnitTests_GeoSpatialIndexResolutionTests_GeoSpatialIndexedDocumentWithComposedAnnotation(PathMetadata metadata, PathInits inits) {
        this(MongoPersistentEntityIndexResolverUnitTests.GeoSpatialIndexResolutionTests.GeoSpatialIndexedDocumentWithComposedAnnotation.class, metadata, inits);
    }

    public QMongoPersistentEntityIndexResolverUnitTests_GeoSpatialIndexResolutionTests_GeoSpatialIndexedDocumentWithComposedAnnotation(Class<? extends MongoPersistentEntityIndexResolverUnitTests.GeoSpatialIndexResolutionTests.GeoSpatialIndexedDocumentWithComposedAnnotation> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.location = inits.isInitialized("location") ? new org.springframework.data.geo.QPoint(forProperty("location")) : null;
    }

}

