package com.alten.dataaccessobject;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.alten.domainobject.VehicleDO;

public interface VehicleRepository extends PagingAndSortingRepository<VehicleDO, Long> {
	List<VehicleDO> findByCustomerId(Long customerId, Pageable pageable);
}
