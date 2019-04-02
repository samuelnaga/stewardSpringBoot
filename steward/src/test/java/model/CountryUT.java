package model;

import static org.junit.Assert.assertEquals;

import org.dozer.DozerBeanMapper;
import org.junit.Test;

import com.everis.alicante.steward.steward.persistence.entity.Country;
import com.everis.alicante.steward.steward.persistence.dto.CountryDTO;

public class CountryUT {

	private static final DozerBeanMapper dozerMapper = new DozerBeanMapper();
	 
	@Test
	public void checkCountryMapping() {
        Country country = new Country();
        country.setName("Spain");
        CountryDTO dto = new CountryDTO();
        dozerMapper.map(country, dto);
 
        assertEquals(dto.getName(), "Spain");
    }
//	@Test
//	public void checkCountryMapping() {
//        CountryDTO creation = new CountryDTO();
//        creation.setName("Portugal");
//
//        Country country = modelMapper.map(creation, Country.class);
//        assertEquals(creation.getName(), country.getName());
//        assertEquals(creation.getCreationDate(), country.getCreationDate());
//        assertEquals(creation.getLastModifiedDate(), country.getLastModifiedDate());
//
//        CountryUpdateDTO update = new CountryUpdateDTO();
//        update.setName("England");
//
//        modelMapper.map(update, country);
//        assertEquals(update.getName(), country.getName());
//        assertEquals(creation.getCreationDate(), country.getCreationDate());
//        assertEquals(update.getLastModifiedDate(), country.getLastModifiedDate());
//    }
//	public void test() {
//		fail("Not yet implemented");
//	}

}
