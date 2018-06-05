package org.springframework.data.mongodb.core.query;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QTextQueryTests_FullTextDoc is a Querydsl query type for FullTextDoc
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTextQueryTests_FullTextDoc extends EntityPathBase<TextQueryTests.FullTextDoc> {

    private static final long serialVersionUID = 1339170800L;

    public static final QTextQueryTests_FullTextDoc fullTextDoc = new QTextQueryTests_FullTextDoc("fullTextDoc");

    public final StringPath body = createString("body");

    public final StringPath headline = createString("headline");

    public final StringPath id = createString("id");

    public final StringPath language = createString("language");

    public final NumberPath<Float> score = createNumber("score", Float.class);

    public final StringPath subheadline = createString("subheadline");

    public QTextQueryTests_FullTextDoc(String variable) {
        super(TextQueryTests.FullTextDoc.class, forVariable(variable));
    }

    public QTextQueryTests_FullTextDoc(Path<? extends TextQueryTests.FullTextDoc> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTextQueryTests_FullTextDoc(PathMetadata metadata) {
        super(TextQueryTests.FullTextDoc.class, metadata);
    }

}

