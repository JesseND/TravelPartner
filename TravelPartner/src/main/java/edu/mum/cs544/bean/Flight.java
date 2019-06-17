package edu.mum.cs544.bean;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class Flight implements Serializable {

    private static final long serialVersionUID = 1L;

    private long id;
    private String flightnr;
    private Date departureDate;
    private Date departureTime;
    private Date arrivalDate;
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

    public Flight(String flightnr, String departureDate, String departureTime,
                  String arrivalDate, String arrivalTime) {
        this.flightnr = flightnr;
        setDepartureDate(departureDate);
        setDepartureTime(departureTime);
        setArrivalDate(arrivalDate);
        setArrivalTime(arrivalTime);
    }

    public Flight(String flightnr, String departureDate, String departureTime,
                  String arrivalDate, String arrivalTime, Airline airline,
                  Airport origin, Airport destination, Airplane airplane) {
        this.flightnr = flightnr;
        setDepartureDate(departureDate);
        setDepartureTime(departureTime);
        setArrivalDate(arrivalDate);
        setArrivalTime(arrivalTime);
        this.airline = airline;
        this.origin = origin;
        this.destination = destination;
        this.airplane = airplane;
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

    public void setDepartureDate(String departureDate) {
        try {
            this.departureDate = df.parse(departureDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setDepartureTime(String departureTime) {
        try {
            this.departureTime = tf.parse(departureTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setArrivalDate(String arrivalDate) {
        try {
            this.arrivalDate = df.parse(arrivalDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        try {
            this.arrivalTime = tf.parse(arrivalTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
}
