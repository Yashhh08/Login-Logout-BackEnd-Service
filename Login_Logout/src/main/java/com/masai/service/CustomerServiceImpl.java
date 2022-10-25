package com.masai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.customerException;
import com.masai.model.CurrentUserSession;
import com.masai.model.Customer;
import com.masai.repositery.CustomerDAO;
import com.masai.repositery.SessionDAO;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerDAO cdao;
	
	@Autowired
	private SessionDAO sdao;
	
	@Override
	public Customer createCustomer(Customer customer) throws customerException {
		
		Customer existingCustomer = cdao.findByMobileNO(customer.getMobileNO());
		
		if(existingCustomer==null)
		{
			return cdao.save(customer);
		}
		else
		{
			throw new customerException("Customer already exist with this number");
		}
		
	}

	@Override
	public Customer updateCustomer(Customer customer, String uuid) throws customerException {
		
		CurrentUserSession loggedInUser = sdao.findByUuid(uuid);
		
		if(loggedInUser==null)
		{
			throw new customerException("please logIn first");
		}
		else
		{
			
			if(loggedInUser.getUserID() == customer.getCustomerId())
			{
				return cdao.save(customer);
			}
			else
			{
				throw new customerException("Invalid customer details, please login first");
			}
			
		}
		
		
		
	}

	
	
}
