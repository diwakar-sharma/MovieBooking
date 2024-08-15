package com.moviebooking.service;

import java.util.HashMap;
import java.util.Map;

import com.moviebooking.entity.*;

public class Utility {
	
	private static Map<Integer, Show> SHOWMAP = new HashMap<>();

	private static double TOTAL_REVENUE = 0;
	private static double TOTAL_SERVICE_TAX = 0;
	private static double TOTAL_SWACHH_BHARAT_CESS = 0;
	private static double TOTAL_KRISHI_KALYAN_CESS = 0;

	private final static double SERVICE_TAX_RATE = 0.14;
	private final static double SWACHH_BHARAT_CESS = 0.005;
	private final static double KRISHI_KALYAN_CESS = 0.005;

	static {
		addShow(1,"TWO_D" ,"A1,A2,A3,A4,A5,A6,A7,A8,A9,B1,B2,B3,B4,B5,B6,C2,C3,C4,C5,C6,C7");
		addShow(2, "THREE_D","A1,A2,A3,A4,A5,A6,A7,B2,B3,B4,B5,B6,C1,C2,C3,C4,C5,C6,C7");
		addShow(3,"TWO_D", "A1,A2,A3,A4,A5,A6,A7,B1,B2,B3,B4,B5,B6,B7,B8,C1,C2,C3,C4,C5,C6,C7,C8,C9");
	}

	
	public static void addShow(int showNo,String showCategory ,  String seats) {
		Show show = new Show(showNo,ShowCategory.valueOf(String.valueOf(showCategory)));
		addSeatsInShow(show, seats);
		SHOWMAP.put(show.getShowNo(), show);
	}

	public static Show getShow(int showNo) {
		Show show = SHOWMAP.get(showNo);
		if (show == null) {
			System.out.println("Not a Valid Show!\n"+
		"Please Select One of the Below Show\n"+
					SHOWMAP.keySet());
		}
		return show;
	}

	public static void showTotalSales() {
		System.out.println("\nRevenue: Rs." + TOTAL_REVENUE + "\nService Tax: Rs." + TOTAL_SERVICE_TAX
				+ "\nSwachh Bharat Cess: Rs." + TOTAL_SWACHH_BHARAT_CESS + "\nKrishi Kalyan Cess: Rs."
				+ TOTAL_KRISHI_KALYAN_CESS);
	}

	public static void addSeatsInShow(Show show, String seats) {
		String[] seatArr = seats.split(",");
		for (int i = 0; i < seatArr.length; i++) {
			String str = seatArr[i];
			str = str.trim();
			show.addSheet(new Seat(Integer.parseInt(str.substring(1)), Category.valueOf(String.valueOf(str.charAt(0)))));
		}
	}

	public static boolean validateSeatFormat(String seat) {
		if (seat.length() >= 2) {
			try {
				Category.valueOf(String.valueOf(seat.charAt(0)));
				Integer.parseInt(seat.substring(1));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
		return false;
	}

	public static void bookSeatsInShow(Show show, String seats) {
		int subTotal = 0;
		String[] seatArr = seats.split(",");

		for (int i = 0; i < seatArr.length; i++) {
			String str = seatArr[i];
			str = str.trim();
			if (!validateSeatFormat(str)) {
				System.out.println(str + "Not a Valid Seat");
				return;
			}
			Seat seat = new Seat(Integer.parseInt(str.substring(1)), Category.valueOf(String.valueOf(str.charAt(0))));
			if (show.bookSheet(seat)) {
				subTotal += (seat.getCategory().getValue());
			} else {
				System.out.println(seat + " Not available, Please select different seats");
				return;
			}
		}
		subTotal =subTotal*(show.getShowCategory().getMultiple());
		System.out.println("Successfully Booked -" + show);
		generateBillTotalCostInDetail(subTotal);
	}

	public static void generateBillTotalCostInDetail(double bookingAmount) {

		TOTAL_REVENUE += bookingAmount;
		TOTAL_SERVICE_TAX += (bookingAmount * SERVICE_TAX_RATE);
		TOTAL_SWACHH_BHARAT_CESS += (bookingAmount * SWACHH_BHARAT_CESS);
		TOTAL_KRISHI_KALYAN_CESS += (bookingAmount * KRISHI_KALYAN_CESS);

		System.out.println(
				"\nSubtotal: Rs." + bookingAmount + "\nService Tax @14%: Rs." + (bookingAmount * SERVICE_TAX_RATE)
						+ "\nSwachh Bharat Cess @0.5%: Rs." + (bookingAmount * SWACHH_BHARAT_CESS)
						+ "\nKrishi Kalyan Cess @0.5%: Rs. " + (bookingAmount * KRISHI_KALYAN_CESS) + "\nTotal: Rs."
						+ (bookingAmount * (1 + SERVICE_TAX_RATE + SWACHH_BHARAT_CESS + KRISHI_KALYAN_CESS)));

		System.out.println("-----------------------------------------");
	}

}
