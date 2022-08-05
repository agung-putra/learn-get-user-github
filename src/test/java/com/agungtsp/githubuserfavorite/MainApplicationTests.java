package com.agungtsp.githubuserfavorite;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Main.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(OrderAnnotation.class)
@FixMethodOrder(MethodSorters.JVM)
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
	@Order(1)
	public void testFetchAllUsers() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/api/v1/github-users",
				HttpMethod.GET, entity, String.class);

		Assert.assertEquals(200, response.getStatusCodeValue());
	}

	String UserId = "62eb9ea29447e81be5dec111";

	@Test
	@Order(2)
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
	@Order(3)
	public void testGetFavoriteUsers() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/api/v1/favorite-users",
				HttpMethod.GET, entity, String.class);

		Assert.assertEquals(200, response.getStatusCodeValue());
	}

	@Test
	@Order(4)
	public void testUpdateFavoriteUsers() {
		User user = new User();
		user.setNode_id("aaaaa");
		user.setAvatar_url("https://google.com");
		restTemplate.put(
				getRootUrl() + "/api/v1/favorite-users"+ UserId,
				user);

		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		ResponseEntity<String> response = restTemplate.exchange(
				getRootUrl() + "/api/v1/favorite-users/"+ UserId,
				HttpMethod.GET, entity, String.class);
		Assert.assertEquals(200, response.getStatusCodeValue());
	}

	@Test
	@Order(5)
	public void testDetailFavoriteUsers() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(
				getRootUrl() + "/api/v1/favorite-users/"+ UserId,
				HttpMethod.GET, entity, String.class);

		Assert.assertEquals(200, response.getStatusCodeValue());
	}

	@Test
	@Order(6)
	public void testDeleteFavoriteUsers() {
		restTemplate.delete(getRootUrl() + "/api/v1/favorite-users/" + UserId);
	}


}
