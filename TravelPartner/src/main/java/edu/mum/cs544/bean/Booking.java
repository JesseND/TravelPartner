package edu.mum.cs544.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

public class Booking {

    private long id;

    private long user_id;

    private long flight_id;

    private boolean isActive;

    public Booking() {
    }

    public long getId() {
        return id;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public long getFlight_id() {
        return flight_id;
    }

    public void setFlight_id(long flight_id) {
        this.flight_id = flight_id;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Booking)) return false;
        Booking booking = (Booking) o;
        return id == booking.id &&
                user_id == booking.user_id &&
                flight_id == booking.flight_id &&
                isActive == booking.isActive;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user_id, flight_id, isActive);
    }
}
