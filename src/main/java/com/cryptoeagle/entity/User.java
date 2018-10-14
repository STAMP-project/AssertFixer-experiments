package com.cryptoeagle.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.*;

import static com.cryptoeagle.entity.BaseEntity.START_SEQ;


@Entity
@NamedQueries({
        @NamedQuery(name = User.DELETE, query = "DELETE FROM User u WHERE u.id=:id"),
        @NamedQuery(name = User.GET_ALL, query = "SELECT user FROM User user"),
        @NamedQuery(name = User.GET_BY_EMAIL, query = "SELECT user FROM User  user WHERE user.email=:email"),
        @NamedQuery(name = User.GET_BY_NAME, query = "SELECT user FROM User  user WHERE user.name=:name"),
        @NamedQuery(name = User.GET_BY_ID, query = "SELECT user FROM User user WHERE user.id=:id")
})
@Table(name = "appuser")
@Getter
@Setter
public class User extends BaseEntity implements UserDetails {


    public static final String DELETE = "User.delete";
    public static final String GET_BY_ID = "User.get";
    public static final String GET_BY_NAME = "User.getByName";
    public static final String GET_ALL = "User.getAll";
    public static final String GET_BY_EMAIL = "User.getByEmail";

    @Length(min = 5, max = 15)
    @Column(unique = true)
    private String name;
    @Column(unique = true)
    @NotBlank
    @NotNull
    private String email;
    @Length(min = 7)
    private String password;

    @OneToMany(cascade = CascadeType.ALL)
    Collection<Role> roles = new HashSet<>();

    @NotNull
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Blog> blogs = new ArrayList<>();

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public User() {
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String getPassword() {
        return password;
    }

}