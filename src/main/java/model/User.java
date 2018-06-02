package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class User implements Serializable{

    //@Column(name="first name", length=100000)
    private String _firstName;

    //@Column(name="last name", length=100000)
    private String _lastName;

    @Id
    private String userName;

    @Column(unique = true)
    private String _email;

    //@Column(name="password", length=16)
    private String _password;

    //@Column(name="verification code", length=100)
    private String _code;

    public User(String firstName, String lastName, String username, String email, String password, String cod) {
        _firstName = firstName;
        _lastName = lastName;
        userName = username;
        _email = email;
        _password = password;
        _code = cod;
    }

    protected User() {
    }

    public void setName (String name){
        this._firstName= name;
    }

    public void setSurName (String surName){
        this._lastName= surName;
    }

    public void setUserName (String usrName){
        this.userName= usrName;
    }

    public void setEmail (String emailAddress){
        this._email= emailAddress;
    }

    public void setPassword(String pass){
        this._password= pass;
    }

    public void setCode(String cod){
        this._code= cod;
    }

    public String getName(){
        return this._firstName;
    }

    public String getSurname(){
        return this._lastName;
    }

    public String getUserName(){
        return this.userName;
    }

    public String getEmail(){
        return this._email;
    }

    public String getPassword(){
        return this._password;
    }

    public String getCode(){
        return this._code;
    }

    public void limpiarCodigo() {
        _code = null;
    }

    @Override
    public int hashCode() {
        return this.userName.hashCode();
    }


}
