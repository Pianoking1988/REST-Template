package de.heinemann.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.heinemann.domain.User;
import de.heinemann.repository.UserRepository;

@Component
public class YourApiImpl implements YourApi {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getUser(long id) {
		return new User(id, "user" + id + "@rest.de", "admin");
	}
	
}
