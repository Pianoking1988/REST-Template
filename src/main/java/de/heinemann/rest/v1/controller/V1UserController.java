package de.heinemann.rest.v1.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import de.heinemann.api.YourApi;
import de.heinemann.rest.v1.domain.V1User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value ="/v1/users")
@Api(description="RESTful CRUD operations for users")
public class V1UserController {

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private YourApi api;	
	
	@RequestMapping(method = RequestMethod.GET)
	@ApiOperation(value="Get all users")
	public List<V1User> getUsers() {
		return modelMapper.map(api.getUsers(), new TypeToken<List<V1User>>() {}.getType());
	}

	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	@ApiOperation(value="Get user with given id")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message="Successfully retrieved user"),
			@ApiResponse(code = 404, message="User with id not found")
	})
	public V1User getUser(@PathVariable long id) {
		return modelMapper.map(api.getUser(id), V1User.class);
	}	
	
}
