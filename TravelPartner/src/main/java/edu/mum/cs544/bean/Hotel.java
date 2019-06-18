package edu.mum.cs544.bean;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import java.util.List;

@Entity
public class Hotel {

	@Id
	@GeneratedValue
	private long id;

	@NotBlank
	private String name;
	@Size(min = 15, max = 2500)
	private String description;

	@NotBlank
	private String ranking;

	@NotBlank
	private String phone;

	@Min(value = 50)
	private int capacity;

	@Embedded
	@NotNull
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

	public long getId() {
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
