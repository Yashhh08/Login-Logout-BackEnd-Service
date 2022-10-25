package com.masai.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exceptions.customerException;
import com.masai.model.Customer;
import com.masai.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/createCustomer")
	public ResponseEntity<Customer> createCustomer(@RequestBody @Valid Customer customer) throws customerException{
		
		Customer createdCustomer = customerService.createCustomer(customer);
		
		return new ResponseEntity<Customer>(createdCustomer,HttpStatus.CREATED);
	}
	
	@PutMapping("/updateCustomer/{uuid}")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer ,@PathVariable("uuid") String uuid) throws customerException{
		
		Customer updatedCustomer = customerService.updateCustomer(customer, uuid);
		
		return new ResponseEntity<Customer>(updatedCustomer,HttpStatus.OK);
	}
	
}
