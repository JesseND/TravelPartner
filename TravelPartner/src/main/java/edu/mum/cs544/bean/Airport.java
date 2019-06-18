package edu.mum.cs544.bean;

import java.io.Serializable;
import java.util.Objects;

public class Airport implements Serializable {

    private long id;
    private String airportcode;
    private String name;
    private String city;
    private String country;

    public Airport() {
    }

    public Airport(String airportcode, String name, String city, String country) {
        this.airportcode = airportcode;
        this.name = name;
        this.city = city;
        this.country = country;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAirportcode() {
        return airportcode;
    }

    public void setAirportcode(String airportcode) {
        this.airportcode = airportcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return "Airport{" +
                "id=" + id +
                ", airportcode='" + airportcode + '\'' +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Airport)) return false;
        Airport airport = (Airport) o;
        return id == airport.id &&
                airportcode.equals(airport.airportcode) &&
                name.equals(airport.name) &&
                city.equals(airport.city) &&
                country.equals(airport.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, airportcode, name, city, country);
    }
}
