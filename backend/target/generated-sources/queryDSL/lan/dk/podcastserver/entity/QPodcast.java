package lan.dk.podcastserver.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPodcast is a Querydsl query type for Podcast
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPodcast extends EntityPathBase<Podcast> {

    private static final long serialVersionUID = 1413503250L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPodcast podcast = new QPodcast("podcast");

    public final QCover cover;

    public final StringPath description = createString("description");

    public final BooleanPath hasToBeDeleted = createBoolean("hasToBeDeleted");

    public final ComparablePath<java.util.UUID> id = createComparable("id", java.util.UUID.class);

    public final SetPath<Item, QItem> items = this.<Item, QItem>createSet("items", Item.class, QItem.class, PathInits.DIRECT2);

    public final DateTimePath<java.time.ZonedDateTime> lastUpdate = createDateTime("lastUpdate", java.time.ZonedDateTime.class);

    public final StringPath signature = createString("signature");

    public final SetPath<Tag, QTag> tags = this.<Tag, QTag>createSet("tags", Tag.class, QTag.class, PathInits.DIRECT2);

    public final StringPath title = createString("title");

    public final StringPath type = createString("type");

    public final StringPath url = createString("url");

    public QPodcast(String variable) {
        this(Podcast.class, forVariable(variable), INITS);
    }

    public QPodcast(Path<? extends Podcast> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPodcast(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPodcast(PathMetadata metadata, PathInits inits) {
        this(Podcast.class, metadata, inits);
    }

    public QPodcast(Class<? extends Podcast> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.cover = inits.isInitialized("cover") ? new QCover(forProperty("cover")) : null;
    }

}

