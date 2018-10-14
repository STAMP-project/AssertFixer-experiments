package com.cryptoeagle.entity;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = Item.GET_ALL, query = "SELECT item FROM Item  item order by item.publishDate desc "),
        @NamedQuery(name = Item.GET_BY_SOURCE, query = "SELECT item FROM Item item WHERE item.source =:source order by item.publishDate desc "),
        @NamedQuery(name = Item.GET_ALL_SOURCE, query = "SELECT DISTINCT item.source FROM Item item")
})

@Getter
@Setter
public class Item extends BaseEntity implements EntityWithPic {

    public final static String GET_ALL = "Item.GetAll";
    public final static String GET_BY_SOURCE = "Item.GetBySource";
    public final static String GET_ALL_SOURCE = "Item.GetAllSource";

    @NotNull
    @Column(unique = true)
    private String title;
    @NotNull
    private String description;
    @NotNull
    private LocalDateTime publishDate;
    @NotNull
    private String link;
    @NotNull
    private String source;

    public Item(String title, String description, LocalDateTime publishDate, String link) {
        this.title = title;
        this.description = description;
        this.publishDate = publishDate;
        this.link = link;
    }

    public Item() {
    }

    public int diffDays() {
        return Math.abs(LocalDateTime.now().getDayOfMonth() - publishDate.getDayOfMonth());
    }

    public int diffMinutes() {
        Duration between = Duration.between(LocalDateTime.now().toLocalTime(), publishDate.toLocalTime());
        return Math.abs(((int) between.toMinutes()));
    }

    public int diffHours() {
        Duration between = Duration.between(LocalDateTime.now().toLocalTime(), publishDate.toLocalTime());
        Period period = Period.between(LocalDateTime.now().toLocalDate(), publishDate.toLocalDate());
        int i = (int) between.toHours();
        return Math.abs(i);
    }

}
