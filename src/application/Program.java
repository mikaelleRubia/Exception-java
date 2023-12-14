package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		
		Scanner sc =  new Scanner (System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("numero do quarto");
		int number = sc.nextInt();
		
		System.out.println("Digite o ckeck-in 'dd/MM/yyyy' ");
		Date checkin = sdf.parse(sc.next());
		
		System.out.println("Digite o ckeck-out 'dd/MM/yyyy' ");
		Date checkout = sdf.parse(sc.next());
		
		try {
			
			String valid = Reservation.validDate(checkin, checkout);
			Reservation reservation = new Reservation(number, checkin, checkout);
			System.out.println(reservation.toString());
			
			
			System.out.println("Digite o ckeck-in 'dd/MM/yyyy' ");
			Date checkinUpdate = sdf.parse(sc.next());
			
			System.out.println("Digite o ckeck-out 'dd/MM/yyyy' ");
			Date checkoutUpdate = sdf.parse(sc.next());
			
			String update = reservation.updateDates(checkinUpdate, checkoutUpdate);
			if (update != null) {
				System.out.println(update);
				
			}else {
				System.out.println(reservation.toString());	
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sc.close();	
	}
	

}
