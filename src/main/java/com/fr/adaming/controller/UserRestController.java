package com.fr.adaming.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.validator.constraints.ISBN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fr.adaming.entity.User;
import com.fr.adaming.service.IUserService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "api")
public class UserRestController {

	

	@Autowired
	private IUserService service;
	

	// convention JSON/HTTP par default pour les methodes CRUD
	// POST pour create
	// GET pour readById et readAll
	// PUT pour modifier
	// DELETE pour supprimer
	// creer un Dto pour ne pas accepter l'ID
	@ApiOperation(notes = "l'ID de l'utilisateur doit être nul", value = "create")
	@RequestMapping(path = "/user", method = RequestMethod.POST)
	public void create(@RequestBody User user) {
		User test;
		
		test = service.create(user);
		if (test != null) {
			
			
		}
	}

	@RequestMapping(path = "/user/{id}", method = RequestMethod.GET)
	public User readById(@PathVariable long id) {
		return service.readById(id);
	}

	@RequestMapping(path = "/user", method = RequestMethod.GET)
	public List<User> readAll() {
		return service.readAll();
	}

	@RequestMapping(path = "/user", method = RequestMethod.PUT)
	public void update(@RequestBody User user) {
		service.update(user);
	}

	@RequestMapping(path = "/user", method = RequestMethod.DELETE)
	public void delete(@RequestBody User user) {
		service.delete(user);
	}
	
	
}
