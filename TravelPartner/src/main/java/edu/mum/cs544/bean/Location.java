package edu.mum.cs544.bean;

import javax.persistence.Embeddable;

@Embeddable
public class Location {

	private String country;

	private String city;

	private String street;

	private String zipcode;

	public Location() {
	}

	public Location(String country, String city, String street, String zipcode) {
		this.country = country;
		this.city = city;
		this.street = street;
		this.zipcode = zipcode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
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

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

}
