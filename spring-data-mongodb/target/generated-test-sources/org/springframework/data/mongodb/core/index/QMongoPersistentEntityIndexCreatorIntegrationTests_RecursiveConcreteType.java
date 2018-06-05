package org.springframework.data.mongodb.core.index;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMongoPersistentEntityIndexCreatorIntegrationTests_RecursiveConcreteType is a Querydsl query type for RecursiveConcreteType
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMongoPersistentEntityIndexCreatorIntegrationTests_RecursiveConcreteType extends EntityPathBase<MongoPersistentEntityIndexCreatorIntegrationTests.RecursiveConcreteType> {

    private static final long serialVersionUID = 418175174L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMongoPersistentEntityIndexCreatorIntegrationTests_RecursiveConcreteType recursiveConcreteType = new QMongoPersistentEntityIndexCreatorIntegrationTests_RecursiveConcreteType("recursiveConcreteType");

    public final QMongoPersistentEntityIndexCreatorIntegrationTests_RecursiveGenericType _super;

    //inherited
    public final StringPath firstName;

    //inherited
    public final NumberPath<Long> id;

    public final QMongoPersistentEntityIndexCreatorIntegrationTests_RecursiveConcreteType referrer;

    public QMongoPersistentEntityIndexCreatorIntegrationTests_RecursiveConcreteType(String variable) {
        this(MongoPersistentEntityIndexCreatorIntegrationTests.RecursiveConcreteType.class, forVariable(variable), INITS);
    }

    public QMongoPersistentEntityIndexCreatorIntegrationTests_RecursiveConcreteType(Path<? extends MongoPersistentEntityIndexCreatorIntegrationTests.RecursiveConcreteType> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMongoPersistentEntityIndexCreatorIntegrationTests_RecursiveConcreteType(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMongoPersistentEntityIndexCreatorIntegrationTests_RecursiveConcreteType(PathMetadata metadata, PathInits inits) {
        this(MongoPersistentEntityIndexCreatorIntegrationTests.RecursiveConcreteType.class, metadata, inits);
    }

    public QMongoPersistentEntityIndexCreatorIntegrationTests_RecursiveConcreteType(Class<? extends MongoPersistentEntityIndexCreatorIntegrationTests.RecursiveConcreteType> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new QMongoPersistentEntityIndexCreatorIntegrationTests_RecursiveGenericType(type, metadata, inits);
        this.firstName = _super.firstName;
        this.id = _super.id;
        this.referrer = inits.isInitialized("referrer") ? new QMongoPersistentEntityIndexCreatorIntegrationTests_RecursiveConcreteType(forProperty("referrer")) : null;
    }

}

