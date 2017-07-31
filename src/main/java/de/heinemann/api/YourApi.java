package de.heinemann.api;

import java.util.List;

import de.heinemann.domain.User;

public interface YourApi {

	public List<User> getUsers();
	
	public User getUser(long id);
	
}
