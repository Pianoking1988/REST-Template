package de.heinemann.rest.v1.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="User", description="User identified by its unique id")
public class User {

	@ApiModelProperty(notes="Unique id of the user")
	private long id;

	@ApiModelProperty(notes="Mail of the user")
	private String mail = "";

	public User() {}

	public User(long id, String mail) {
		this.id = id;
		this.mail = mail;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

}