package com.agungtsp.githubuserfavorite;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Main.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MainApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private int port;
	private Class<? extends Object> String;

	private String getRootUrl() {
		return "http://localhost:" + port;
	}

	@Test
	public void testGetFavoriteUsers() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/api/v1/favorite-users",
				HttpMethod.GET, entity, String.class);

		Assert.assertEquals(200, response.getStatusCodeValue());
	}

	@Test
	public void testFetchAllUsers() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/api/v1/github-users",
				HttpMethod.GET, entity, String.class);

		Assert.assertEquals(200, response.getStatusCodeValue());
	}

	String UserId = "62eb9ea29447e81be5dec111";

	@Test
	public void testAddFavoriteUsers() {
		User user = new User();
		user.setLogin("agung");
		user.setId(UserId);
		user.setSite_admin(true);
		user.setType("User");

		ResponseEntity<?> postResponse = restTemplate.postForEntity(
				getRootUrl() + "/api/v1/favorite-users", user, String);
		Assert.assertEquals(200, postResponse.getStatusCodeValue());
	}

	@Test
	public void testDeleteFavoriteUsers() {
		restTemplate.delete(getRootUrl() + "/api/v1/favorite-users/" + UserId);
	}


}
