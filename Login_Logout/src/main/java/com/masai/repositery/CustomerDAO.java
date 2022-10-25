package com.masai.repositery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.Customer;

@Repository
public interface CustomerDAO extends JpaRepository<Customer, Integer> {

	public Customer findByMobileNO(String mobileNO);
	
}
