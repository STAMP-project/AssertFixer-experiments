package com.alten.mapper;

import com.alten.datatranssferobject.AddressDTO;
import com.alten.domainobject.AddressDO;

public class AddressMapper {
	public static AddressDO makeAddressDO(AddressDTO addressDTO) {
		return new AddressDO(addressDTO.getAddressLine1(), addressDTO.getAddressLine2(), addressDTO.getCity(),
				addressDTO.getState(), addressDTO.getCountry(), addressDTO.getPostalCode());
	}

	public static AddressDTO makeAddressDTO(AddressDO addressDO) {
		return new AddressDTO(addressDO.getAddressLine1(), addressDO.getAddressLine2(), addressDO.getCity(),
				addressDO.getState(), addressDO.getCountry(), addressDO.getPostalCode());
	}

}
