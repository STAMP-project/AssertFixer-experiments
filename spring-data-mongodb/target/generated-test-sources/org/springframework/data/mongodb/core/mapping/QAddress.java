package org.springframework.data.mongodb.core.mapping;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QAddress is a Querydsl query type for Address
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QAddress extends BeanPath<Address> {

    private static final long serialVersionUID = 1558044030L;

    public static final QAddress address = new QAddress("address");

    public final StringPath city = createString("city");

    public final StringPath country = createString("country");

    public final StringPath id = createString("id");

    public final ArrayPath<String[], String> lines = createArray("lines", String[].class);

    public final NumberPath<Integer> postalCode = createNumber("postalCode", Integer.class);

    public final StringPath provinceOrState = createString("provinceOrState");

    public QAddress(String variable) {
        super(Address.class, forVariable(variable));
    }

    public QAddress(Path<? extends Address> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAddress(PathMetadata metadata) {
        super(Address.class, metadata);
    }

}

