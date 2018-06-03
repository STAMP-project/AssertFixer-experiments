package com.alten.datatransferobject;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class VehicleDTO {
	@JsonIgnore
	private Long id;

	@NotNull
	private Long customerId;

	private String model;

	@NotNull(message = "Manufacturer can not be null!")
	private ManufacturerDTO manufacturer;

	@NotBlank(message = "vin must be provided.")
	private String vin;

	@NotBlank(message = "registerationNumber must be provided.")
	private String registerationNumber;

	public VehicleDTO() {
	}

	public VehicleDTO(Long id, Long customerId, String vin, String registerationNumber, String model,
			ManufacturerDTO manufacturer) {
		this.id = id;
		this.customerId = customerId;
		this.model = model;
		this.manufacturer = manufacturer;
		this.vin = vin;
		this.registerationNumber = registerationNumber;
	}

	@JsonProperty
	public Long getId() {
		return id;
	}

	public String getModel() {
		return model;
	}

	public ManufacturerDTO getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(ManufacturerDTO manufacturer) {
		this.manufacturer = manufacturer;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
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

}
