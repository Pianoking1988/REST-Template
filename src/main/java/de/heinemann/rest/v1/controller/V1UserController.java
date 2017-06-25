package de.heinemann.rest.v1.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import de.heinemann.rest.v1.domain.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value ="/v1/users")
@Api(description="RESTful CRUD operations for users")
public class V1UserController {

	@RequestMapping(method = RequestMethod.GET)
	@ApiOperation(value="Get all users")
	public List<User> getUsers() {
		return Arrays.asList(
				new User("User 1"),
				new User("User 2")
		);		
	}

	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	@ApiOperation(value="Get user with given id")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message="Successfully retrieved user"),
			@ApiResponse(code = 404, message="User with id not found")
	})
	public User getUser(@PathVariable int id) {
		return new User("User " + id);
	}	
	
}
