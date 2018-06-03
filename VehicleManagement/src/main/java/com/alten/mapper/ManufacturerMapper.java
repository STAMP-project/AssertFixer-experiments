package com.alten.mapper;

import com.alten.datatransferobject.ManufacturerDTO;
import com.alten.domainobject.ManufacturerDO;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ManufacturerMapper
{
    public static ManufacturerDO makeManufacturerDO(ManufacturerDTO manufacturerDTO)
    {
        return new ManufacturerDO(manufacturerDTO.getId(), manufacturerDTO.getName(), manufacturerDTO.getOrigin());
    }


    public static ManufacturerDTO makeManufacturerDTO(ManufacturerDO manufacturerDO)
    {
        ManufacturerDTO manufacturerDTO = new ManufacturerDTO(manufacturerDO.getId(), manufacturerDO.getName(), manufacturerDO.getOrigin());
        return manufacturerDTO;
    }


    public static List<ManufacturerDTO> makeManufacturerDTOList(Collection<ManufacturerDO> manufacturers)
    {
        return manufacturers.stream()
            .map(ManufacturerMapper::makeManufacturerDTO)
            .collect(Collectors.toList());
    }
}
