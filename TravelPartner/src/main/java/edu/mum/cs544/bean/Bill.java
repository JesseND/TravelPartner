package edu.mum.cs544.bean;

import java.io.Serializable;
import java.util.Date;

public class Bill implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;

	private long userId;

	private String message;

	private RoomIdentity roomId;

	private Date paymenDate;

	private double billAmount;

	private double amountPaid;

	public Bill() {
	}

	public Bill(long userId, String message, RoomIdentity roomId, Date paymenDate, double billAmount,
			double amountPaid) {
		this.userId = userId;
		this.message = message;
		this.roomId = roomId;
		this.paymenDate = paymenDate;
		this.billAmount = billAmount;
		this.amountPaid = amountPaid;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public RoomIdentity getRoomId() {
		return roomId;
	}

	public void setRoomId(RoomIdentity roomId) {
		this.roomId = roomId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Date getPaymenDate() {
		return paymenDate;
	}

	public void setPaymenDate(Date paymenDate) {
		this.paymenDate = paymenDate;
	}

	public double getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(double billAmount) {
		this.billAmount = billAmount;
	}

	public double getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
	}

}
