package edu.mum.cs544.bean;

import java.io.Serializable;

public class Hotel implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;

	private String name;

	private String description;

	private String ranking;

	private String phone;

	private int capacity;

	private Location location;

	public Hotel() {
	}

	public Hotel(String name, String description, String ranking, String phone, int capacity, Location location) {
		this.name = name;
		this.description = description;
		this.ranking = ranking;
		this.phone = phone;
		this.capacity = capacity;
		this.location = location;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRanking() {
		return ranking;
	}

	public void setRanking(String ranking) {
		this.ranking = ranking;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Hotel [id=" + id + ", name=" + name + ", description=" + description + ", ranking=" + ranking
				+ ", phone=" + phone + ", capacity=" + capacity + ", location=" + location + "]";
	}

}
