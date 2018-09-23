package com.adrisson.intelligentpoint.api.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.adrisson.intelligentpoint.api.enums.TypeEnum;

@Entity
@Table(name = "Launch")
public class Launch {
	private static final long serialVersionUID = 6524560251526772839L;

	private Long id;
	private Date date;
	private String description;
	private String location;
	private Date dateCreate;
	private Date dateUpdate;
	private TypeEnum type;
	private Functionary functionary;
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date", nullable = false)
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	@Column(name = "description", nullable = true)
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Column(name = "location", nullable = true)
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	@Column(name="date_create", nullable=false)
	public Date getDateCreate() {
		return dateCreate;
	}
	public void setDateCreate(Date dateCreate) {
		this.dateCreate = dateCreate;
	}
	
	@Column(name="date_update", nullable=false)
	public Date getDateUpdate() {
		return dateUpdate;
	}
	public void setDateUpdate(Date dateUpdate) {
		this.dateUpdate = dateUpdate;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "type", nullable = false)
	public TypeEnum getType() {
		return type;
	}
	public void setType(TypeEnum type) {
		this.type = type;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	public Functionary getFunctionary() {
		return functionary;
	}
	public void setFunctionary(Functionary functionary) {
		this.functionary = functionary;
	}
	
	@PreUpdate
    public void preUpdate() {
        dateUpdate = new Date();
    }
     
    @PrePersist
    public void prePersist() {
        final Date current = new Date();
        dateCreate = current;
        dateUpdate = current;
    }
	@Override
	public String toString() {
		return "Launch [id=" + id + ", date=" + date + ", description=" + description + ", location=" + location
				+ ", dateCreate=" + dateCreate + ", dateUpdate=" + dateUpdate + ", type=" + type + ", functionary="
				+ functionary + "]";
	}
	
	
}
