package org.springframework.data.mongodb.repository;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QUserWithComplexIdRepository_ComposedQueryAnnotation is a Querydsl query type for ComposedQueryAnnotation
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUserWithComplexIdRepository_ComposedQueryAnnotation extends EntityPathBase<UserWithComplexIdRepository.ComposedQueryAnnotation> {

    private static final long serialVersionUID = 128096848L;

    public static final QUserWithComplexIdRepository_ComposedQueryAnnotation composedQueryAnnotation = new QUserWithComplexIdRepository_ComposedQueryAnnotation("composedQueryAnnotation");

    public QUserWithComplexIdRepository_ComposedQueryAnnotation(String variable) {
        super(UserWithComplexIdRepository.ComposedQueryAnnotation.class, forVariable(variable));
    }

    public QUserWithComplexIdRepository_ComposedQueryAnnotation(Path<? extends UserWithComplexIdRepository.ComposedQueryAnnotation> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUserWithComplexIdRepository_ComposedQueryAnnotation(PathMetadata metadata) {
        super(UserWithComplexIdRepository.ComposedQueryAnnotation.class, metadata);
    }

}

