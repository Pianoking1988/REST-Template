package de.heinemann.rest.v1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value ="/users")
public class UserController {

	@RequestMapping(method = RequestMethod.GET)
	public String getUsers() {
		return null;
	}
	
}
