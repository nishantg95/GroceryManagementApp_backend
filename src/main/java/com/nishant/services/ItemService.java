package com.nishant.services;

import java.util.List;

import com.nishant.models.Item;

public interface ItemService {

	Item findById(Integer id);
	
	Item findbyName(String name);
	
	Boolean saveItem(Item item);
	
	Boolean updateItem(Item item);
	
	Integer deleteItemById(Integer id);
	
	List<Item> findAllItems();
	
	Integer deleteAllItems();
	
	public Boolean isItemExist(Item item);

}
