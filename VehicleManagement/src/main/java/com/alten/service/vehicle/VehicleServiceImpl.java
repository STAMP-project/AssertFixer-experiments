package com.alten.service.vehicle;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.alten.dataaccessobject.VehicleRepository;
import com.alten.datatransferobject.VehicleDTO;
import com.alten.domainobject.VehicleDO;
import com.alten.exception.ConfigurationException;
import com.alten.exception.ConstraintsViolationException;
import com.alten.exception.EntityNotFoundException;
import com.alten.mapper.ManufacturerMapper;
import com.alten.mapper.VehicleMapper;
import com.alten.util.Helper;
import com.google.common.collect.Lists;

/**
 * Service to encapsulate the link between DAO and controller and to have
 * business logic for some vehicle specific things.
 * <p/>
 */
@Service
public class VehicleServiceImpl implements VehicleService {

	private final VehicleRepository vehicleRepository;

	/**
	 * <p>
	 * This is the constructor of <code>VehicleServiceImpl</code> class with
	 * VehicleRepository argument.
	 * </p>
	 *
	 * @param vehicleRepository
	 *            the Vehicle repository for handling the persistence layer.
	 */
	@Autowired
	public VehicleServiceImpl(final VehicleRepository vehicleRepository) {
		this.vehicleRepository = vehicleRepository;
	}

	/**
	 * Check if all required fields are initialized properly.
	 *
	 * @throws ConfigurationException
	 *             if any required field is not initialized properly.
	 * @throws javax.naming.ConfigurationException
	 */
	@PostConstruct
	protected void checkConfiguration() throws javax.naming.ConfigurationException {
		Helper.checkConfigNotNull(vehicleRepository, "vehicleRepository");
	}

	private VehicleDO findVehicleDOById(Long vehicleId) throws EntityNotFoundException {
		Helper.checkNull(vehicleId, "vehicleId");
		Helper.checkPositive(vehicleId, "vehicleId");
		Optional<VehicleDO> optionalVehicle = vehicleRepository.findById(vehicleId);
		if (!optionalVehicle.isPresent()) {
			throw new EntityNotFoundException("Could not find vehicle with id: " + vehicleId);
		}
		return optionalVehicle.get();
	}

	/**
	 * This method is used to retrieve a specific vehicle identified by vehicleId
	 *
	 * @param vehicleId
	 *            the id of the vehicle entity to retrieve
	 * @return the matched vehicle entity
	 * @throws IllegalArgumentException
	 *             if id is not positive
	 * @throws EntityNotFoundException
	 *             if the entity does not exist
	 */
	@Override
	public VehicleDTO findVehicleById(Long vehicleId) throws EntityNotFoundException {
		return VehicleMapper.makeVehicleDTO(findVehicleDOById(vehicleId));
	}

	/**
	 * This method is used to create an vehicle entity.
	 *
	 * @param vehicleDTO
	 *            the entity to create
	 * @return the created vehicle entity
	 * @throws IllegalArgumentException
	 *             if entity is null or not valid
	 * @throws ConstraintsViolationException
	 *             if any constraint has been violated
	 */
	@Override
	public VehicleDTO create(VehicleDTO vehicleDTO) throws ConstraintsViolationException {
		Helper.checkNull(vehicleDTO, "vehicleDTO");
		VehicleDO vehicleDO = VehicleMapper.makeVehicleDO(vehicleDTO);
		try {
			vehicleDO = vehicleRepository.save(vehicleDO);
		} catch (DataIntegrityViolationException e) {
			throw new ConstraintsViolationException(e.getMessage());
		}
		return VehicleMapper.makeVehicleDTO(vehicleDO);
	}

	/**
	 * This method is used to delete a vehicle entity using its id.
	 *
	 * @param vehicleId
	 *            the id of the vehicle entity to delete
	 * @throws IllegalArgumentException
	 *             if id is not positive
	 * @throws EntityNotFoundException
	 *             if the entity does not exist
	 */
	@Override
	public void delete(Long vehicleId) throws EntityNotFoundException {
		VehicleDO vehicleDO = findVehicleDOById(vehicleId);
		vehicleRepository.delete(vehicleDO);
	}

	/**
	 * This method is used to get all vehicles in a page with number pageNum.
	 * 
	 * @param pageNum
	 *            the page number to retrieve
	 * @param pageSize
	 *            the number of vehicle objects per page
	 * @return vehicles list.
	 */
	@Override
	public List<VehicleDTO> getAllVehicles(int pageNum, int pageSize) {
		Helper.checkGreaterEqualZero((long) pageNum, "pageNum");
		Helper.checkPositive((long) pageSize, "pageSize");

		return VehicleMapper
				.makeVehicleDTOList(Lists.newArrayList(vehicleRepository.findAll(PageRequest.of(pageNum, pageSize))));
	}

	/**
	 * This method is used to get all vehicles related to a customer specified by
	 * customerId with a pagination functionality.
	 * 
	 * @param customerId
	 *            the customer id that will be used to retrieve vehicles with
	 * @param pageNum
	 *            the page number to retrieve
	 * @param pageSize
	 *            the number of vehicle objects per page
	 * @return vehicles list.
	 */
	@Override
	public List<VehicleDTO> getVehiclesByCustomerId(Long customerId, int pageNum, int pageSize) {
		return VehicleMapper.makeVehicleDTOList(
				Lists.newArrayList(vehicleRepository.findByCustomerId(customerId, PageRequest.of(pageNum, pageSize))));

	}

	/**
	 * This method is used to update vehicle entity.
	 *
	 * @param vehicleId
	 *            the id of vehicle entity to update
	 * @param vehicleDTO
	 *            the vehicle entity to update
	 * @return the updated vehicle entity
	 * @throws IllegalArgumentException
	 *             if vehicleId is not positive or entity is null or id of entity is
	 *             not positive or id of entity not match id or entity is invalid
	 * @throws EntityNotFoundException
	 *             if the vehicle entity does not exist
	 */
	@Override
	public VehicleDTO updateVehicle(Long vehicleId, VehicleDTO vehicle) throws EntityNotFoundException {
		Helper.checkNull(vehicle, "vehicle");
		VehicleDO vehicleDO = findVehicleDOById(vehicleId);
		vehicleDO.setVin(vehicle.getVin());
		vehicleDO.setRegisterationNumber(vehicle.getRegisterationNumber());
		vehicleDO.setManufacturer(ManufacturerMapper.makeManufacturerDO(vehicle.getManufacturer()));
		vehicle.setModel(vehicle.getModel());
		vehicle.setCustomerId(vehicle.getCustomerId());
		return VehicleMapper.makeVehicleDTO(vehicleRepository.save(vehicleDO));
	}

}
