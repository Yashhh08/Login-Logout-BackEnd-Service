package com.masai.service;

import com.masai.exceptions.LoginException;
import com.masai.model.LoginDTO;

public interface LoginService {

	public String login(LoginDTO dto) throws LoginException;
	
	public String logout(String uuid) throws LoginException;
	
}
