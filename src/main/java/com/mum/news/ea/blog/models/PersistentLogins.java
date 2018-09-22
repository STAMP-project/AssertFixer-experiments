package com.mum.news.ea.blog.models;

import javax.persistence.*;
import java.util.Date;

/**
 * User: franc
 * Date: 21/09/2018
 * Time: 6:11
 */
@Entity(name = "persistent_logins")
public class PersistentLogins {
    @Column(name = "username")
    private String username;
    @Id
    @Column(name = "series")
    private String series;
    @Column(name = "token")
    private String token;

    @Temporal(TemporalType.TIMESTAMP)
    private Date last_used;

    public PersistentLogins() {


    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getLast_used() {
        return last_used;
    }

    public void setLast_used(Date last_used) {
        this.last_used = last_used;
    }
}
