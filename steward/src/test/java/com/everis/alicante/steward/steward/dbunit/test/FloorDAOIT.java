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

import com.everis.alicante.steward.steward.persistence.entity.Floor;
import com.everis.alicante.steward.steward.persistence.repository.FloorRepository;
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
public class FloorDAOIT {

	@Autowired
	private FloorRepository floorRepository;
	
	@Test
    @DatabaseSetup("../dataset/initial-floor.xml")
    public void testFindAll() throws JSONException {
        // Act
        List<Floor> all = (List<Floor>) floorRepository.findAll();

        // Assert
        Assert.assertEquals(3, all.size());
    }

    
    @Test
    @DatabaseSetup("../dataset/initial-floor.xml")
    public void testSaveFloor() throws JSONException {
        // Arrange
        final Floor floor = new Floor();
        floor.setNumber(4);
//	        Date creationDate = new Date();
//	        floor.setCreationDate(creationDate);

        // Act
        floorRepository.save(floor);

        // Assert
        List<Floor> all = (List<Floor>) floorRepository.findAll();
        Assert.assertEquals(4, all.size());
    }


    @Test
    @DatabaseSetup("../dataset/initial-floor.xml")
    @ExpectedDatabase(value = "../dataset/after-saving-floor.xml", assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED)
    public void testSaveFloor2() throws JSONException {
        // Arrange
        final Floor floor = new Floor();
        floor.setNumber(4);
        // Act
        floorRepository.save(floor);
    }


    @Test
    @DatabaseSetup("../dataset/initial-floor.xml")
    @ExpectedDatabase(value = "../dataset/after-removing-floor.xml", assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED)
    public void testRemoveFloor() throws JSONException {
        // Act
        floorRepository.deleteById(3L);
    }

}
