package org.springframework.data.mongodb.core;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QReactiveMongoTemplateIndexTests_IndexCreationShouldFail is a Querydsl query type for IndexCreationShouldFail
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QReactiveMongoTemplateIndexTests_IndexCreationShouldFail extends EntityPathBase<ReactiveMongoTemplateIndexTests.IndexCreationShouldFail> {

    private static final long serialVersionUID = 1408069154L;

    public static final QReactiveMongoTemplateIndexTests_IndexCreationShouldFail indexCreationShouldFail = new QReactiveMongoTemplateIndexTests_IndexCreationShouldFail("indexCreationShouldFail");

    public final StringPath field = createString("field");

    public final StringPath id = createString("id");

    public QReactiveMongoTemplateIndexTests_IndexCreationShouldFail(String variable) {
        super(ReactiveMongoTemplateIndexTests.IndexCreationShouldFail.class, forVariable(variable));
    }

    public QReactiveMongoTemplateIndexTests_IndexCreationShouldFail(Path<? extends ReactiveMongoTemplateIndexTests.IndexCreationShouldFail> path) {
        super(path.getType(), path.getMetadata());
    }

    public QReactiveMongoTemplateIndexTests_IndexCreationShouldFail(PathMetadata metadata) {
        super(ReactiveMongoTemplateIndexTests.IndexCreationShouldFail.class, metadata);
    }

}

