package com.alten.datatranssferobject;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.alten.domainvalue.CustomerType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerDTO {

	@JsonIgnore
	private Long id;
	
	@NotBlank(message="Customer name can not be empty")
	private String name;

	@NotBlank(message="Customer type can not be empty")
	private CustomerType customerType;

	@NotNull(message="Customer Address must be provided")
	private AddressDTO address;

	public CustomerDTO() {
	}

	public CustomerDTO(Long id, String name, CustomerType customerType, AddressDTO address) {
		this.id = id;
		this.name = name;
		this.customerType = customerType;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CustomerType getCustomerType() {
		return customerType;
	}

	public void setCustomerType(CustomerType customerType) {
		this.customerType = customerType;
	}

	public AddressDTO getAddress() {
		return address;
	}

	public void setAddress(AddressDTO address) {
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
