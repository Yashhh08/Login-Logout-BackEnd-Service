package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exceptions.LoginException;
import com.masai.model.LoginDTO;
import com.masai.service.LoginService;

@RestController
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody LoginDTO dto) throws LoginException{
		
		String result = loginService.login(dto);
		
		return new ResponseEntity<String>(result,HttpStatus.OK);
		
	}
	
	@PostMapping("/logout")
	public ResponseEntity<String> logout(@RequestParam(required = false) String uuid) throws LoginException {
		
		String result = loginService.logout(uuid);
		
		return new ResponseEntity<String>(result,HttpStatus.OK);
		
	}
	
}
