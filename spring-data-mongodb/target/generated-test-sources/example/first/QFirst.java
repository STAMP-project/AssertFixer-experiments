package example.first;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QFirst is a Querydsl query type for First
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QFirst extends EntityPathBase<First> {

    private static final long serialVersionUID = 2046613326L;

    public static final QFirst first = new QFirst("first");

    public QFirst(String variable) {
        super(First.class, forVariable(variable));
    }

    public QFirst(Path<? extends First> path) {
        super(path.getType(), path.getMetadata());
    }

    public QFirst(PathMetadata metadata) {
        super(First.class, metadata);
    }

}

