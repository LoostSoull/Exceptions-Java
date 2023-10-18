package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

	private int roomNumber;
	private Date checkInDate;
	private Date checkOutDate;
	
	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation(int roomNumber, Date checkInDate, Date checkOutDate) {
		super();
		this.roomNumber = roomNumber;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
	}
	public int getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	public Date getCheckInDate() {
		return checkInDate;
	}
	
	public Date getCheckOutDate() {
		return checkOutDate;
	}

	public long duration() {
		long diff = checkOutDate.getTime() - checkInDate.getTime();
		return TimeUnit.DAYS.convert(diff,TimeUnit.MILLISECONDS);
	}
	
	public void updatDates(Date checkInDate , Date checkOutDate) {
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
	}
	
	@Override
	public String toString() {
		return "Reservation: "
				+ roomNumber
				+" ,check-in: "
				+sdf.format(checkInDate)
				+" , check-out: "
				+sdf.format(checkInDate)
				+" , "
				+duration()
				+ " nights.";
	}
	
}
