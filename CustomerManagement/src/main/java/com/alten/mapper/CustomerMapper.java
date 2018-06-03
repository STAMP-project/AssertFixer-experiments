package com.alten.mapper;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.alten.datatranssferobject.AddressDTO;
import com.alten.datatranssferobject.CustomerDTO;
import com.alten.domainobject.AddressDO;
import com.alten.domainobject.CustomerDO;

public final class CustomerMapper {
	public static CustomerDO makeCustomerDO(CustomerDTO customerDTO) {
		AddressDO address = AddressMapper.makeAddressDO(customerDTO.getAddress());
		return new CustomerDO(customerDTO.getName(), customerDTO.getCustomerType(), address);
	}

	public static CustomerDTO makeCustomerDTO(CustomerDO customerDO) {
		AddressDTO address = AddressMapper.makeAddressDTO(customerDO.getAddress());
		return new CustomerDTO(customerDO.getId(), customerDO.getName(), customerDO.getCustomerType(), address);

	}

	public static List<CustomerDTO> makeCustomerDTOList(Collection<CustomerDO> customers) {
		return customers.stream().map(CustomerMapper::makeCustomerDTO).collect(Collectors.toList());
	}
}
