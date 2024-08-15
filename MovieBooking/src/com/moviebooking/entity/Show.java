package com.moviebooking.entity;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Show {
	private int showNo ; 
	private ShowCategory showCategory ; 

	private Map<String,Seat> seatMap= new HashMap<>();

	public Show(int showNo) {
		super();
		this.showNo = showNo;
	}
	
	public Show(int showNo , ShowCategory showCategory) {
		super();
		this.showNo = showNo;
		this.setShowCategory(showCategory);
	}

	
	public boolean addSheet(Seat seat ) {
		seatMap.put(seat.toString(), seat);
		return false;
	}
	
	public int getShowNo() {
		return showNo;
	}

	public Map<String, Seat> getSeatMap() {
		return seatMap;
	}

	public boolean bookSheet(Seat seat) {
		if(seatMap.containsKey(seat.toString())){
			seat.setEmpty(false);
			seatMap.put(seat.toString(),seat);
			return true;
		}
		return false;
	}

	public void showEmptySeats() {
		System.out.println("Show Type"+this.showCategory.getKey());
		Collection<Seat> seats = seatMap.values();
		seats.stream().filter(s->s.isEmpty()).filter(s->(s.getCategory().getKey().equals(Category.A.getKey()))).forEach(s->System.out.print(s+" "));
		System.out.println("");
		seats.stream().filter(s->s.isEmpty()).filter(s->(s.getCategory().getKey().equals(Category.B.getKey()))).forEach(s->System.out.print(s+" "));
		System.out.println("");
		seats.stream().filter(s->s.isEmpty()).filter(s->(s.getCategory().getKey().equals(Category.C.getKey()))).forEach(s->System.out.print(s+" "));
		System.out.println("");
	}

	@Override
	public String toString() {
		return "Show " + showNo;
	}

	public ShowCategory getShowCategory() {
		return showCategory;
	}

	public void setShowCategory(ShowCategory showCategory) {
		this.showCategory = showCategory;
	}	
	
	
}
