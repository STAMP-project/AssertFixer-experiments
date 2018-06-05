package org.bson.types;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QBinary is a Querydsl query type for Binary
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QBinary extends BeanPath<Binary> {

    private static final long serialVersionUID = -1601576470L;

    public static final QBinary binary = new QBinary("binary");

    public final ArrayPath<byte[], Byte> data = createArray("data", byte[].class);

    public final NumberPath<Byte> type = createNumber("type", Byte.class);

    public QBinary(String variable) {
        super(Binary.class, forVariable(variable));
    }

    public QBinary(Path<? extends Binary> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBinary(PathMetadata metadata) {
        super(Binary.class, metadata);
    }

}

