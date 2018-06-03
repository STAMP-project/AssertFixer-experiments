package com.alten.mapper;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.alten.datatransferobject.ManufacturerDTO;
import com.alten.datatransferobject.VehicleDTO;
import com.alten.domainobject.ManufacturerDO;
import com.alten.domainobject.VehicleDO;

public final class VehicleMapper {
	public static VehicleDO makeVehicleDO(VehicleDTO vehicleDTO) {

		ManufacturerDO manufacturerDO = new ManufacturerDO(vehicleDTO.getManufacturer().getId(),
				vehicleDTO.getManufacturer().getName(), vehicleDTO.getManufacturer().getOrigin());
		return new VehicleDO(vehicleDTO.getCustomerId(), vehicleDTO.getVin(), vehicleDTO.getRegisterationNumber(),
				manufacturerDO, vehicleDTO.getModel());
	}

	public static VehicleDTO makeVehicleDTO(VehicleDO vehicleDO) {
		ManufacturerDTO manufacturerDTO = new ManufacturerDTO(vehicleDO.getManufacturer().getId(),
				vehicleDO.getManufacturer().getName(), vehicleDO.getManufacturer().getOrigin());
		return new VehicleDTO(vehicleDO.getId(), vehicleDO.getCustomerId(), vehicleDO.getVin(),
				vehicleDO.getRegisterationNumber(), vehicleDO.getModel(), manufacturerDTO);
	}

	public static List<VehicleDTO> makeVehicleDTOList(Collection<VehicleDO> vehicles) {
		return vehicles.stream().map(VehicleMapper::makeVehicleDTO).collect(Collectors.toList());
	}
}
