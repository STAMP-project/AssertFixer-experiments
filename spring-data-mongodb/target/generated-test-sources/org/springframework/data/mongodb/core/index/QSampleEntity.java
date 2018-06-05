package org.springframework.data.mongodb.core.index;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QSampleEntity is a Querydsl query type for SampleEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSampleEntity extends EntityPathBase<SampleEntity> {

    private static final long serialVersionUID = -1996456225L;

    public static final QSampleEntity sampleEntity = new QSampleEntity("sampleEntity");

    public final StringPath id = createString("id");

    public final StringPath prop = createString("prop");

    public QSampleEntity(String variable) {
        super(SampleEntity.class, forVariable(variable));
    }

    public QSampleEntity(Path<? extends SampleEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSampleEntity(PathMetadata metadata) {
        super(SampleEntity.class, metadata);
    }

}

