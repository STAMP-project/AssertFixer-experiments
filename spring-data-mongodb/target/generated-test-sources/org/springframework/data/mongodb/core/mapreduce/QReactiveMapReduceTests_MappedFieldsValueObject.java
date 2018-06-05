package org.springframework.data.mongodb.core.mapreduce;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QReactiveMapReduceTests_MappedFieldsValueObject is a Querydsl query type for MappedFieldsValueObject
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QReactiveMapReduceTests_MappedFieldsValueObject extends EntityPathBase<ReactiveMapReduceTests.MappedFieldsValueObject> {

    private static final long serialVersionUID = 1529140368L;

    public static final QReactiveMapReduceTests_MappedFieldsValueObject mappedFieldsValueObject = new QReactiveMapReduceTests_MappedFieldsValueObject("mappedFieldsValueObject");

    public final ArrayPath<String[], String> values = createArray("values", String[].class);

    public QReactiveMapReduceTests_MappedFieldsValueObject(String variable) {
        super(ReactiveMapReduceTests.MappedFieldsValueObject.class, forVariable(variable));
    }

    public QReactiveMapReduceTests_MappedFieldsValueObject(Path<? extends ReactiveMapReduceTests.MappedFieldsValueObject> path) {
        super(path.getType(), path.getMetadata());
    }

    public QReactiveMapReduceTests_MappedFieldsValueObject(PathMetadata metadata) {
        super(ReactiveMapReduceTests.MappedFieldsValueObject.class, metadata);
    }

}

