package edu.mum.cs544.bean;

import java.io.Serializable;

import javax.persistence.Embeddable;

public class RoomIdentity implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long roomNumber;
	private Long hotelId;

	public RoomIdentity() {
	}

	public RoomIdentity(long roomNumber, long hotelId) {
		this.roomNumber = roomNumber;
		this.hotelId = hotelId;
	}

	public Long getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Long roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Long getHotelId() {
		return hotelId;
	}

	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	}

}
