package de.heinemann.rest.v2.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="User", description="User identified by its unique id")
public class User {
	
	@ApiModelProperty(notes="Unique id of the user")
	private long id;
	
	@ApiModelProperty(notes="Name of the user")
	private String name = "";
	
	@ApiModelProperty(notes="Age of the user")
	private int age = 0;

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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
}
