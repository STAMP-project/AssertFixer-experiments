package org.springframework.data.mongodb.core.convert;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMappingMongoConverterUnitTests_ObjectContainer is a Querydsl query type for ObjectContainer
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMappingMongoConverterUnitTests_ObjectContainer extends EntityPathBase<MappingMongoConverterUnitTests.ObjectContainer> {

    private static final long serialVersionUID = -1104039864L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMappingMongoConverterUnitTests_ObjectContainer objectContainer = new QMappingMongoConverterUnitTests_ObjectContainer("objectContainer");

    public final QMappingMongoConverterUnitTests_PrimitiveContainer m_property;

    public QMappingMongoConverterUnitTests_ObjectContainer(String variable) {
        this(MappingMongoConverterUnitTests.ObjectContainer.class, forVariable(variable), INITS);
    }

    public QMappingMongoConverterUnitTests_ObjectContainer(Path<? extends MappingMongoConverterUnitTests.ObjectContainer> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMappingMongoConverterUnitTests_ObjectContainer(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMappingMongoConverterUnitTests_ObjectContainer(PathMetadata metadata, PathInits inits) {
        this(MappingMongoConverterUnitTests.ObjectContainer.class, metadata, inits);
    }

    public QMappingMongoConverterUnitTests_ObjectContainer(Class<? extends MappingMongoConverterUnitTests.ObjectContainer> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.m_property = inits.isInitialized("m_property") ? new QMappingMongoConverterUnitTests_PrimitiveContainer(forProperty("m_property")) : null;
    }

}

