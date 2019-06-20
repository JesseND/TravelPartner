package edu.mum.cs544.bean;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

public class Reservation {

	private long id;

	@NotNull
	private long userId;

	@NotNull
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@FutureOrPresent
	@Temporal(TemporalType.DATE)
	private Date checkin;

	@NotNull
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Future
	@Temporal(TemporalType.DATE)
	private Date checkout;

	private String status;

	@NotNull
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

	public long getId() {
		return id;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
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
