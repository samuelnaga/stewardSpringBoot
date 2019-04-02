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

import com.everis.alicante.steward.steward.persistence.entity.Workplace;
import com.everis.alicante.steward.steward.persistence.repository.WorkplaceRepository;
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
public class WorkplaceDAOIT {

	@Autowired
	private WorkplaceRepository workplaceRepository;
	
	 @Test
    @DatabaseSetup("../dataset/initial-workplace.xml")
    public void testFindAll() throws JSONException {
        // Act
        List<Workplace> all = (List<Workplace>) workplaceRepository.findAll();

        // Assert
        Assert.assertEquals(3, all.size());
    }

    
    @Test
    @DatabaseSetup("../dataset/initial-workplace.xml")
    public void testSaveWorkplace() throws JSONException {
        // Arrange
        final Workplace workplace = new Workplace();
        workplace.setNumber(4);
        workplace.setCoordX(25);
        workplace.setCoordY(45);
//	        Date creationDate = new Date();
//	        workplace.setCreationDate(creationDate);

        // Act
        workplaceRepository.save(workplace);

        // Assert
        List<Workplace> all = (List<Workplace>) workplaceRepository.findAll();
        Assert.assertEquals(4, all.size());
    }


    @Test
    @DatabaseSetup("../dataset/initial-workplace.xml")
    @ExpectedDatabase(value = "../dataset/after-saving-workplace.xml", assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED)
    public void testSaveWorkplace2() throws JSONException {
        // Arrange
        final Workplace workplace = new Workplace();
        workplace.setNumber(4);
        workplace.setCoordX(25);
        workplace.setCoordY(45);
        // Act
        workplaceRepository.save(workplace);
    }


    @Test
    @DatabaseSetup("../dataset/initial-workplace.xml")
    @ExpectedDatabase(value = "../dataset/after-removing-workplace.xml", assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED)
    public void testRemoveWorkplace() throws JSONException {
        // Act
        workplaceRepository.deleteById(3L);
    }

}
