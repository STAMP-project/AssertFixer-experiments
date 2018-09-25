package com.cjyong.pcw.cp.main.entity;

import com.fasterxml.jackson.databind.annotation.JsonValueInstantiator;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA By
 * User: cjyong
 * Date: 2017/11/28
 * Time: 17:00
 * Description: pojo loveletter class which use to store user information in database.
 */
@Entity
@Table(name="cp_dailysentence")
@Data
@Accessors(chain = true)
public class DailySentence implements Serializable{
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

    public void addComment(Comment comment) {
        if (!comments.contains(comment)) {
            comments.add(comment);
        }
    }
}
