package com.nishant.managers;

import java.util.List;

import com.nishant.models.Item;

public interface ItemManager {
	
	Item findById(Integer id);
	
	Item findbyName(String name);
	
	void saveItem(Item item);
	
	void updateItem(Item item);
	
	void deleteItemById(Integer id);
	
	List<Item> findAllItems();
	
	void deleteAllItems();
	
	public boolean isItemExist(Item item);

}