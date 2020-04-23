package com.amaury.projects.backend.apirest.models.service;

import java.util.List;
import com.amaury.projects.backend.apirest.models.entity.Customer;

public interface CustomerServiceInterface {
	
	public List<Customer> findAll();
	
	public Customer findById(Long id);
	
	public Customer save(Customer customer);
	
	public void deleteById(Long id);

}
