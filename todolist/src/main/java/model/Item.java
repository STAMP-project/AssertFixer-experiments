package model;

import javax.persistence.Entity;
import java.sql.Timestamp;
@Entity
public class Item {
    private int id;
    private String desc;
    private Timestamp created;
    private boolean done;

    public Item() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public String  toString() {
        return "Id: '" + this.id + "', Desc: '" + this.desc + "', Created: '" + this.created + "', Done: '" + this.done;
    }
}