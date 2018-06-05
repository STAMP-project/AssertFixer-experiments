package org.springframework.data.mongodb.core.index;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMongoPersistentEntityIndexCreatorUnitTests_Milk is a Querydsl query type for Milk
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMongoPersistentEntityIndexCreatorUnitTests_Milk extends EntityPathBase<MongoPersistentEntityIndexCreatorUnitTests.Milk> {

    private static final long serialVersionUID = -152875710L;

    public static final QMongoPersistentEntityIndexCreatorUnitTests_Milk milk = new QMongoPersistentEntityIndexCreatorUnitTests_Milk("milk");

    public final DateTimePath<java.util.Date> expiry = createDateTime("expiry", java.util.Date.class);

    public QMongoPersistentEntityIndexCreatorUnitTests_Milk(String variable) {
        super(MongoPersistentEntityIndexCreatorUnitTests.Milk.class, forVariable(variable));
    }

    public QMongoPersistentEntityIndexCreatorUnitTests_Milk(Path<? extends MongoPersistentEntityIndexCreatorUnitTests.Milk> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMongoPersistentEntityIndexCreatorUnitTests_Milk(PathMetadata metadata) {
        super(MongoPersistentEntityIndexCreatorUnitTests.Milk.class, metadata);
    }

}

