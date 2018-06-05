package org.springframework.data.mongodb.core.convert;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QQueryMapperUnitTests_EmbeddedClass is a Querydsl query type for EmbeddedClass
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QQueryMapperUnitTests_EmbeddedClass extends BeanPath<QueryMapperUnitTests.EmbeddedClass> {

    private static final long serialVersionUID = -1964018299L;

    public static final QQueryMapperUnitTests_EmbeddedClass embeddedClass = new QQueryMapperUnitTests_EmbeddedClass("embeddedClass");

    public final StringPath customizedField = createString("customizedField");

    public final StringPath id = createString("id");

    public QQueryMapperUnitTests_EmbeddedClass(String variable) {
        super(QueryMapperUnitTests.EmbeddedClass.class, forVariable(variable));
    }

    public QQueryMapperUnitTests_EmbeddedClass(Path<? extends QueryMapperUnitTests.EmbeddedClass> path) {
        super(path.getType(), path.getMetadata());
    }

    public QQueryMapperUnitTests_EmbeddedClass(PathMetadata metadata) {
        super(QueryMapperUnitTests.EmbeddedClass.class, metadata);
    }

}

