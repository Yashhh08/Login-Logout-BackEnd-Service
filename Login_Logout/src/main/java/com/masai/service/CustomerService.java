package com.masai.service;

import com.masai.exceptions.customerException;
import com.masai.model.Customer;

public interface CustomerService {

	public Customer createCustomer(Customer customer) throws customerException;
	
	public Customer updateCustomer(Customer customer , String uuid) throws customerException;
	
}
