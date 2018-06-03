package com.alten.service.lookups;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.alten.dataaccessobject.ManufacturerRepository;
import com.alten.datatransferobject.ManufacturerDTO;
import com.alten.exception.ConfigurationException;
import com.alten.mapper.ManufacturerMapper;
import com.alten.util.Helper;

/**
 * The lookup service.Implementation for handling all business for retrieving
 * lookups.
 */
@Service
public class LookupServiceImpl implements LookupService {

	private final ManufacturerRepository manufacturerRepository;

	/**
	 * <p>
	 * This is the constructor of <code>LookupServiceImpl</code> class with
	 * manufacturerRepository argument.
	 * </p>
	 *
	 * @param manufacturerRepository
	 *            the Manufacturer repository for handling the persistency layer.
	 */
	@Autowired
	public LookupServiceImpl(final ManufacturerRepository manufacturerRepository) {
		this.manufacturerRepository = manufacturerRepository;
	}

	/**
	 * Check if all required fields are initialized properly.
	 *
	 * @throws ConfigurationException
	 *             if any required field is not initialized properly.
	 * @throws javax.naming.ConfigurationException
	 */
	@PostConstruct
	protected void checkConfiguration() throws ConfigurationException, javax.naming.ConfigurationException {
		Helper.checkConfigNotNull(manufacturerRepository, "manufacturerRepository");
	}

	/**
	 * This method is used to get all vehicle's manufacturers.
	 *
	 * @return the lookups for manufacturers.
	 */
	@Override
	public List<ManufacturerDTO> getAllManufacturers() {
		return ManufacturerMapper.makeManufacturerDTOList(Lists.newArrayList(manufacturerRepository.findAll()));
	}

}
