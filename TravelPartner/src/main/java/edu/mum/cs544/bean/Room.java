package edu.mum.cs544.bean;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Room implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private RoomIdentity roomId;

	private double pricePerNight;

	private int maxPersons;

	private boolean reserved;

	public Room() {
	}

	public Room(RoomIdentity roomId, double pricePerNight, int maxPersons, boolean reserved) {
		this.roomId = roomId;
		this.pricePerNight = pricePerNight;
		this.maxPersons = maxPersons;
		this.reserved = reserved;
	}

	public RoomIdentity getRoomId() {
		return roomId;
	}

	public void setRoomId(RoomIdentity roomId) {
		this.roomId = roomId;
	}

	public double getPricePerNight() {
		return pricePerNight;
	}

	public void setPricePerNight(double pricePerNight) {
		this.pricePerNight = pricePerNight;
	}

	public int getMaxPersons() {
		return maxPersons;
	}

	public void setMaxPersons(int maxPersons) {
		this.maxPersons = maxPersons;
	}

	public boolean isReserved() {
		return reserved;
	}

	public void setReserved(boolean reserved) {
		this.reserved = reserved;
	}

	@Override
	public String toString() {
		return "Room [roomId=" + roomId + ", pricePerNight=" + pricePerNight + ", maxPersons=" + maxPersons
				+ ", reserved=" + reserved + "]";
	}

}
