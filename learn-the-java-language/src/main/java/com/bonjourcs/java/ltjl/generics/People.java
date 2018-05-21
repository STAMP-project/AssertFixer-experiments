package com.bonjourcs.java.ltjl.generics;

import java.util.Date;

/**
 * @author Liang Chenghao
 * Description: class people which is comparable
 * Date: 2018/4/2
 */
public class People implements Comparable<People> {

    /**
     * name of people
     */
    private String name;
    /**
     * birth of people
     */
    private Date birth;

    public People(Date birth) {
        this.birth = birth;
    }

    public People(String name, Date birth) {
        this.name = name;
        this.birth = birth;
    }

    @Override
    public int compareTo(People o) {
        return this.getBirth().compareTo(o.getBirth());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

}
