package lan.dk.podcastserver.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QItem is a Querydsl query type for Item
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QItem extends EntityPathBase<Item> {

    private static final long serialVersionUID = -1887629371L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QItem item = new QItem("item");

    public final QCover cover;

    public final QCover coverOfItemOrPodcast;

    public final SimplePath<io.vavr.control.Option<java.nio.file.Path>> coverPath = createSimple("coverPath", io.vavr.control.Option.class);

    public final DateTimePath<java.time.ZonedDateTime> creationDate = createDateTime("creationDate", java.time.ZonedDateTime.class);

    public final StringPath description = createString("description");

    public final DateTimePath<java.time.ZonedDateTime> downloadDate = createDateTime("downloadDate", java.time.ZonedDateTime.class);

    public final StringPath extension = createString("extension");

    public final StringPath fileName = createString("fileName");

    public final ComparablePath<java.util.UUID> id = createComparable("id", java.util.UUID.class);

    public final NumberPath<Long> length = createNumber("length", Long.class);

    public final SimplePath<java.nio.file.Path> localPath = createSimple("localPath", java.nio.file.Path.class);

    public final StringPath localUri = createString("localUri");

    public final StringPath mimeType = createString("mimeType");

    public final NumberPath<Integer> numberOfFail = createNumber("numberOfFail", Integer.class);

    public final QPodcast podcast;

    public final ComparablePath<java.util.UUID> podcastId = createComparable("podcastId", java.util.UUID.class);

    public final SimplePath<java.nio.file.Path> podcastPath = createSimple("podcastPath", java.nio.file.Path.class);

    public final StringPath proxyURLWithoutExtention = createString("proxyURLWithoutExtention");

    public final DateTimePath<java.time.ZonedDateTime> pubDate = createDateTime("pubDate", java.time.ZonedDateTime.class);

    public final EnumPath<Status> status = createEnum("status", Status.class);

    public final StringPath title = createString("title");

    public final StringPath url = createString("url");

    public final SetPath<WatchList, QWatchList> watchLists = this.<WatchList, QWatchList>createSet("watchLists", WatchList.class, QWatchList.class, PathInits.DIRECT2);

    public QItem(String variable) {
        this(Item.class, forVariable(variable), INITS);
    }

    public QItem(com.querydsl.core.types.Path<? extends Item> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QItem(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QItem(PathMetadata metadata, PathInits inits) {
        this(Item.class, metadata, inits);
    }

    public QItem(Class<? extends Item> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.cover = inits.isInitialized("cover") ? new QCover(forProperty("cover")) : null;
        this.coverOfItemOrPodcast = inits.isInitialized("coverOfItemOrPodcast") ? new QCover(forProperty("coverOfItemOrPodcast")) : null;
        this.podcast = inits.isInitialized("podcast") ? new QPodcast(forProperty("podcast"), inits.get("podcast")) : null;
    }

}

