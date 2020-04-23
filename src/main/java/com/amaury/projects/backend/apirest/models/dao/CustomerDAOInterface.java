package com.amaury.projects.backend.apirest.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.amaury.projects.backend.apirest.models.entity.Customer;

public interface CustomerDAOInterface extends CrudRepository<Customer, Long>{

}
