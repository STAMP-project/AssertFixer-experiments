package com.alten.domainobject;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "vehicle", uniqueConstraints = @UniqueConstraint(name = "uc_vin_reg", columnNames = { "vin", "registerationNumber" }))
public class VehicleDO {
	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private ZonedDateTime dateCreated = ZonedDateTime.now();

	@Column(nullable = false)

	private Long customerId;

	@Column(nullable = false)
	@NotBlank(message = "vin must be provided.")
	private String vin;

	@Column(nullable = false)
	@NotBlank(message = "registerationNumber must be provided.")
	private String registerationNumber;

	@ManyToOne
	@JoinColumn(name = "MANUFACTURER_ID", nullable = false)
	@NotNull(message = "Manufacturer can not be null!")
	private ManufacturerDO manufacturer;

	@Column(nullable = true)
	private String model;

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public VehicleDO() {

	}

	public VehicleDO(Long customerId, @NotBlank(message = "vin must be provided.") String vin,
			@NotBlank(message = "registerationNumber must be provided.") String registerationNumber,
			@NotNull(message = "Manufacturer can not be null!") ManufacturerDO manufacturer, String model) {

		this.customerId = customerId;
		this.vin = vin;
		this.registerationNumber = registerationNumber;
		this.manufacturer = manufacturer;
		this.model = model;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ZonedDateTime getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(ZonedDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public String getRegisterationNumber() {
		return registerationNumber;
	}

	public void setRegisterationNumber(String registerationNumber) {
		this.registerationNumber = registerationNumber;
	}

	public ManufacturerDO getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(ManufacturerDO manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

}
