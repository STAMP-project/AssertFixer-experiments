package com.alten.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.naming.ConfigurationException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.alten.datatranssferobject.CustomerDTO;
import com.alten.exception.ConstraintsViolationException;
import com.alten.exception.EntityNotFoundException;
import com.alten.service.customer.CustomerService;
import com.alten.util.Helper;

/**
 * All operations with a customer will be routed by this controller.
 * <p/>
 */
@RestController
@RequestMapping("v1/customers")
public class CustomerController {
	/**
	 * The customer service used to perform operations. Should be non-null after
	 * injection.
	 */
	private final CustomerService customerService;

	@Autowired
	public CustomerController(final CustomerService customerService) {
		this.customerService = customerService;
	}

	/**
	 * Check if all required fields are initialized properly.
	 *
	 * @throws ConfigurationException
	 *             if any required field is not initialized properly.
	 */
	@PostConstruct
	protected void checkConfiguration() throws ConfigurationException {
		Helper.checkConfigNotNull(customerService, "customerService");
	}

	/**
	 * This method is used to retrieve all customer entities.
	 * 
	 * @param pageNum
	 *            page number - must be >= 0 - default = 0
	 * @param pageSize
	 *            page size - must be >= 1 - default = 20
	 *
	 * @return the list of all customer entities
	 */
	@GetMapping
	public List<CustomerDTO> getAllCustomers(@RequestParam(required = false, defaultValue = "0") Integer page,
			@RequestParam(required = false, defaultValue = "20") Integer pageSize) {
		return customerService.getAllCustomers(page, pageSize);
	}

	/**
	 * This method is used to retrieve a customer entity.
	 *
	 * @param customerId
	 *            the id of the customer entity to retrieve
	 * @return the matched customer entity
	 * @throws IllegalArgumentException
	 *             if id is not positive
	 * @throws EntityNotFoundException
	 *             if the entity does not exist
	 */
	@GetMapping("/{customerId}")
	public CustomerDTO getCustomer(@Valid @PathVariable long customerId) throws EntityNotFoundException {
		return customerService.findCustomerById(customerId);
	}

	/**
	 * This method is used to create an customer entity.
	 *
	 * @param customerDTO
	 *            the entity to create
	 * @return the created customer entity
	 * @throws IllegalArgumentException
	 *             if entity is null or not valid
	 * @throws ConstraintsViolationException
	 *             if any constraint has been violated
	 */
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CustomerDTO createCustomer(@Valid @RequestBody CustomerDTO customerDTO)
			throws ConstraintsViolationException {
		return customerService.create(customerDTO);
	}

	/**
	 * This method is used to delete a customer entity.
	 *
	 * @param customerId
	 *            the id of the customer entity to be deleted
	 * @throws IllegalArgumentException
	 *             if id is not positive
	 * @throws EntityNotFoundException
	 *             if the entity does not exist
	 */
	@DeleteMapping("/{customerId}")
	public void deleteCustomer(@Valid @PathVariable long customerId) throws EntityNotFoundException {
		customerService.delete(customerId);
	}

	/**
	 * This method is used to update customer entity.
	 *
	 * @param customerId
	 *            the id of customer entity to update
	 * @param customerDTO
	 *            the customer entity to update
	 * @return the updated customer entity
	 * @throws IllegalArgumentException
	 *             if customerId is not positive or entity is null or id of entity
	 *             is not positive or id of entity not match id or entity is invalid
	 * @throws EntityNotFoundException
	 *             if the customer entity does not exist
	 */
	@PutMapping("/{customerId}")
	public CustomerDTO updateCustomer(@Valid @PathVariable long customerId, @Valid @RequestBody CustomerDTO customerDTO)
			throws ConstraintsViolationException, EntityNotFoundException {
		return customerService.updateCustomer(customerId, customerDTO);
	}
}
