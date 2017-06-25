package de.heinemann.rest.v1.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="User", description="User identified by its unique id")
public class User {
	
	@ApiModelProperty(notes="Unique id of the user")
	private long id;
	
	@ApiModelProperty(notes="Name of the user")
	private String name = "";

	public User(String name) {
		setName(name);
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
