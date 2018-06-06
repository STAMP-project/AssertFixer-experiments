package lan.dk.podcastserver.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCover is a Querydsl query type for Cover
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCover extends EntityPathBase<Cover> {

    private static final long serialVersionUID = 1607357765L;

    public static final QCover cover = new QCover("cover");

    public final NumberPath<Integer> height = createNumber("height", Integer.class);

    public final ComparablePath<java.util.UUID> id = createComparable("id", java.util.UUID.class);

    public final StringPath url = createString("url");

    public final NumberPath<Integer> width = createNumber("width", Integer.class);

    public QCover(String variable) {
        super(Cover.class, forVariable(variable));
    }

    public QCover(Path<? extends Cover> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCover(PathMetadata metadata) {
        super(Cover.class, metadata);
    }

}

