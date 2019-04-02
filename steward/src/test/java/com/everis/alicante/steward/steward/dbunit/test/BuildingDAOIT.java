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

import com.everis.alicante.steward.steward.persistence.entity.Building;
import com.everis.alicante.steward.steward.persistence.repository.BuildingRepository;
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
public class BuildingDAOIT {

	@Autowired
	private BuildingRepository buildingRepository;
	
	@Test
    @DatabaseSetup("../dataset/initial-building.xml")
    public void testFindAll() throws JSONException {
        // Act
        List<Building> all = (List<Building>) buildingRepository.findAll();

        // Assert
        Assert.assertEquals(3, all.size());
    }

    
    @Test
    @DatabaseSetup("../dataset/initial-building.xml")
    public void testSavebuilding() throws JSONException {
        // Arrange
        final Building building = new Building();
        building.setName("OscarEspla2");
//	        Date creationDate = new Date();
//	        building.setCreationDate(creationDate);

        // Act
        buildingRepository.save(building);

        // Assert
        List<Building> all = (List<Building>) buildingRepository.findAll();
        Assert.assertEquals(4, all.size());
    }


    @Test
    @DatabaseSetup("../dataset/initial-building.xml")
    @ExpectedDatabase(value = "../dataset/after-saving-building.xml", assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED)
    public void testSavebuilding2() throws JSONException {
        // Arrange
        final Building building = new Building();
        building.setName("EdificioNuevo");
        // Act
        buildingRepository.save(building);
    }


    @Test
    @DatabaseSetup("../dataset/initial-building.xml")
    @ExpectedDatabase(value = "../dataset/after-removing-building.xml", assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED)
    public void testRemoveBuilding() throws JSONException {
        // Act
        buildingRepository.deleteById(3L);
    }

}
