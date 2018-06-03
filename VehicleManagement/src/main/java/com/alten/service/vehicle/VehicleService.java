package com.alten.service.vehicle;

import java.util.List;

import com.alten.datatransferobject.VehicleDTO;
import com.alten.exception.ConstraintsViolationException;
import com.alten.exception.EntityNotFoundException;

public interface VehicleService {

	VehicleDTO findVehicleById(Long vehicleId) throws EntityNotFoundException;

	VehicleDTO create(VehicleDTO vehicleDO) throws ConstraintsViolationException;

	void delete(Long vehicleId) throws EntityNotFoundException;

	public List<VehicleDTO> getAllVehicles(int pageNum, int pageSize);

	public List<VehicleDTO> getVehiclesByCustomerId(Long customerId, int pageNum, int pageSize);

	public VehicleDTO updateVehicle(Long vehicleId, VehicleDTO vehicle) throws EntityNotFoundException;
}
