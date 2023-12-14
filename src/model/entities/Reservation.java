package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	private int roomNumber;
	private Date checkin;
	private Date checkout;
	
	private static  SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public int getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	public Date getCheckin() {
		return checkin;
	}

	public Date getCheckout() {
		return checkout;
	}

	public Reservation(int roomNumber, Date checkin, Date checkout) {
		super();
		this.roomNumber = roomNumber;
		this.checkin = checkin;
		this.checkout = checkout;
	}
	
	public long duration() {
		long diff = checkout.getTime() - checkin.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
		
	}
	
	public void updateDates(Date checkIn, Date checkOut) {
		this.checkin = checkIn;
		this.checkout = checkOut;
	}
	
	@Override
	public String toString() {
		return "Reservation [roomNumber=" + roomNumber + ", checkin=" + sdf.format(checkin) + ", checkout=" + sdf.format(checkout) + " duration: " + duration() + " nights. ]";
	}
	
}
