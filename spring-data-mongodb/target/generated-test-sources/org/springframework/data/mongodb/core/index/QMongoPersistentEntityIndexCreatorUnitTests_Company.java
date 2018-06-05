package org.springframework.data.mongodb.core.index;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMongoPersistentEntityIndexCreatorUnitTests_Company is a Querydsl query type for Company
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QMongoPersistentEntityIndexCreatorUnitTests_Company extends BeanPath<MongoPersistentEntityIndexCreatorUnitTests.Company> {

    private static final long serialVersionUID = -1767100938L;

    public static final QMongoPersistentEntityIndexCreatorUnitTests_Company company = new QMongoPersistentEntityIndexCreatorUnitTests_Company("company");

    public final SimplePath<MongoPersistentEntityIndexCreatorUnitTests.Address> address = createSimple("address", MongoPersistentEntityIndexCreatorUnitTests.Address.class);

    public final StringPath name = createString("name");

    public QMongoPersistentEntityIndexCreatorUnitTests_Company(String variable) {
        super(MongoPersistentEntityIndexCreatorUnitTests.Company.class, forVariable(variable));
    }

    public QMongoPersistentEntityIndexCreatorUnitTests_Company(Path<? extends MongoPersistentEntityIndexCreatorUnitTests.Company> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMongoPersistentEntityIndexCreatorUnitTests_Company(PathMetadata metadata) {
        super(MongoPersistentEntityIndexCreatorUnitTests.Company.class, metadata);
    }

}

