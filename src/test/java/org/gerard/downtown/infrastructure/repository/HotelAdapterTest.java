package org.gerard.downtown.infrastructure.repository;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.gerard.downtown.domain.model.Hotel;
import org.gerard.downtown.domain.ports.secondary.HotelRepository;
import org.gerard.downtown.infrastructure.repository.jpa.HotelAdapter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class HotelAdapterTest {
	
	@Inject
	private HotelRepository repository;
	@Inject
	private HotelObjectMother objectMother;
	
	@Test
	@Transactional
	public void findAllHotelsInMadridDowntown() {
		objectMother.hotelsWithTwoHotelsInMadridDowntown();
		
		List<Hotel> hotels = HotelAdapter.toDomainList(repository.findDowntown("MADRID"));

		assertNotNull(hotels);
		assertThat("There should be two hotels in Madrid downtown", hotels, hasSize(2));
	}
}
