package com.nishant.services;

import java.util.List;

import com.nishant.models.Item;

public interface ItemService {

	Item findById(Long id);
	
	Item findbyName(String name);
	
	void saveItem(Item item);
	
	void updateItem(Item item);
	
	void deleteItemById(Long id);
	
	List<Item> findAllItems();
	
	void deleteAllItems();
	
	public boolean isItemExist(Item item);

}
