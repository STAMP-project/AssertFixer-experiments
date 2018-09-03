package ru.job4j.tracker;

import java.sql.Time;
import java.util.List;

/**
 * Заявка
 * @version $Id$
 * @since 0.1
 */

// * Почему Id - это лонг, хотя заявок всего 100 шт.
// * как ползователь бдует вводить в строку это Id и не ошибаться
// * Это неудобно.

public class Item {
    public Item() {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public long getCreated() {
        return created;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    public List<String> getComments() {
        return comments;
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    }

   protected String id, name, desc;
   private long created;
   private List<String> comments;

   Item(String name, String desc, long created) {
       this.name = name;
       this.desc = desc;
       this.created = created;
   }
}
