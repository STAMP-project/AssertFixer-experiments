package org.springframework.data.mongodb.core.index;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMongoPersistentEntityIndexCreatorUnitTests_EntityWithGeneratedIndexName is a Querydsl query type for EntityWithGeneratedIndexName
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMongoPersistentEntityIndexCreatorUnitTests_EntityWithGeneratedIndexName extends EntityPathBase<MongoPersistentEntityIndexCreatorUnitTests.EntityWithGeneratedIndexName> {

    private static final long serialVersionUID = -1179495170L;

    public static final QMongoPersistentEntityIndexCreatorUnitTests_EntityWithGeneratedIndexName entityWithGeneratedIndexName = new QMongoPersistentEntityIndexCreatorUnitTests_EntityWithGeneratedIndexName("entityWithGeneratedIndexName");

    public final StringPath lastname = createString("lastname");

    public QMongoPersistentEntityIndexCreatorUnitTests_EntityWithGeneratedIndexName(String variable) {
        super(MongoPersistentEntityIndexCreatorUnitTests.EntityWithGeneratedIndexName.class, forVariable(variable));
    }

    public QMongoPersistentEntityIndexCreatorUnitTests_EntityWithGeneratedIndexName(Path<? extends MongoPersistentEntityIndexCreatorUnitTests.EntityWithGeneratedIndexName> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMongoPersistentEntityIndexCreatorUnitTests_EntityWithGeneratedIndexName(PathMetadata metadata) {
        super(MongoPersistentEntityIndexCreatorUnitTests.EntityWithGeneratedIndexName.class, metadata);
    }

}

