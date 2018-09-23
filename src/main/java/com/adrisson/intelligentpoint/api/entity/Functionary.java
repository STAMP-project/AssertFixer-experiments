package com.adrisson.intelligentpoint.api.entity;

import java.beans.Transient;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.adrisson.intelligentpoint.api.enums.ProfileEnum;

@Entity
@Table(name = "functionary")
public class Functionary {
	
	private static final long serialVersionUID = -5754246207015712518L;
	
	private Long id;
	private String name;
	private String email;
	private String password;
	private String cpf;
	private BigDecimal valueHour;
	private Float quantityHourWorked;
	private Float quantityHourLunch;
	private ProfileEnum profile;
	private Date dateCreate;
	private Date dateUpdate;
	private Company company;
	private List<Launch> Launches;
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "name", nullable = false)
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "email", nullable = false)
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name = "password", nullable = false)
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(name = "cpf", nullable = false)
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	@Column(name = "value_hour", nullable = false)
	public BigDecimal getValueHour() {
		return valueHour;
	}
	
	public void setValueHour(BigDecimal valueHour) {
		this.valueHour = valueHour;
	}
	
	@Column(name = "quantity_hour_worked", nullable = false)
	public Float getQuantityHourWorked() {
		return quantityHourWorked;
	}
	
	@Transient
	public Optional<Float> getQuantityHourWorkedOptional() {
		return Optional.ofNullable(quantityHourWorked);
	}
	
	public void setQuantityHourWorked(Float quantityHourWorked) {
		this.quantityHourWorked = quantityHourWorked;
	}
	
	@Column(name = "quantity_hour_lunch", nullable = false)
	public Float getQuantityHourLunch() {
		return  quantityHourLunch;
	}
	
	@Transient
	public Optional<Float> getQuantityHourLunchOptional() {
		return  Optional.ofNullable(quantityHourLunch);
	}
	
	public void setQuantityHourLunch(Float quantityHourLunch) {
		this.quantityHourLunch = quantityHourLunch;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "profile", nullable = false)
	public ProfileEnum getProfile() {
		return profile;
	}
	
	public void setProfile(ProfileEnum profile) {
		this.profile = profile;
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
	@ManyToOne(fetch = FetchType.EAGER)
	public Company getCompany() {
		return company;
	}
	
	public void setCompany(Company company) {
		this.company = company;
	}
	@OneToMany(mappedBy = "functionary", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public List<Launch> getLaunches() {
		return Launches;
	}
	
	public void setLaunches(List<Launch> launches) {
		Launches = launches;
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
		return "Functionary [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", cpf="
				+ cpf + ", valueHour=" + valueHour + ", quantityHourWorked=" + quantityHourWorked
				+ ", quantityHourLunch=" + quantityHourLunch + ", profile=" + profile + ", dateCreate=" + dateCreate
				+ ", dateUpdate=" + dateUpdate + ", company=" + company + ", Launches=" + Launches + "]";
	}	
	
	
	
}
