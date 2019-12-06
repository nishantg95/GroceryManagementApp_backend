package com.nishant.services;

import java.util.List;

import com.nishant.models.Item;

public interface ItemService {

	Item findById(Integer id);
	
	Item findbyName(String name);
	
	Item saveItem(Item item);
	
	Item updateItem(Item item);
	
	Integer deleteItemById(Integer id);
	
	List<Item> findAllItems();
	
	public Boolean isItemExist(Item item);

}
