package edu.mum.cs544.bean;

import java.io.Serializable;

public class RoomIdentity implements Serializable {

	private static final long serialVersionUID = 1L;
	private long roomNumber;
	private long hotelId;

	public RoomIdentity() {
	}

	public RoomIdentity(long hotelId, long roomNumber) {
		this.roomNumber = roomNumber;
		this.hotelId = hotelId;
	}

	public long getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(long roomNumber) {
		this.roomNumber = roomNumber;
	}

	public long getHotelId() {
		return hotelId;
	}

	public void setHotelId(long hotelId) {
		this.hotelId = hotelId;
	}

	@Override
	public String toString() {
		return "RoomIdentity [roomNumber=" + roomNumber + ", hotelId=" + hotelId + "]";
	}
}
