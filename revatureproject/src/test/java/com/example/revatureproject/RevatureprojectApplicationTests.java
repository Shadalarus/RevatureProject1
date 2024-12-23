package com.example.revatureproject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import com.example.revatureproject.entity.Accounts;
import com.example.revatureproject.entity.Posts;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
class RevatureprojectApplicationTests {

	ApplicationContext app;
    HttpClient webClient;
    ObjectMapper objectMapper;

	@BeforeEach
    public void setUp() throws InterruptedException {
        webClient = HttpClient.newHttpClient();
        objectMapper = new ObjectMapper();
        String[] args = new String[] {};
        app = SpringApplication.run(RevatureprojectApplication.class, args);
        Thread.sleep(500);
    }

    @AfterEach
    public void tearDown() throws InterruptedException {
    	Thread.sleep(500);
    	SpringApplication.exit(app);
    }

	@Test
	public void createAccountSuccessful() throws IOException, InterruptedException {
    	String json = "{\"firstName\": \"Tester\",\"lastName\": \"Testerino\",\"email\": \"test@tester.com\",\"username\": \"Testing123\",\"password\": \"WorkPlease\"}";
        HttpRequest postAccountRequest = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/register"))
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .header("Content-Type", "application/json")
                .build();
        HttpResponse<String> response = webClient.send(postAccountRequest, HttpResponse.BodyHandlers.ofString());
        int status = response.statusCode();
        Assertions.assertEquals(200, status, "Expected Status Code 200 - Actual Code was: " + status);
        ObjectMapper om = new ObjectMapper();
        Accounts expectedResult = new Accounts("Tester", "Testerino", "test@tester.com", "Testing123", "WorkPlease");
        Accounts actualResult = om.readValue(response.body().toString(), Accounts.class);
        Assertions.assertEquals(expectedResult, actualResult, "Expected="+expectedResult + ", Actual="+actualResult);
    }

    @Test
	public void createPostSuccessful() throws IOException, InterruptedException {
    	String json = "{\"messageText\": \"Tester\",\"accountId\": 3}";
        HttpRequest postAccountRequest = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/posts/newPost"))
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .header("Content-Type", "application/json")
                .build();
        HttpResponse<String> response = webClient.send(postAccountRequest, HttpResponse.BodyHandlers.ofString());
        int status = response.statusCode();
        Assertions.assertEquals(200, status, "Expected Status Code 200 - Actual Code was: " + status);
        ObjectMapper om = new ObjectMapper();
        Posts expectedResult = new Posts("Tester", 3);
        Posts actualResult = om.readValue(response.body().toString(), Posts.class);
        Assertions.assertEquals(expectedResult, actualResult, "Expected="+expectedResult + ", Actual="+actualResult);
    }

}
