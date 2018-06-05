package org.springframework.data.mongodb.core.mapping;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QBasicMongoPersistentEntityUnitTests_MappedWithExtension is a Querydsl query type for MappedWithExtension
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QBasicMongoPersistentEntityUnitTests_MappedWithExtension extends EntityPathBase<BasicMongoPersistentEntityUnitTests.MappedWithExtension> {

    private static final long serialVersionUID = 1570437279L;

    public static final QBasicMongoPersistentEntityUnitTests_MappedWithExtension mappedWithExtension = new QBasicMongoPersistentEntityUnitTests_MappedWithExtension("mappedWithExtension");

    public QBasicMongoPersistentEntityUnitTests_MappedWithExtension(String variable) {
        super(BasicMongoPersistentEntityUnitTests.MappedWithExtension.class, forVariable(variable));
    }

    public QBasicMongoPersistentEntityUnitTests_MappedWithExtension(Path<? extends BasicMongoPersistentEntityUnitTests.MappedWithExtension> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBasicMongoPersistentEntityUnitTests_MappedWithExtension(PathMetadata metadata) {
        super(BasicMongoPersistentEntityUnitTests.MappedWithExtension.class, metadata);
    }

}

