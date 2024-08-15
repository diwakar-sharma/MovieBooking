package com.moviebooking.entity;

public class Seat {
	private int seatNo ; 
	private Category category ; 
	private boolean isEmpty;
	
	
	public Seat(int seatNo, Category category) {
		super();
		this.seatNo = seatNo;
		this.category = category;
		this.isEmpty=true;
	}
	
	public Seat(int seatNo, Category category,boolean isEmpty) {
		super();
		this.seatNo = seatNo;
		this.category = category;
		this.isEmpty=isEmpty;
	}
	
	public int getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(int sheetNo) {
		this.seatNo = sheetNo;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public boolean isEmpty() {
		return isEmpty;
	}
	public void setEmpty(boolean isEmpty) {
		this.isEmpty = isEmpty;
	}
	
	public String toString() {
		return category.getKey()+seatNo;
	}
		
}
