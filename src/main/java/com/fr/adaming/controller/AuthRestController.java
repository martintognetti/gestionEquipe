package com.fr.adaming.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fr.adaming.dto.LoginDto;
import com.fr.adaming.entity.User;
import com.fr.adaming.service.IAuthService;


@RestController
@RequestMapping(path = "api")
public class AuthRestController {
	
	@Autowired
	private IAuthService service;
	
	@RequestMapping(path = "/auth", method = RequestMethod.POST)
	public User login(@RequestBody LoginDto loginDto) {
		User u =service.login(loginDto.getEmail(),loginDto.getPwd());
		
		
		return u;
	}
	
	@RequestMapping(path = "/register", method = RequestMethod.POST)
	public String register(@RequestBody User user) {
		service.register(user);
		return "bienvenu";
		
	}
}
