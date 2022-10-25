package com.masai.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.LoginException;
import com.masai.model.CurrentUserSession;
import com.masai.model.Customer;
import com.masai.model.LoginDTO;
import com.masai.repositery.CustomerDAO;
import com.masai.repositery.SessionDAO;

import net.bytebuddy.utility.RandomString;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	private CustomerDAO cdao;
	
	@Autowired
	private SessionDAO sdao;
	
	@Override
	public String login(LoginDTO dto) throws LoginException {

		Customer exsistingCustomer = cdao.findByMobileNO(dto.getMobileNo());
		
		if(exsistingCustomer == null)
		{
			throw new LoginException("Please enter a valid mobile number");
		}
		
		Optional<CurrentUserSession> currentUserSession = sdao.findById(exsistingCustomer.getCustomerId());
		
		if(currentUserSession.isPresent())
		{
			throw new LoginException("User already logged in with this number");
		}
		
		if(exsistingCustomer.getPassword().equals(dto.getPassword()))
		{
			String uuid = RandomString.make(6);
			
			CurrentUserSession createNewSession = new CurrentUserSession(exsistingCustomer.getCustomerId(), uuid, LocalDateTime.now());
			
			sdao.save(createNewSession);
			
			return createNewSession.toString();
		}
		else
		{
			throw new LoginException("please enter a valid password");
		}
		
	}

	@Override
	public String logout(String uuid) throws LoginException {
		
		CurrentUserSession currentUserSession = sdao.findByUuid(uuid);
		
		if(currentUserSession == null)
		{
			throw new LoginException("user not logged in with this number");
		}
		else
		{
			sdao.delete(currentUserSession);
		}
		
		return "Logged out successfully";
		
	}

	
	
}
