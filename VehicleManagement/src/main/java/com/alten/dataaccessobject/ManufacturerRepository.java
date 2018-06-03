package com.alten.dataaccessobject;

import org.springframework.data.repository.CrudRepository;

import com.alten.domainobject.ManufacturerDO;
/**
 * 
 * The manufacturer repository - Data Access for manufacturer table.
 *
 */
public interface ManufacturerRepository extends CrudRepository<ManufacturerDO, Long>
{

}
