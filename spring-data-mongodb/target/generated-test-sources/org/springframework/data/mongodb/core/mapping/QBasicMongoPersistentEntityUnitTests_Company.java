package org.springframework.data.mongodb.core.mapping;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QBasicMongoPersistentEntityUnitTests_Company is a Querydsl query type for Company
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QBasicMongoPersistentEntityUnitTests_Company extends EntityPathBase<BasicMongoPersistentEntityUnitTests.Company> {

    private static final long serialVersionUID = -1024967690L;

    public static final QBasicMongoPersistentEntityUnitTests_Company company = new QBasicMongoPersistentEntityUnitTests_Company("company");

    public QBasicMongoPersistentEntityUnitTests_Company(String variable) {
        super(BasicMongoPersistentEntityUnitTests.Company.class, forVariable(variable));
    }

    public QBasicMongoPersistentEntityUnitTests_Company(Path<? extends BasicMongoPersistentEntityUnitTests.Company> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBasicMongoPersistentEntityUnitTests_Company(PathMetadata metadata) {
        super(BasicMongoPersistentEntityUnitTests.Company.class, metadata);
    }

}

