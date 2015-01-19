package org.gerard.downtown.infrastructure.repository.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.gerard.downtown.domain.ports.secondary.HotelRepository;
import org.springframework.stereotype.Repository;

@Repository
public class JpaHotelRepository implements HotelRepository {

	@PersistenceContext
	protected EntityManager entityManager;

	@Override
	public List<Hotel> findDowntown(String cityName) {
		List<Hotel> hotels = entityManager.createNamedQuery("Hotel.findDowntown", Hotel.class)
				.setParameter("cityName", cityName).getResultList();
		return hotels;
	}
	
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
