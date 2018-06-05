package org.springframework.data.mongodb.core;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMongoTemplateTransactionTests_Assassin is a Querydsl query type for Assassin
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMongoTemplateTransactionTests_Assassin extends EntityPathBase<MongoTemplateTransactionTests.Assassin> {

    private static final long serialVersionUID = -357715592L;

    public static final QMongoTemplateTransactionTests_Assassin assassin = new QMongoTemplateTransactionTests_Assassin("assassin");

    public final StringPath id = createString("id");

    public final StringPath name = createString("name");

    public final BooleanPath new$ = createBoolean("new");

    public QMongoTemplateTransactionTests_Assassin(String variable) {
        super(MongoTemplateTransactionTests.Assassin.class, forVariable(variable));
    }

    public QMongoTemplateTransactionTests_Assassin(Path<? extends MongoTemplateTransactionTests.Assassin> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMongoTemplateTransactionTests_Assassin(PathMetadata metadata) {
        super(MongoTemplateTransactionTests.Assassin.class, metadata);
    }

}

