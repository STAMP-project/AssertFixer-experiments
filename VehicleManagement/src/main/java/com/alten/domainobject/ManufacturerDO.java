package com.alten.domainobject;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(
    name = "manufacturer",
    uniqueConstraints = @UniqueConstraint(name = "uc_manufacturer_name", columnNames = {"name"}))
public class ManufacturerDO
{

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "Manufacturer name can not be null!")
    private String name;

    @Column(nullable = true)
    private String origin;

    @Column(nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private ZonedDateTime dateCreated = ZonedDateTime.now();



    @SuppressWarnings("unused")
    private ManufacturerDO()
    {}

    public ManufacturerDO(Long id, String name, String origin)
    {
        this.id = id;
        this.name = name;
        this.origin = origin;
    }


    public Long getId()
    {
        return id;
    }


    public void setId(Long id)
    {
        this.id = id;
    }


    public String getName()
    {
        return name;
    }


    public void setName(String name)
    {
        this.name = name;
    }


    public String getOrigin()
    {
        return origin;
    }


    public void setOrigin(String origin)
    {
        this.origin = origin;
    }

}
