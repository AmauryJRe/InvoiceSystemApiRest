package com.amaury.projects.backend.apirest.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.amaury.projects.backend.apirest.models.entity.Customer;
import com.amaury.projects.backend.apirest.models.service.CustomerServiceInterface;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class CustomerRestController {

	@Autowired
	private CustomerServiceInterface customerService;

	@GetMapping("/customers")
	public List<Customer> index() {
		return customerService.findAll();
	}

	@GetMapping("/customers/{id}")
	public Customer show(@PathVariable(name = "id") Long id) {
		return customerService.findById(id);
	}

	@PostMapping("/customers")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Customer create(@RequestBody Customer customer) {
		return customerService.save(customer);
	}

	@PutMapping("/customers/{id}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Customer update(@RequestBody Customer customer, @PathVariable(name = "id") Long id) {
		Customer onDB = customerService.findById(id);
		onDB.setName(customer.getName());
		onDB.setLastName(customer.getLastName());
		onDB.setEmail(customer.getEmail());
		onDB.setPhoto(customer.getPhoto());
		return customerService.save(onDB);
	}

	@DeleteMapping("/customers/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable(name = "id") Long id) {
		customerService.deleteById(id);
	}

}
