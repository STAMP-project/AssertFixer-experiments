package com.cjyong.pcw.cp.main.entity;

/**
 * Created with IntelliJ IDEA By
 * User: cjyong
 * Date: 2017/12/7
 * Time: 16:20
 * Description: Album which store all photos
 */

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="cp_ablum")
@Data
@Accessors(chain = true)
public class Album implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true)
    private String title;
    @NotNull
    private Long useId;
    private Long createTime = System.currentTimeMillis();
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Comment> comments = new HashSet<>();
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Photo> photos = new HashSet<>();

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
