package org.gerard.downtown.infrastructure.repository.jpa;

import java.util.ArrayList;
import java.util.List;

import org.gerard.downtown.domain.model.Hotel;

public class HotelAdapter {

	public static List<Hotel> toDomainList(
			List<org.gerard.downtown.infrastructure.repository.jpa.Hotel> jpaHotels) {
		List<Hotel> hotels = new ArrayList<>();
		for (org.gerard.downtown.infrastructure.repository.jpa.Hotel jpaHotel : jpaHotels) {
			hotels.add(toDomain(jpaHotel));
		}
		return hotels;
	}

	private static Hotel toDomain(
			org.gerard.downtown.infrastructure.repository.jpa.Hotel jpaHotel) {
		return new Hotel(jpaHotel.getId(),jpaHotel.getName(),
				jpaHotel.getMetersToCityCenter(), jpaHotel.getCity().getName(),
				jpaHotel.getCity().getCountry().getName());
	}

}
