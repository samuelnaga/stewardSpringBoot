package com.everis.alicante.steward.steward;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BasicAuthConfigurationIT {

	TestRestTemplate restTemplate;
    URL base;
    
    @LocalServerPort 
    int port;
 
    @Before
    public void setUp() throws MalformedURLException {
        restTemplate = new TestRestTemplate("user", "password");
        base = new URL("http://localhost:" + port + "/countries");
    }
 
    @Test
    public void whenLoggedUserRequestsHomePage_ThenSuccess() throws IllegalStateException, IOException, JSONException {
        ResponseEntity<String> response = restTemplate.getForEntity(base.toString(), String.class);
        
        System.out.println("respuesta 1 ::: " + response.getBody());
        
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assert.assertTrue(response.getBody().contains(""));
        JSONAssert.assertEquals("[]", response.getBody(), false);
    }
 
    @Test
    public void whenUserWithWrongCredentials_thenUnauthorizedPage() throws Exception {
  
        restTemplate = new TestRestTemplate("user", "wrongpassword");
        ResponseEntity<String> response = restTemplate.getForEntity(base.toString(), String.class);
        
        //Assert.assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());
        System.out.println("respuesta 2 ::: " + response.getBody());
        Assert.assertTrue(response.getBody().contains("Unauthorized"));
    }
}
