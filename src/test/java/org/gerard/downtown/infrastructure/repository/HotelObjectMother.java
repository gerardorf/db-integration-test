package org.gerard.downtown.infrastructure.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.gerard.downtown.infrastructure.repository.jpa.City;
import org.gerard.downtown.infrastructure.repository.jpa.Hotel;
import org.springframework.stereotype.Repository;

@Repository
public class HotelObjectMother {
	
	@PersistenceContext
	protected EntityManager entityManager;

	public void hotelsWithTwoHotelsInMadridDowntown() {
		City madrid = entityManager.createQuery("from City c where c.name='MADRID'", City.class).getSingleResult();
		City barcelona = entityManager.createQuery("from City c where c.name='BARCELONA'", City.class).getSingleResult();		
		entityManager.persist(new Hotel("ANY HOTEL", 126, madrid));
		entityManager.persist(new Hotel("ANOTHER HOTEL", 200, madrid));
		entityManager.persist(new Hotel("A HOTEL NOT IN DOWNTOWN", 235, madrid));
		entityManager.persist(new Hotel("A HOTEL DOWNTOWN IN A DIFFERENT CITY", 146, barcelona));
	}
	
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
}
