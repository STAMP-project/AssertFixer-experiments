package com.cjyong.pcw.cp.main.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA By
 * User: cjyong
 * Date: 2017/11/28
 * Time: 17:15
 * Description: pojo dailyActivity class which use to store user information in database.
 */
@Entity
@Table(name="cp_activity")
@Data
public class DailyActivity implements Serializable{
    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    private Long useId;
    private Long createTime = System.currentTimeMillis();
    @NotNull
    @Lob
    private String content;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Comment> comments;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Photo> photos;

    public void addComment(Comment comment) {
        if (!comments.contains(comment)) {
            comments.add(comment);
        }
    }

    public void deleteComment(Comment comment) {
        if (comments.contains(comment)) {
            comments.remove(comment);
        }
    }

    public void addPhoto(Photo photo) {
        if (!photos.contains(photo)) {
            photos.add(photo);
        }
    }

    public void deletePhoto(Photo photo) {
        if (photos.contains(photo)) {
            photos.remove(photo);
        }
    }
}
