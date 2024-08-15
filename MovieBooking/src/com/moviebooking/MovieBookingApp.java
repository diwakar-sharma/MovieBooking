package com.moviebooking;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.moviebooking.entity.Show;
import com.moviebooking.service.Utility;

public class MovieBookingApp {

	public static void main(String[] args ) {
		try (Scanner scanner = new Scanner(System.in)) {
			boolean exit = false;
			while(!exit){
				System.out.print("Enter Show no:");
				Show show = Utility.getShow(scanner.nextInt());
				if(show==null) 
					continue;	
				show.showEmptySeats();
				System.out.print("\nEnter Seats:");
				String seats= scanner.next();
				Utility.bookSeatsInShow(show, seats);
				System.out.print("\nWould you like to continue (Yes/No):");
				String stop= scanner.next();
				if(stop.equalsIgnoreCase("NO"))
					exit = true;
			}
			Utility.showTotalSales();
		}

	}
}
