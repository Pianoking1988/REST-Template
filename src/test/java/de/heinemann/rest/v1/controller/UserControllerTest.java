package de.heinemann.rest.v1.controller;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;

import de.heinemann.rest.v1.domain.User;
import de.heinemann.testutils.base.BaseClassControllerTest;

@DatabaseTearDown("../../../reset.xml")
public class UserControllerTest extends BaseClassControllerTest {

	@Test
	@DatabaseSetup("getUsersShouldReturnUsers/prepared.xml")
	@ExpectedDatabase(value = "getUsersShouldReturnUsers/expected.xml", assertionMode=DatabaseAssertionMode.NON_STRICT)
	public void getUsersShouldReturnUsers() throws Exception {
		List<User> expected = Arrays.asList(
				new User(1, "user1@test.de"),
				new User(2, "user2@test.de")
		);

		String response = mockMvc.perform(MockMvcRequestBuilders.get("/v1/users").contentType(MediaType.APPLICATION_JSON)).andReturn().getResponse().getContentAsString();
		List<User> actual = new ObjectMapper().readValue(response, new TypeReference<List<User>>(){});

		assertNotNull(actual);
		assertThat(actual, hasSize(expected.size()));
		for (int i = 0; i < actual.size(); i++) {
			assertThat(actual.get(i), samePropertyValuesAs(expected.get(i)));
		}
	}

}
