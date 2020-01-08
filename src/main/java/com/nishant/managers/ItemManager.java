package com.nishant.managers;

import java.util.List;

import com.nishant.views.ItemView;

public interface ItemManager {

	Integer deleteItemById(Integer id);

	List<ItemView> findAllItems();

	ItemView findById(Integer id);

	ItemView findByName(String name);

	Boolean isItemExist(ItemView item);

	ItemView saveItem(ItemView item);

	void updateItem(ItemView item);

}