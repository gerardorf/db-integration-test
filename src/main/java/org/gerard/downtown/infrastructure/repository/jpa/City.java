package org.gerard.downtown.infrastructure.repository.jpa;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class City {
	
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="country_id", referencedColumnName="id")
	private Country country;
	
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
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return String.format("City [id=%s, name=%s, country=%s]", id, name,
				country);
	}
}
