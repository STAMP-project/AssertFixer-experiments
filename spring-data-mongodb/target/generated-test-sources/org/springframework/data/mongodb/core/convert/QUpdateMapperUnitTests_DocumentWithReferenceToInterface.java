package org.springframework.data.mongodb.core.convert;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUpdateMapperUnitTests_DocumentWithReferenceToInterface is a Querydsl query type for DocumentWithReferenceToInterface
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUpdateMapperUnitTests_DocumentWithReferenceToInterface extends EntityPathBase<UpdateMapperUnitTests.DocumentWithReferenceToInterface> {

    private static final long serialVersionUID = 1039963776L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUpdateMapperUnitTests_DocumentWithReferenceToInterface documentWithReferenceToInterface = new QUpdateMapperUnitTests_DocumentWithReferenceToInterface("documentWithReferenceToInterface");

    public final StringPath id = createString("id");

    public final QUpdateMapperUnitTests_InterfaceDocumentDefinitionWithoutId referencedDocument;

    public QUpdateMapperUnitTests_DocumentWithReferenceToInterface(String variable) {
        this(UpdateMapperUnitTests.DocumentWithReferenceToInterface.class, forVariable(variable), INITS);
    }

    public QUpdateMapperUnitTests_DocumentWithReferenceToInterface(Path<? extends UpdateMapperUnitTests.DocumentWithReferenceToInterface> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUpdateMapperUnitTests_DocumentWithReferenceToInterface(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUpdateMapperUnitTests_DocumentWithReferenceToInterface(PathMetadata metadata, PathInits inits) {
        this(UpdateMapperUnitTests.DocumentWithReferenceToInterface.class, metadata, inits);
    }

    public QUpdateMapperUnitTests_DocumentWithReferenceToInterface(Class<? extends UpdateMapperUnitTests.DocumentWithReferenceToInterface> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.referencedDocument = inits.isInitialized("referencedDocument") ? new QUpdateMapperUnitTests_InterfaceDocumentDefinitionWithoutId(forProperty("referencedDocument")) : null;
    }

}

