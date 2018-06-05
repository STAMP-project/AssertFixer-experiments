package org.springframework.data.mongodb.core.convert;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QQueryMapperUnitTests_Foo is a Querydsl query type for Foo
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QQueryMapperUnitTests_Foo extends EntityPathBase<QueryMapperUnitTests.Foo> {

    private static final long serialVersionUID = 1990538749L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QQueryMapperUnitTests_Foo foo = new QQueryMapperUnitTests_Foo("foo");

    public final QQueryMapperUnitTests_EmbeddedClass embedded;

    public final org.bson.types.QObjectId id;

    public final ListPath<QueryMapperUnitTests.EmbeddedClass, QQueryMapperUnitTests_EmbeddedClass> listOfItems = this.<QueryMapperUnitTests.EmbeddedClass, QQueryMapperUnitTests_EmbeddedClass>createList("listOfItems", QueryMapperUnitTests.EmbeddedClass.class, QQueryMapperUnitTests_EmbeddedClass.class, PathInits.DIRECT2);

    public QQueryMapperUnitTests_Foo(String variable) {
        this(QueryMapperUnitTests.Foo.class, forVariable(variable), INITS);
    }

    public QQueryMapperUnitTests_Foo(Path<? extends QueryMapperUnitTests.Foo> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QQueryMapperUnitTests_Foo(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QQueryMapperUnitTests_Foo(PathMetadata metadata, PathInits inits) {
        this(QueryMapperUnitTests.Foo.class, metadata, inits);
    }

    public QQueryMapperUnitTests_Foo(Class<? extends QueryMapperUnitTests.Foo> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.embedded = inits.isInitialized("embedded") ? new QQueryMapperUnitTests_EmbeddedClass(forProperty("embedded")) : null;
        this.id = inits.isInitialized("id") ? new org.bson.types.QObjectId(forProperty("id")) : null;
    }

}

