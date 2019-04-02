package com.everis.alicante.steward.steward.dbunit.controllerTest;

import java.net.MalformedURLException;

import org.json.JSONException;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import com.everis.alicante.steward.steward.persistence.dto.CityDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CityControllerIT {

	@LocalServerPort
    private int port;

    TestRestTemplate restTemplate;

    HttpHeaders headers = new HttpHeaders();

    private ObjectMapper  mapper;

    @Before
    public void setUp() throws MalformedURLException {
        restTemplate = new TestRestTemplate("admin", "admin");
        this.mapper = new ObjectMapper ();
    }
    
    @Test
    @DatabaseSetup("../dataset/initial-city.xml")
    public void B_testFindAllWithContent() throws JSONException {
        // Act
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/cities"),
                HttpMethod.GET, null, String.class);

        // Assert
        JSONAssert.assertEquals("[{'id': 1, 'name':'Alicante'}, {'id': 2, 'name':'SanJuan'}, {'id': 3, 'name':'Paris'}]", response.getBody(), false);//-> strictMode = false
    }
    
    @Test
    public void A_testFindAllNoContent() throws JSONException {
        //Arrange
        //HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        // Act
        ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/cities"), HttpMethod.GET, null, String.class);

        System.out.println(response.getBody());
        // Assert
        JSONAssert.assertEquals("[]", response.getBody(), false);
    }
    
    @Test
    public void C_test_create_nestedEntity() throws JSONException {
        //Arrange
        CityDTO dto = new CityDTO();
        dto.setName("Valencia");
        
        // Act
        ResponseEntity<String> exchange = restTemplate.exchange(createURLWithPort("/cities"), HttpMethod.POST, this.getPostRequest(dto), String.class);
        System.out.println("Create response: " + exchange.getBody());
        // Assert
        JSONAssert.assertEquals("{'id': 4, 'name':'Valencia'}", exchange.getBody(), JSONCompareMode.LENIENT);//LENIENT: Extensible(yes) - StrictOrdering(No)
    }
    
    private HttpEntity<String> getPostRequest(final Object object) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        try {
            return new HttpEntity<>(mapper.writeValueAsString(object), headers);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
    
    
    ////////DELETE
    @Test
    @DatabaseSetup("../dataset/initial-city.xml")
    public void D_test_delete_entity() throws JSONException {
    	
    	//Act
    	//restTemplate.exchange(createURLWithPort("/cities/1"), HttpMethod.DELETE, null, String.class);
    	restTemplate.delete(createURLWithPort("/cities/1"));
    	
    	
    	ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/cities"), HttpMethod.GET, null, String.class);
    	System.out.println("*** Response after deleting: " + response.getBody());
    	//Assert
    	 JSONAssert.assertEquals("[{'id': 2, 'name':'SanJuan'}, {'id': 3, 'name':'Paris'}]", response.getBody(), false);//-> strictMode = false
    }
    
    
    
    ///////PUT
    @Test
    @DatabaseSetup("../dataset/initial-city.xml")
    public void E_test_put_entity() throws JSONException {
    	
    	CityDTO dto = new CityDTO();
    	dto.setName("EditedCity");
    	//Act
    	restTemplate.put(createURLWithPort("/cities/1"), dto);
    	ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/cities"), HttpMethod.GET, null, String.class);

        // Assert
        JSONAssert.assertEquals("[{'id': 1, 'name':'EditedCity'}, {'id': 2, 'name':'SanJuan'}, {'id': 3, 'name':'Paris'}]", response.getBody(), false);
	  
    }


    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }
}
