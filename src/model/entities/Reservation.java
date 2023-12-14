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
		String valid = validDate(checkin, checkout);
		if(valid != null) {
			System.out.println(valid);
		}else {
			this.roomNumber = roomNumber;
			this.checkin = checkin;
			this.checkout = checkout;
		}
	}
	
	public long duration() {
		long diff = checkout.getTime() - checkin.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
		
	}
	
	public static String validDate(Date checkIn, Date checkOut) {
		if(!checkOut.after(checkIn)) {
			return "Erro, data do checkin, posterior ao checkout";
		}
		return null;
	}
	
	public  String updateDates(Date checkIn, Date checkOut) {
		Date now = new Date();
		
		if(checkIn.before(now) || checkOut.before(now)) {
			return"Erro no update";
		}
		validDate(checkIn, checkOut);
			
		this.checkin = checkIn;
		this.checkout = checkOut;
		return null;
		
	}
	
	@Override
	public String toString() {
		return "Reservation [roomNumber=" + roomNumber + ", checkin=" + sdf.format(checkin) + ", checkout=" + sdf.format(checkout) + " duration: " + duration() + " nights. ]";
	}
	
}
