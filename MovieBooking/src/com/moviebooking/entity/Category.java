package com.moviebooking.entity;
  
public enum Category {
	A("A",320), B("B",280), C("C",240);
	private final String key;
    private final Integer value;

    Category(String key, Integer value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }
    public Integer getValue() {
        return value;
    }
	
}
