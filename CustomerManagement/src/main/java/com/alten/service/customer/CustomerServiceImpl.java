package com.alten.service.customer;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.alten.datataccessobject.CustomerRepository;
import com.alten.datatranssferobject.CustomerDTO;
import com.alten.domainobject.CustomerDO;
import com.alten.domainobject.CustomerDO;
import com.alten.domainobject.CustomerDO;
import com.alten.exception.ConfigurationException;
import com.alten.exception.ConstraintsViolationException;
import com.alten.exception.EntityNotFoundException;
import com.alten.mapper.AddressMapper;
import com.alten.mapper.CustomerMapper;
import com.alten.mapper.CustomerMapper;
import com.alten.mapper.CustomerMapper;
import com.alten.util.Helper;
import com.google.common.collect.Lists;

/**
 * Service to encapsulate the link between DAO and controller and to have
 * business logic for some Customer specific things.
 * <p/>
 */
@Service
public class CustomerServiceImpl implements CustomerService {

	private final CustomerRepository customerRepository;

	/**
	 * <p>
	 * This is the constructor of <code>CustomerServiceImpl</code> class with
	 * CustomerRepository argument.
	 * </p>
	 *
	 * @param customerRepository
	 *            the Customer repository for handling the persistence layer.
	 */
	@Autowired
	public CustomerServiceImpl(final CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
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
		Helper.checkConfigNotNull(customerRepository, "customerRepository");
	}

	private CustomerDO findCustomerDOById(Long customerId) throws EntityNotFoundException {
		Helper.checkNull(customerId, "customerId");
		Helper.checkPositive(customerId, "customerId");
		Optional<CustomerDO> optionalCustomer = customerRepository.findById(customerId);
		if (!optionalCustomer.isPresent()) {
			throw new EntityNotFoundException("Could not find customer with id: " + customerId);
		}
		return optionalCustomer.get();
	}

	/**
	 * This method is used to retrieve a specific customer identified by customerId
	 *
	 * @param customerId
	 *            the id of the customer entity to retrieve
	 * @return the matched customer entity
	 * @throws IllegalArgumentException
	 *             if id is not positive
	 * @throws EntityNotFoundException
	 *             if the entity does not exist
	 */
	@Override
	public CustomerDTO findCustomerById(Long customerId) throws EntityNotFoundException {
		return CustomerMapper.makeCustomerDTO(findCustomerDOById(customerId));
	}

	/**
	 * This method is used to create an customer entity.
	 *
	 * @param customerDTO
	 *            the entity to be created
	 * @return the created customer entity
	 * @throws IllegalArgumentException
	 *             if entity is null or not valid
	 * @throws ConstraintsViolationException
	 *             if any constraint has been violated
	 */
	@Override
	public CustomerDTO create(CustomerDTO customerDTO) throws ConstraintsViolationException {
		Helper.checkNull(customerDTO, "customerDTO");
		CustomerDO customerDO = CustomerMapper.makeCustomerDO(customerDTO);
		try {
			customerDO = customerRepository.save(customerDO);
		} catch (DataIntegrityViolationException e) {
			throw new ConstraintsViolationException(e.getMessage());
		}
		return CustomerMapper.makeCustomerDTO(customerDO);
	}

	/**
	 * This method is used to delete a customer entity using its id.
	 *
	 * @param customerId
	 *            the id of the customer entity to delete
	 * @throws IllegalArgumentException
	 *             if id is not positive
	 * @throws EntityNotFoundException
	 *             if the entity does not exist
	 */
	@Override
	public void delete(Long customerId) throws EntityNotFoundException {
		CustomerDO customerDO = findCustomerDOById(customerId);
		customerRepository.delete(customerDO);
	}

	/**
	 * This method is used to get all customers in a page with number pageNum.
	 * 
	 * @param pageNum
	 *            the page number to retrieve
	 * @param pageSize
	 *            the number of customer objects per page
	 * @return customers list.
	 */
	@Override
	public List<CustomerDTO> getAllCustomers(int pageNum, int pageSize) {
		Helper.checkGreaterEqualZero((long) pageNum, "pageNum");
		Helper.checkPositive((long) pageSize, "pageSize");

		return CustomerMapper
				.makeCustomerDTOList(Lists.newArrayList(customerRepository.findAll(PageRequest.of(pageNum, pageSize))));
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
	 *             if customerId is not positive or entity is null or id of entity is
	 *             not positive or id of entity not match id or entity is invalid
	 * @throws EntityNotFoundException
	 *             if the customer entity does not exist
	 */
	@Override
	public CustomerDTO updateCustomer(Long customerId, CustomerDTO customer) throws EntityNotFoundException {
		Helper.checkNull(customer, "customer");
		Helper.checkPositive(customerId, "customerId");
		CustomerDO customerDO = findCustomerDOById(customerId);
		customerDO.setAddress(AddressMapper.makeAddressDO(customer.getAddress()));
		customerDO.setCustomerType(customer.getCustomerType());
		customerDO.setName(customer.getName());
		return CustomerMapper.makeCustomerDTO(customerRepository.save(customerDO));
	}

}
