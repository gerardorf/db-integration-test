package org.gerard.downtown.domain.ports.secondary;

import java.util.List;

import org.gerard.downtown.infrastructure.repository.jpa.Hotel;

public interface HotelRepository {

	public abstract List<Hotel> findDowntown(String cityName);

}