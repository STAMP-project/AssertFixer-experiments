package com.adrisson.intelligentpoint.api.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;



@Entity
@Table(name="company")
public class Company implements Serializable {
	
	private static final long serialVersionUID = 3960436649365666213L;
	
	private Long id;
	private String socialReason;
	private String cnpj;
	private Date dateCreate;
	private Date dateUpdate;
	private List<Functionary> Functionaries;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(name="social_reason", nullable=false)
	public String getSocialReason() {
		return socialReason;
	}
	
	public void setSocialReason(String socialReason) {
		this.socialReason = socialReason;
	}
	
	@Column(name="cnpj",nullable=false)
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
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
	@OneToMany(mappedBy = "company", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public List<Functionary> getFunctionaries() {
		return Functionaries;
	}
	public void setFunctionaries(List<Functionary> functionaries) {
		Functionaries = functionaries;
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
		return "Company [id=" + id + ", socialReason=" + socialReason + ", cnpj=" + cnpj + ", dateCreate=" + dateCreate
				+ ", dateUpdate=" + dateUpdate + ", Functionaries=" + Functionaries + "]";
	}

    
    
}
