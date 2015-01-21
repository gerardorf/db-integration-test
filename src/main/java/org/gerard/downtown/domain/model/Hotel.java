package org.gerard.downtown.domain.model;

public class Hotel {
	
	private Integer id;
	private String name;
	private Integer distance;
	private String city;
	private String country;
	
	public Hotel(Integer id, String name, Integer distance, String city,
			String country) {
		this.id = id;
		this.name = name;
		this.distance = distance;
		this.city = city;
		this.country = country;
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
	public Integer getDistance() {
		return distance;
	}
	public void setDistance(Integer distance) {
		this.distance = distance;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return String.format(
				"Hotel [id=%s, name=%s, distance=%s, city=%s, country=%s]", id,
				name, distance, city, country);
	}
	
}
