package com.alten.service.customer;

import java.util.List;

import com.alten.datatranssferobject.CustomerDTO;
import com.alten.exception.ConstraintsViolationException;
import com.alten.exception.EntityNotFoundException;

public interface CustomerService {
	CustomerDTO findCustomerById(Long customerId) throws EntityNotFoundException;

	CustomerDTO create(CustomerDTO customerDO) throws ConstraintsViolationException;

	void delete(Long customerId) throws EntityNotFoundException;

	public List<CustomerDTO> getAllCustomers(int pageNum, int pageSize);

	public CustomerDTO updateCustomer(Long customerId, CustomerDTO customer) throws EntityNotFoundException;
}
