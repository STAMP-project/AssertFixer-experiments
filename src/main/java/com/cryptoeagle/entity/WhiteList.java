package com.cryptoeagle.entity;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


@Entity
@NamedQueries({
        @NamedQuery(name = WhiteList.GET_ALL, query = "select whitelist from WhiteList whitelist")
})
@Getter
@Setter
public class WhiteList extends BaseEntity implements Comparable<WhiteList> {

    public static final String GET_ALL = "Get.All";

    private String status;
    private String name;
    private String logo;
    private String category;


    @Override
    public int compareTo(WhiteList o) {
        return this.name.length() - o.name.length();
    }

}
