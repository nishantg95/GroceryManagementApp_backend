package com.nishant.managers;

import java.util.List;

import com.nishant.models.Item;

public interface ItemManager {

	void deleteItemById(Integer id);

	List<Item> findAllItems();

	Item findById(Integer id);

	Item findbyName(String name);

	public Boolean isItemExist(Item item);

	void saveItem(Item item);

	void updateItem(Item item);

}