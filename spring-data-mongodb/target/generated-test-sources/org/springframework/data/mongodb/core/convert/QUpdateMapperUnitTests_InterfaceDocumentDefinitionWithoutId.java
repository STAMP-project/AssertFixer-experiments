package org.springframework.data.mongodb.core.convert;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QUpdateMapperUnitTests_InterfaceDocumentDefinitionWithoutId is a Querydsl query type for InterfaceDocumentDefinitionWithoutId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QUpdateMapperUnitTests_InterfaceDocumentDefinitionWithoutId extends BeanPath<UpdateMapperUnitTests.InterfaceDocumentDefinitionWithoutId> {

    private static final long serialVersionUID = -138800248L;

    public static final QUpdateMapperUnitTests_InterfaceDocumentDefinitionWithoutId interfaceDocumentDefinitionWithoutId = new QUpdateMapperUnitTests_InterfaceDocumentDefinitionWithoutId("interfaceDocumentDefinitionWithoutId");

    public final StringPath value = createString("value");

    public QUpdateMapperUnitTests_InterfaceDocumentDefinitionWithoutId(String variable) {
        super(UpdateMapperUnitTests.InterfaceDocumentDefinitionWithoutId.class, forVariable(variable));
    }

    public QUpdateMapperUnitTests_InterfaceDocumentDefinitionWithoutId(Path<? extends UpdateMapperUnitTests.InterfaceDocumentDefinitionWithoutId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUpdateMapperUnitTests_InterfaceDocumentDefinitionWithoutId(PathMetadata metadata) {
        super(UpdateMapperUnitTests.InterfaceDocumentDefinitionWithoutId.class, metadata);
    }

}

