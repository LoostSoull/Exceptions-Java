package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {
	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Room Number: ");
		int number = sc.nextInt();
		System.out.print("Enter the Check-In (dd/MM/yyyy) :");
		Date checkin = sdf.parse(sc.next());
		System.out.print("Enter the Check-Out (dd/MM/yyyy) :");
		Date checkout = sdf.parse(sc.next());
		
		if(!checkout.after(checkin)) {
			System.out.println("Error in Reservation: Check-Out date must be after Check-In Date!");
		}
		else{
			Reservation reservation = new Reservation(number,checkin,checkout);
			System.out.println("Reservation: " + reservation);
			System.out.println();
			
			System.out.println("Enter the Data to Update the reservation: ");
			System.out.println();
			System.out.print("Enter the Check-In (dd/MM/yyyy) :");
		    checkin = sdf.parse(sc.next());
			System.out.print("Enter the Check-Out (dd/MM/yyyy) :");
		    checkout = sdf.parse(sc.next());
		    
		    Date now = new Date();
		     if(checkin.before(now) || checkout.before(now)) {
		    	 System.out.println("Error in Reservation: Reservation Dates Must Be Future Dates!");
		     }else if (!checkout.after(checkin)) {
					System.out.println("Error in Reservation: Check-Out date must be after Check-In Date!");
				}else {
					reservation.updatDates(checkin, checkout);
					
					System.out.println("Reservation Update: " + reservation);
				}
			
			
		}
		
			
		
		
		
		
		
		
		
		sc.close();
	}
}
