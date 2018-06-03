package com.alten.datataccessobject;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.alten.domainobject.CustomerDO;

public interface CustomerRepository extends PagingAndSortingRepository<CustomerDO, Long> {
}
