package com.alten.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.naming.ConfigurationException;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.alten.datatransferobject.VehicleDTO;
import com.alten.exception.ConstraintsViolationException;
import com.alten.exception.EntityNotFoundException;
import com.alten.service.vehicle.VehicleService;
import com.alten.util.Helper;

/**
 * All operations with a vehicle will be routed by this controller.
 * <p/>
 */
@RestController
@RequestMapping("v1/vehicles")
public class VehicleController {
	/**
	 * The vehicle service used to perform operations. Should be non-null after
	 * injection.
	 */
	private final VehicleService vehicleService;

	@Autowired
	public VehicleController(final VehicleService vehicleService) {
		this.vehicleService = vehicleService;
	}

	/**
	 * Check if all required fields are initialized properly.
	 *
	 * @throws ConfigurationException
	 *             if any required field is not initialized properly.
	 */
	@PostConstruct
	protected void checkConfiguration() throws ConfigurationException {
		Helper.checkConfigNotNull(vehicleService, "vehicleService");
	}

	/**
	 * This method is used to retrieve all vehicle entities.
	 * 
	 * @param pageNum
	 *            page number - must be >= 0 - default = 0
	 * @param pageSize
	 *            page size - must be >= 1 - default = 20
	 *
	 * @return the list of all vehicle entities
	 */
	@GetMapping
	public List<VehicleDTO> getAllVehicles(@RequestParam(required = false, defaultValue = "0") Integer page,
			@RequestParam(required = false, defaultValue = "20") Integer pageSize) {
		return vehicleService.getAllVehicles(page, pageSize);
	}

	/**
	 * This method is used to retrieve an entity.
	 *
	 * @param vehicleId
	 *            the id of the vehicle entity to retrieve
	 * @return the matched vehicle entity
	 * @throws IllegalArgumentException
	 *             if id is not positive
	 * @throws EntityNotFoundException
	 *             if the entity does not exist
	 */
	@GetMapping("/{vehicleId}")
	public VehicleDTO getVehicle(@Valid @PathVariable long vehicleId) throws EntityNotFoundException {
		return vehicleService.findVehicleById(vehicleId);
	}

	/**
	 * This method is used to retrieve all vehicle entities related to a customer
	 * specified by customerId.
	 * 
	 * @param customerId
	 *            the customer id that will be used to retrieve vehicles with
	 * @param pageNum
	 *            page number - must be >= 0 - default = 0
	 * @param pageSize
	 *            page size - must be >= 1 - default = 20
	 *
	 * @return the list of all vehicle entities
	 */
	@GetMapping("/customerId/{customerId}")
	public List<VehicleDTO> getVehiclesByCustomerId(@Valid @PathVariable long customerId,
			@RequestParam(required = false, defaultValue = "0") Integer page,
			@RequestParam(required = false, defaultValue = "20") Integer pageSize) {
		return vehicleService.getVehiclesByCustomerId(customerId, page, pageSize);
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
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public VehicleDTO createVehicle(@Valid @RequestBody VehicleDTO vehicleDTO) throws ConstraintsViolationException {
		return vehicleService.create(vehicleDTO);
	}

	/**
	 * This method is used to delete a vehicle entity.
	 *
	 * @param vehicleId
	 *            the id of the vehicle entity to be deleted
	 * @throws IllegalArgumentException
	 *             if id is not positive
	 * @throws EntityNotFoundException
	 *             if the entity does not exist
	 */
	@DeleteMapping("/{vehicleId}")
	public void deleteVehicle(@Valid @PathVariable long vehicleId) throws EntityNotFoundException {
		vehicleService.delete(vehicleId);
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
	@PutMapping("/{vehicleId}")
	public VehicleDTO updateVehicle(@Valid @PathVariable long vehicleId, @Valid @RequestBody VehicleDTO vehicleDTO)
			throws ConstraintsViolationException, EntityNotFoundException {
		return vehicleService.updateVehicle(vehicleId, vehicleDTO);
	}
}
