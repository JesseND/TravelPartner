package edu.mum.cs544.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

public class Flight implements Serializable {

    private static final long serialVersionUID = 1L;

    private long id;
    private String flightnr;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date departureDate;

    @JsonFormat(pattern = "HH:mm:ss")
    private Date departureTime;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date arrivalDate;

    @JsonFormat(pattern = "HH:mm:ss")
    private Date arrivalTime;
    private Airline airline;
    private Airport origin;
    private Airport destination;
    private Airplane airplane;

    private  DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT,
            Locale.US);

    private  DateFormat tf = DateFormat.getTimeInstance(DateFormat.SHORT,
            Locale.US);

    public Flight() {
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFlightnr() {
        return flightnr;
    }

    public void setFlightnr(String flightnr) {
        this.flightnr = flightnr;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public Airport getOrigin() {
        return origin;
    }

    public void setOrigin(Airport origin) {
        this.origin = origin;
    }

    public Airport getDestination() {
        return destination;
    }

    public void setDestination(Airport destination) {
        this.destination = destination;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", flightnr='" + flightnr + '\'' +
                ", departureDate=" + departureDate +
                ", departureTime=" + departureTime +
                ", arrivalDate=" + arrivalDate +
                ", arrivalTime=" + arrivalTime +
                ", airline=" + airline +
                ", origin=" + origin +
                ", destination=" + destination +
                ", airplane=" + airplane +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Flight)) return false;
        Flight flight = (Flight) o;
        return id == flight.id &&
                flightnr.equals(flight.flightnr) &&
                departureDate.equals(flight.departureDate) &&
                departureTime.equals(flight.departureTime) &&
                arrivalDate.equals(flight.arrivalDate) &&
                arrivalTime.equals(flight.arrivalTime) &&
                airline.equals(flight.airline) &&
                origin.equals(flight.origin) &&
                destination.equals(flight.destination) &&
                airplane.equals(flight.airplane);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, flightnr, departureDate, departureTime, arrivalDate, arrivalTime, airline, origin, destination, airplane);
    }
}
