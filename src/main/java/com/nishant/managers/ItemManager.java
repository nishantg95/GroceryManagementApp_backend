package com.nishant.managers;

import java.util.List;

import com.nishant.views.ItemView;

public interface ItemManager {

	void deleteItemById(Integer id);

	List<ItemView> findAllItems();

	ItemView findById(Integer id);

	ItemView findByName(String name);

	public Boolean isItemExist(ItemView item);

	void saveItem(ItemView item);

	void updateItem(ItemView item);

}