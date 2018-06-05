package org.springframework.data.mongodb.core.convert;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMappingMongoConverterUnitTests_PrimitiveContainer is a Querydsl query type for PrimitiveContainer
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMappingMongoConverterUnitTests_PrimitiveContainer extends EntityPathBase<MappingMongoConverterUnitTests.PrimitiveContainer> {

    private static final long serialVersionUID = 532682068L;

    public static final QMappingMongoConverterUnitTests_PrimitiveContainer primitiveContainer = new QMappingMongoConverterUnitTests_PrimitiveContainer("primitiveContainer");

    public final NumberPath<Integer> m_property = createNumber("m_property", Integer.class);

    public QMappingMongoConverterUnitTests_PrimitiveContainer(String variable) {
        super(MappingMongoConverterUnitTests.PrimitiveContainer.class, forVariable(variable));
    }

    public QMappingMongoConverterUnitTests_PrimitiveContainer(Path<? extends MappingMongoConverterUnitTests.PrimitiveContainer> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMappingMongoConverterUnitTests_PrimitiveContainer(PathMetadata metadata) {
        super(MappingMongoConverterUnitTests.PrimitiveContainer.class, metadata);
    }

}

