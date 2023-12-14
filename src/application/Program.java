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
		
		if(!checkout.after(checkin)) {
			System.out.println("Erro, data do checkin, posterior ao checkout");
		}else {
			Reservation reservation = new Reservation(number, checkin, checkout);
			System.out.println(reservation.toString());
			
			
			System.out.println();
			System.out.println("Atualização das datas");
			System.out.println("Digite o ckeck-in 'dd/MM/yyyy' ");
			Date checkinUpdate = sdf.parse(sc.next());
			
			System.out.println("Digite o ckeck-out 'dd/MM/yyyy' ");
			Date checkoutUpdate = sdf.parse(sc.next());
			
			Date now = new Date();
			if(checkinUpdate.before(now) || checkoutUpdate.before(now)) {
				System.out.println("Erro no update");
			}else if(!checkoutUpdate.after(checkinUpdate)) {
					System.out.println("Erro, data do checkin, posterior ao checkout");
				
			}else {
				reservation.updateDates(checkinUpdate, checkoutUpdate);
				
				System.out.println(reservation.toString());
			}
			
		}
		sc.close();	
	}
	

}
