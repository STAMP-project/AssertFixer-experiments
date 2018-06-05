package org.springframework.data.mongodb.core.mapping.event;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QApplicationContextEventTests_Root is a Querydsl query type for Root
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QApplicationContextEventTests_Root extends EntityPathBase<ApplicationContextEventTests.Root> {

    private static final long serialVersionUID = 1815532000L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QApplicationContextEventTests_Root root = new QApplicationContextEventTests_Root("root");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<ApplicationContextEventTests.Related, QApplicationContextEventTests_Related> lazyListOfReferences = this.<ApplicationContextEventTests.Related, QApplicationContextEventTests_Related>createList("lazyListOfReferences", ApplicationContextEventTests.Related.class, QApplicationContextEventTests_Related.class, PathInits.DIRECT2);

    public final MapPath<String, ApplicationContextEventTests.Related, QApplicationContextEventTests_Related> lazyMapOfReferences = this.<String, ApplicationContextEventTests.Related, QApplicationContextEventTests_Related>createMap("lazyMapOfReferences", String.class, ApplicationContextEventTests.Related.class, QApplicationContextEventTests_Related.class);

    public final QApplicationContextEventTests_Related lazyReference;

    public final ListPath<ApplicationContextEventTests.Related, QApplicationContextEventTests_Related> listOfReferences = this.<ApplicationContextEventTests.Related, QApplicationContextEventTests_Related>createList("listOfReferences", ApplicationContextEventTests.Related.class, QApplicationContextEventTests_Related.class, PathInits.DIRECT2);

    public final MapPath<String, ApplicationContextEventTests.Related, QApplicationContextEventTests_Related> mapOfReferences = this.<String, ApplicationContextEventTests.Related, QApplicationContextEventTests_Related>createMap("mapOfReferences", String.class, ApplicationContextEventTests.Related.class, QApplicationContextEventTests_Related.class);

    public final QApplicationContextEventTests_Related reference;

    public QApplicationContextEventTests_Root(String variable) {
        this(ApplicationContextEventTests.Root.class, forVariable(variable), INITS);
    }

    public QApplicationContextEventTests_Root(Path<? extends ApplicationContextEventTests.Root> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QApplicationContextEventTests_Root(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QApplicationContextEventTests_Root(PathMetadata metadata, PathInits inits) {
        this(ApplicationContextEventTests.Root.class, metadata, inits);
    }

    public QApplicationContextEventTests_Root(Class<? extends ApplicationContextEventTests.Root> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.lazyReference = inits.isInitialized("lazyReference") ? new QApplicationContextEventTests_Related(forProperty("lazyReference")) : null;
        this.reference = inits.isInitialized("reference") ? new QApplicationContextEventTests_Related(forProperty("reference")) : null;
    }

}

