package com.cjyong.pcw.cp.main.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA By
 * User: cjyong
 * Date: 2017/11/28
 * Time: 17:07
 * Description: pojo comment class which use to store user information in database.
 */
@Entity
@Table(name="cp_comment")
@Data
@Accessors(chain = true)
public class Comment implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    private Long useId;
    private Long createTime = System.currentTimeMillis();
    @NotNull
    @Lob
    private String content;
}
