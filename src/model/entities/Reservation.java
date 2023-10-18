package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

	private int roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation(int roomNumber, Date checkIn, Date checkOut) {
		super();
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	public int getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	public Date getCheckInDate() {
		return checkIn;
	}
	
	public Date getCheckOutDate() {
		return checkOut;
	}

	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff,TimeUnit.MILLISECONDS);
	}
	
	public String updatDates(Date checkIn , Date checkOut) {
		
		 Date now = new Date();
	     if(checkIn.before(now) || checkOut.before(now)) {
	    	 
	    	 return "Reservation Dates Must Be Future Dates!";
	    	 
	     } if (!checkOut.after(checkIn)) {
	    	 
				return "Check-Out date must be after Check-In Date!";
			}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		return null;
	}
	
	@Override
	public String toString() {
		return "Reservation: "
				+ roomNumber
				+" ,check-in: "
				+sdf.format(checkIn)
				+" , check-out: "
				+sdf.format(checkOut)
				+" , "
				+duration()
				+ " nights.";
	}
	
}
