package com.nishant.models;

public class Item {
	
	private String name;
	private Long id;
	private String expiry;
	
//	private java.sql.Date todaysDate;
//	https://stackoverflow.com/questions/15164864/how-to-accept-date-params-in-a-get-request-to-spring-mvc-controller
//	https://stackoverflow.com/questions/41911605/convert-and-save-date-with-spring-mvc

	public Item(Long id, String name, String expiry) {
		this.name = name;
		this.id = id;
		this.expiry = expiry;
		
	}
	public Item() {

	}
	@Override
	public String toString() {
		return "Item [name=" + name + ", id=" + id + ", expiry=" + expiry + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getExpiry() {
		return expiry;
	}
	public void setExpiry(String expiry) {
		this.expiry = expiry;
	}
}
