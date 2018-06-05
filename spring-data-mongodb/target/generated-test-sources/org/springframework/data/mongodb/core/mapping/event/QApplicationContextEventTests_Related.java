package org.springframework.data.mongodb.core.mapping.event;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QApplicationContextEventTests_Related is a Querydsl query type for Related
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QApplicationContextEventTests_Related extends EntityPathBase<ApplicationContextEventTests.Related> {

    private static final long serialVersionUID = -298859923L;

    public static final QApplicationContextEventTests_Related related = new QApplicationContextEventTests_Related("related");

    public final StringPath description = createString("description");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QApplicationContextEventTests_Related(String variable) {
        super(ApplicationContextEventTests.Related.class, forVariable(variable));
    }

    public QApplicationContextEventTests_Related(Path<? extends ApplicationContextEventTests.Related> path) {
        super(path.getType(), path.getMetadata());
    }

    public QApplicationContextEventTests_Related(PathMetadata metadata) {
        super(ApplicationContextEventTests.Related.class, metadata);
    }

}

