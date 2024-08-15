package com.moviebooking.entity;

public enum ShowCategory {
	TWO_D("2D",1), THREE_D("3D",2);
	private final String key;
	private final int multiple;

    ShowCategory(String key,int multiple) {
        this.key = key;
		this.multiple = multiple;
    }

    public String getKey() {
        return key;
    }
    
    public int getMultiple() {
        return multiple;
    }
	
}
