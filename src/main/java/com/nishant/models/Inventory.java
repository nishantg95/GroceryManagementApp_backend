package com.nishant.models;

import java.util.List;

public class Inventory {
	
	private String user; //will be a model in the future
	private Long id;
	public Long getId() {
		return id;
	}
	
	public Inventory() {
		// Will be removed upon addition of a model
		user= "Nishant";
	}
	public void setId(Long id) {
		this.id = id;
	}
	private List<Item> userItems;
	
	@Override
	public String toString() {
		return "Inventory [user=" + user + ", id=" + id + ", userItems=" + userItems + "]";
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public List<Item> getUserItems() {
		return userItems;
	}
	public void setUserItems(List<Item> userItems) {
		this.userItems = userItems;
	}
	

}
