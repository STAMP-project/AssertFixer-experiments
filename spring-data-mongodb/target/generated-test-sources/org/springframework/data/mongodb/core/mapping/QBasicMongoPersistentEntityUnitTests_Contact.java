package org.springframework.data.mongodb.core.mapping;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QBasicMongoPersistentEntityUnitTests_Contact is a Querydsl query type for Contact
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QBasicMongoPersistentEntityUnitTests_Contact extends EntityPathBase<BasicMongoPersistentEntityUnitTests.Contact> {

    private static final long serialVersionUID = -1023925351L;

    public static final QBasicMongoPersistentEntityUnitTests_Contact contact = new QBasicMongoPersistentEntityUnitTests_Contact("contact");

    public QBasicMongoPersistentEntityUnitTests_Contact(String variable) {
        super(BasicMongoPersistentEntityUnitTests.Contact.class, forVariable(variable));
    }

    public QBasicMongoPersistentEntityUnitTests_Contact(Path<? extends BasicMongoPersistentEntityUnitTests.Contact> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBasicMongoPersistentEntityUnitTests_Contact(PathMetadata metadata) {
        super(BasicMongoPersistentEntityUnitTests.Contact.class, metadata);
    }

}

