package de.heinemann.rest.v1.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import de.heinemann.api.YourApi;
import de.heinemann.rest.v1.domain.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Component("UserControllerV1")
@RequestMapping(value ="/v1/users")
@Api(description="RESTful CRUD operations for users")
public class UserController {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private YourApi api;

	@RequestMapping(method = RequestMethod.GET)
	@ApiOperation(value="Get all users")
	public List<User> getUsers() {
		List<de.heinemann.domain.User> apiUsers = api.getUsers();
		return modelMapper.map(apiUsers, new TypeToken<List<User>>() {}.getType());
	}

	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	@ApiOperation(value="Get user with given id")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message="Successfully retrieved user"),
			@ApiResponse(code = 404, message="User with id not found")
	})
	public User getUser(@PathVariable long id) {
		return modelMapper.map(api.getUser(id), User.class);
	}

}
