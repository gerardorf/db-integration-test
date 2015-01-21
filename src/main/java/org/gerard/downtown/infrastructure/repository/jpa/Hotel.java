package org.gerard.downtown.infrastructure.repository.jpa;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@Entity
@NamedQuery(name = "Hotel.findDowntown", 
			query = "SELECT h "
					+ "FROM Hotel h "
					+ "WHERE h.metersToCityCenter <= :downtownDistance "
					+ "AND h.city.name = :cityName")
public class Hotel {
	
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private Integer metersToCityCenter;
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="city_id", referencedColumnName="id")
	private City city;
	
	public Hotel() {
	}
	public Hotel(String name, int metersToCityCenter, City city) {
		this.name=name;
		this.metersToCityCenter=metersToCityCenter;
		this.city=city;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getMetersToCityCenter() {
		return metersToCityCenter;
	}
	public void setMetersToCityCenter(Integer metersToCityCenter) {
		this.metersToCityCenter = metersToCityCenter;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return String.format(
				"Hotel [id=%s, name=%s, metersToCityCenter=%s, city=%s]", id,
				name, metersToCityCenter, city);
	}
}
