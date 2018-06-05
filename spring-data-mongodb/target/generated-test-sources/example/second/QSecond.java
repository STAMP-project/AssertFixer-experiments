package example.second;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QSecond is a Querydsl query type for Second
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSecond extends EntityPathBase<Second> {

    private static final long serialVersionUID = -1249971766L;

    public static final QSecond second = new QSecond("second");

    public QSecond(String variable) {
        super(Second.class, forVariable(variable));
    }

    public QSecond(Path<? extends Second> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSecond(PathMetadata metadata) {
        super(Second.class, metadata);
    }

}

