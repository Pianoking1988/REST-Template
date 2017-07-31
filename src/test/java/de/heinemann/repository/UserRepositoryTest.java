package de.heinemann.repository;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.samePropertyValuesAs;

import java.util.Calendar;

import org.junit.After;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.springtestdbunit.annotation.DatabaseTearDown;

import de.heinemann.domain.User;
import de.heinemann.testutils.base.BaseClassTest;
import de.heinemann.testutils.database.DatabaseResetter;

@DatabaseTearDown("../reset.xml")
public class UserRepositoryTest extends BaseClassTest {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private DatabaseResetter databaseResetter;

	@After
	public void tearDown() {
		databaseResetter.restartIdentities();
	}

	@Test
	public void saveAndFindFirstUser() {
		User user = new User("o.schmitz@iks-gmbh.com");
		user.setCreated(Calendar.getInstance());
		user.setCreatedBy("a.wiegand@iks-gmbh.com");

		userRepository.save(user);
		user.setId(1);

		User actualUser = userRepository.findByMailIgnoreCase(user.getMail());

		assertThat(actualUser, samePropertyValuesAs(user));
	}

	@Test
	public void saveAndFindSecondUser() {
		User user = new User("o.schmitz@iks-gmbh.com");
		user.setCreated(Calendar.getInstance());
		user.setCreatedBy("a.wiegand@iks-gmbh.com");

		userRepository.save(user);
		user.setId(1);

		User actualUser = userRepository.findByMailIgnoreCase(user.getMail());

		assertThat(actualUser, samePropertyValuesAs(user));
	}

}
