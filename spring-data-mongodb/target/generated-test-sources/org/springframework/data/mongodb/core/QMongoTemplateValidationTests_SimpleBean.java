package org.springframework.data.mongodb.core;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMongoTemplateValidationTests_SimpleBean is a Querydsl query type for SimpleBean
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMongoTemplateValidationTests_SimpleBean extends EntityPathBase<MongoTemplateValidationTests.SimpleBean> {

    private static final long serialVersionUID = -1471801856L;

    public static final QMongoTemplateValidationTests_SimpleBean simpleBean = new QMongoTemplateValidationTests_SimpleBean("simpleBean");

    public final SimplePath<Object> customFieldName = createSimple("customFieldName", Object.class);

    public final StringPath nonNullString = createString("nonNullString");

    public final NumberPath<Integer> rangedInteger = createNumber("rangedInteger", Integer.class);

    public QMongoTemplateValidationTests_SimpleBean(String variable) {
        super(MongoTemplateValidationTests.SimpleBean.class, forVariable(variable));
    }

    public QMongoTemplateValidationTests_SimpleBean(Path<? extends MongoTemplateValidationTests.SimpleBean> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMongoTemplateValidationTests_SimpleBean(PathMetadata metadata) {
        super(MongoTemplateValidationTests.SimpleBean.class, metadata);
    }

}

