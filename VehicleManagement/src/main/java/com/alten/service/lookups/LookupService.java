package com.alten.service.lookups;

import java.util.List;

import com.alten.datatransferobject.ManufacturerDTO;

/**
 * The lookup service for all lookups.
 */
public interface LookupService {

	/**
	 * This method is used to get all vehicle's manufacturers.
	 *
	 * @return the lookups for manufacturers.
	 */
	List<ManufacturerDTO> getAllManufacturers();
}
