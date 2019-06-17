package edu.mum.cs544.bean;

import java.util.Date;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

public class Reservation {

	private long id;

	private long userId;

	private Date checkin;

	private Date checkout;

	private String status;

	private RoomIdentity roomId;

	public Reservation() {
	}

	public Reservation(long userId, Date check_in, Date check_out, String status, RoomIdentity roomId) {
		this.userId = userId;
		this.checkin = check_in;
		this.checkout = check_out;
		this.status = status;
		this.roomId = roomId;
	}

	public Long getId() {
		return id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Date getCheckin() {
		return checkin;
	}

	public void setCheckin(Date check_in) {
		this.checkin = check_in;
	}

	public Date getCheckout() {
		return checkout;
	}

	public void setCheckout(Date check_out) {
		this.checkout = check_out;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public RoomIdentity getRoomId() {
		return roomId;
	}

	public void setRoomId(RoomIdentity roomId) {
		this.roomId = roomId;
	}

}
