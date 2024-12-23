package com.example.revatureproject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import com.example.revatureproject.entity.Accounts;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
class GetAccountTest {

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
	public void getAccountsList() throws IOException, InterruptedException {
         HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/users"))
                .build();
        HttpResponse<String> response = webClient.send(request, HttpResponse.BodyHandlers.ofString());
        int status = response.statusCode();
        Assertions.assertEquals(200, status, "Expected Status Code 200 - Actual Code was: " + status);
        List<Accounts> expectedResult = new ArrayList<Accounts>();
        expectedResult.add(new Accounts(1, "Logan", "Sobrilsky", "logan932@revature.net", "540-656-9668", "CatLover", "Mycatisanangelfromheavenabove"));
        expectedResult.add(new Accounts(2, "Dolce", "Andromeda", "starlover81273@gmail.com", "574-670-4365", "StellarWatcher", "Thestarsarebeautiful!34"));
        expectedResult.add(new Accounts(3, "John", "Bloodborne", "thegoodhunter@yharnam.net","666-543-1435", "TheLastHunter", "!FearTheOldBlood!"));
        List<Accounts> actualResult = objectMapper.readValue(response.body().toString(), new TypeReference<List<Accounts>>(){});
        Assertions.assertEquals(expectedResult, actualResult, "Expected="+expectedResult + ", Actual="+actualResult);
    }

    @Test
	public void getAccountsById() throws IOException, InterruptedException {
         HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/account/2"))
                .build();
        HttpResponse<String> response = webClient.send(request, HttpResponse.BodyHandlers.ofString());
        int status = response.statusCode();
        Assertions.assertEquals(200, status, "Expected Status Code 200 - Actual Code was: " + status);
        Accounts expectedResult = new Accounts(2, "Dolce", "Andromeda", "starlover81273@gmail.com", "574-670-4365", "StellarWatcher", "Thestarsarebeautiful!34");
        Accounts actualResult = objectMapper.readValue(response.body().toString(), new TypeReference<Accounts>(){});
        Assertions.assertEquals(expectedResult, actualResult, "Expected="+expectedResult + ", Actual="+actualResult);
    }
}
