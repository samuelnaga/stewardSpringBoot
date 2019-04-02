package com.everis.alicante.steward.steward.dbunit.test;

import java.util.List;
import java.util.Optional;

import org.json.JSONException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import com.everis.alicante.steward.steward.persistence.entity.City;
import com.everis.alicante.steward.steward.persistence.repository.CityRepository;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
    DirtiesContextTestExecutionListener.class,
    TransactionalTestExecutionListener.class,
    DbUnitTestExecutionListener.class})
public class CityDAOIT {

	@Autowired
	private CityRepository cityRepository;
	
	@Test
    @DatabaseSetup("../dataset/initial-city.xml")
    public void testFindAll() throws JSONException {
        // Act
        List<City> all = (List<City>) cityRepository.findAll();

        // Assert
        Assert.assertEquals(3, all.size());
    }

	    
    @Test
    @DatabaseSetup("../dataset/initial-city.xml")
    public void testSaveCity() throws JSONException {
        // Arrange
        final City city = new City();
        city.setName("Alicante");
//	        Date creationDate = new Date();
//	        city.setCreationDate(creationDate);

        // Act
        cityRepository.save(city);

        // Assert
        List<City> all = (List<City>) cityRepository.findAll();
        Assert.assertEquals(4, all.size());
    }


//    @Test
//    @DatabaseSetup("../dataset/initial-city.xml")
//    @ExpectedDatabase(value = "../dataset/after-saving-city.xml", assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED)
//    public void testSaveCity2() throws JSONException {
//        // Arrange
//        final City city = new City();
//        city.setName("Lyon");
//        // Act
//        cityRepository.save(city);
//    }


    @Test
    @DatabaseSetup("../dataset/initial-city.xml")
    @ExpectedDatabase(value = "../dataset/after-removing-city.xml", assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED)
    public void testRemoveCity() throws JSONException {
        // Act
        cityRepository.deleteById(3L);
    }
    
//    @Test
//    @DatabaseSetup("../dataset/initial-city2.xml")
//    @ExpectedDatabase(value = "../dataset/after-saving-city2.xml", assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED)
//    public void testCascadeCity() throws JSONException {
//    	
//    	final City city = new City();
//        city.setName("Alicante");
//    }
}
