package com.alten.datatransferobject;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ManufacturerDTO {

	@JsonIgnore
	private Long id;

	@NotBlank(message = "Manufacturer name can not be empty!")
	private String name;

	private String origin;

	@SuppressWarnings("unused")
	private ManufacturerDTO() {

	}

	public ManufacturerDTO(Long id, String name, String origin) {
		this.id = id;
		this.name = name;
		this.origin = origin;
	}

	@JsonProperty
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

}
