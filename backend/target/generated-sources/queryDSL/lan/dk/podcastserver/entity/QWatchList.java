package lan.dk.podcastserver.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QWatchList is a Querydsl query type for WatchList
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QWatchList extends EntityPathBase<WatchList> {

    private static final long serialVersionUID = -204376933L;

    public static final QWatchList watchList = new QWatchList("watchList");

    public final ComparablePath<java.util.UUID> id = createComparable("id", java.util.UUID.class);

    public final SetPath<Item, QItem> items = this.<Item, QItem>createSet("items", Item.class, QItem.class, PathInits.DIRECT2);

    public final StringPath name = createString("name");

    public QWatchList(String variable) {
        super(WatchList.class, forVariable(variable));
    }

    public QWatchList(Path<? extends WatchList> path) {
        super(path.getType(), path.getMetadata());
    }

    public QWatchList(PathMetadata metadata) {
        super(WatchList.class, metadata);
    }

}

