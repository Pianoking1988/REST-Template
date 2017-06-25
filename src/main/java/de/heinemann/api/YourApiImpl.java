package de.heinemann.api;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import de.heinemann.domain.User;

@Component
public class YourApiImpl implements YourApi {

	@Override
	public List<User> getUsers() {
		return Arrays.asList(
				new User(1, "User 1", 11),
				new User(2, "User 2", 12)
		);		
	}

	@Override
	public User getUser(long id) {
		return new User(id, "User " + id, (int) id + 10);
	}
	
}
