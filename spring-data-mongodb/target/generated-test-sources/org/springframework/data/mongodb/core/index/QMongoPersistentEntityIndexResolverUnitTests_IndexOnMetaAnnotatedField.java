package org.springframework.data.mongodb.core.index;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMongoPersistentEntityIndexResolverUnitTests_IndexOnMetaAnnotatedField is a Querydsl query type for IndexOnMetaAnnotatedField
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMongoPersistentEntityIndexResolverUnitTests_IndexOnMetaAnnotatedField extends EntityPathBase<MongoPersistentEntityIndexResolverUnitTests.IndexOnMetaAnnotatedField> {

    private static final long serialVersionUID = 1963979019L;

    public static final QMongoPersistentEntityIndexResolverUnitTests_IndexOnMetaAnnotatedField indexOnMetaAnnotatedField = new QMongoPersistentEntityIndexResolverUnitTests_IndexOnMetaAnnotatedField("indexOnMetaAnnotatedField");

    public final StringPath lastname = createString("lastname");

    public QMongoPersistentEntityIndexResolverUnitTests_IndexOnMetaAnnotatedField(String variable) {
        super(MongoPersistentEntityIndexResolverUnitTests.IndexOnMetaAnnotatedField.class, forVariable(variable));
    }

    public QMongoPersistentEntityIndexResolverUnitTests_IndexOnMetaAnnotatedField(Path<? extends MongoPersistentEntityIndexResolverUnitTests.IndexOnMetaAnnotatedField> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMongoPersistentEntityIndexResolverUnitTests_IndexOnMetaAnnotatedField(PathMetadata metadata) {
        super(MongoPersistentEntityIndexResolverUnitTests.IndexOnMetaAnnotatedField.class, metadata);
    }

}

