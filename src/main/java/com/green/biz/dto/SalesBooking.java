package com.green.biz.dto;

public class SalesBooking {
	
	private String type;
	private int booking;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public int getBooking() {
		return booking;
	}
	public void setBooking(int booking) {
		this.booking = booking;
	}

	@Override
	public String toString() {
		return "SalesQuantity [type=" + type + ", booking=" + booking + "]";
	}
	
}
