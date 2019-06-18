package edu.mum.cs544.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import edu.mum.cs544.util.*;

import javax.persistence.Transient;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

public class FlightDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private String flightnr;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date departureDate;

    @JsonFormat(pattern = "HH:mm:ss")
    private Date departureTime;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date arrivalDate;

    @JsonFormat(pattern = "HH:mm:ss")
    private Date arrivalTime;
    private Long airline;
    private Long origin;
    private Long destination;
    private Long airplane;

    private DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT,
            Locale.US);

    private  DateFormat tf = DateFormat.getTimeInstance(DateFormat.SHORT,
            Locale.US);

    public FlightDTO() {
    }

    public String getFlightnr() {
        return flightnr;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public Long getAirline() {
        return airline;
    }

    public Long getOrigin() {
        return origin;
    }

    public Long getDestination() {
        return destination;
    }

    public Long getAirplane() {
        return airplane;
    }




    public void setFlightnr(String flightnr) {
        this.flightnr = flightnr;
    }

    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
	public void setDepartureDate(String departureDate) {
		try {
			this.departureDate = df.parse(departureDate);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@JsonDeserialize(using = CustomTimeDeserializer.class)
	public void setDepartureTime(String departureTime) {
		try {
			this.departureTime = tf.parse(departureTime);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
	public void setArrivalDate(String arrivalDate) {
		try {
			this.arrivalDate = df.parse(arrivalDate);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

    @JsonDeserialize(using = CustomTimeDeserializer.class)
    public void setArrivalTime(String arrivalTime) {
		try {
			this.arrivalTime = tf.parse(arrivalTime);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


//    public void setDepartureDate(Date departureDate) {
//        this.departureDate = departureDate;
//    }
//
//    public void setDepartureTime(Date departureTime) {
//        this.departureTime = departureTime;
//    }
//
//    public void setArrivalDate(Date arrivalDate) {
//        this.arrivalDate = arrivalDate;
//    }
//
//    public void setArrivalTime(Date arrivalTime) {
//        this.arrivalTime = arrivalTime;
//    }

    public void setAirline(Long airline) {
        this.airline = airline;
    }

    public void setOrigin(Long origin) {
        this.origin = origin;
    }

    public void setDestination(Long destination) {
        this.destination = destination;
    }

    public void setAirplane(Long airplane) {
        this.airplane = airplane;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FlightDTO)) return false;
        FlightDTO flightDTO = (FlightDTO) o;
        return flightnr.equals(flightDTO.flightnr) &&
                departureDate.equals(flightDTO.departureDate) &&
                departureTime.equals(flightDTO.departureTime) &&
                arrivalDate.equals(flightDTO.arrivalDate) &&
                arrivalTime.equals(flightDTO.arrivalTime) &&
                airline.equals(flightDTO.airline) &&
                origin.equals(flightDTO.origin) &&
                destination.equals(flightDTO.destination) &&
                airplane.equals(flightDTO.airplane);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flightnr, departureDate, departureTime, arrivalDate, arrivalTime, airline, origin, destination, airplane);
    }

    @Override
    public String toString() {
        return "FlightDTO{" +
                "flightnr='" + flightnr + '\'' +
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



