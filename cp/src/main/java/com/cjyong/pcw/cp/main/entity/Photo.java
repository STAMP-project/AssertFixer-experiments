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
 * Time: 17:18
 * Description: pojo photo class which use to store user information in database.
 */
@Entity
@Table(name="cp_photo")
@Data
@Accessors(chain = true)
public class Photo implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    private String url;
    private Long createTime = System.currentTimeMillis();
}
