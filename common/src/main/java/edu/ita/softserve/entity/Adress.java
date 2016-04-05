package edu.ita.softserve.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "adress")
public class Adress implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6206381324055754681L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "city")
	private String city;

	@Column(name = "street")
	private String street;

	@Column(name = "number_of_house")
	private String numberOfHouse;

	@Column(name = "number_of_flat")
	private Integer numberOfFlat;

	public Adress() {
		// TODO Auto-generated constructor stub
	}

	public Adress(String city, String street, String numberOfHouse, Integer numberOfFlat) {
		this.city = city;
		this.street = street;
		this.numberOfHouse = numberOfHouse;
		this.numberOfFlat = numberOfFlat;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNumberOfHouse() {
		return numberOfHouse;
	}

	public void setNumberOfHouse(String numberOfHouse) {
		this.numberOfHouse = numberOfHouse;
	}

	public Integer getNumberOfFlat() {
		return numberOfFlat;
	}

	public void setNumberOfFlat(Integer numberOfFlat) {
		this.numberOfFlat = numberOfFlat;
	}

	@Override
	public String toString() {
		return "city=" + city + ", street=" + street + ", numberOfHouse=" + numberOfHouse + ", numberOfFlat="
				+ numberOfFlat + "";
	}
}
