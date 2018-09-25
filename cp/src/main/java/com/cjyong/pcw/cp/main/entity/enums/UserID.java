package com.cjyong.pcw.cp.main.entity.enums;

import java.io.Serializable;

public enum UserID implements Serializable {
    HUSBAND(1),
    WIFE(2);
    long id;
    UserID(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
