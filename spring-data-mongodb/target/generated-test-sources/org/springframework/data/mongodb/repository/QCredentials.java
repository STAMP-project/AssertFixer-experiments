package org.springframework.data.mongodb.repository;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCredentials is a Querydsl query type for Credentials
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QCredentials extends BeanPath<Credentials> {

    private static final long serialVersionUID = 303831825L;

    public static final QCredentials credentials = new QCredentials("credentials");

    public QCredentials(String variable) {
        super(Credentials.class, forVariable(variable));
    }

    public QCredentials(Path<? extends Credentials> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCredentials(PathMetadata metadata) {
        super(Credentials.class, metadata);
    }

}

