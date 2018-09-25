package com.cjyong.pcw.cp.main.entity;

import com.cjyong.pcw.cp.main.entity.enums.DialySiginStatus;
import com.cjyong.pcw.cp.main.entity.enums.UserStatus;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA By
 * User: cjyong
 * Date: 2017/11/28
 * Time: 16:30
 * Description: pojo user class which use to store user information in database.
 */
@Entity
@Table(name="cp_user")
@Data
@Accessors(chain = true)
public class User implements Serializable{
    @Id
    private Long id;
    @NotNull
    @Column(unique = true)
    private String account;
    @NotNull
    private String password;
    @NotNull
    private String name;
    @NotNull
    private String tel;
    @NotNull
    private String email;
    private String address;
    private String qq;
    @Enumerated(EnumType.ORDINAL)
    private UserStatus status;
    @Enumerated(EnumType.ORDINAL)
    private DialySiginStatus dialySigin;
}
