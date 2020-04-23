package com.amaury.projects.backend.apirest.models.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amaury.projects.backend.apirest.models.dao.CustomerDAOInterface;
import com.amaury.projects.backend.apirest.models.entity.Customer;

@Service
public class CustomerService implements CustomerServiceInterface {

	@Autowired
	private CustomerDAOInterface customerDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		return (List<Customer>) customerDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Customer findById(Long id) {
		return customerDao.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = false)
	public Customer save(Customer customer) {
		return customerDao.save(customer);
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteById(Long id) {
		customerDao.deleteById(id);
	}

}
