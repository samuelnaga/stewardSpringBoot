package com.everis.alicante.steward.steward.dbunit.test;

import java.util.List;

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


import com.everis.alicante.steward.steward.persistence.entity.Country;
import com.everis.alicante.steward.steward.persistence.repository.CountryRepository;
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
public class CountryDAOIT {
	
    @Autowired
    private CountryRepository countryRepository;

    @Test
    @DatabaseSetup("../dataset/initial-country.xml")
    public void testFindAll() throws JSONException {
        // Act
        List<Country> all = (List<Country>) countryRepository.findAll();
        
        // Assert
        Assert.assertEquals(3, all.size());
    }
    
    
    @Test
    @DatabaseSetup("../dataset/initial-country.xml")
    public void testSaveCountry() throws JSONException {
        // Arrange
        final Country country = new Country();
        country.setName("England");
//        Date creationDate = new Date();
//        country.setCreationDate(creationDate);

        // Act
        countryRepository.save(country);

        // Assert
        List<Country> all = (List<Country>) countryRepository.findAll();
        Assert.assertEquals(4, all.size());
    }


//    @Test
//    @DatabaseSetup("../dataset/initial-country.xml")
//    @ExpectedDatabase(value = "../dataset/after-saving-country.xml", assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED)
//    public void testSaveCountry2() throws JSONException {
//        // Arrange
//        final Country country = new Country();
//        country.setName("Belgium");
//        // Act
//        countryRepository.save(country);
//    }


    @Test
    @DatabaseSetup("../dataset/initial-country.xml")
    @ExpectedDatabase(value = "../dataset/after-removing-country.xml", assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED)
    public void testRemoveCountry() throws JSONException {
        // Act
        countryRepository.deleteById(3L);
    }

    


}
