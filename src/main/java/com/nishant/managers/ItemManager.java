package com.nishant.managers;

import java.util.List;

import com.nishant.models.ItemModel;
import com.nishant.views.ItemView;

public interface ItemManager {

	void deleteItemById(Integer id);

	List<ItemView> findAllItems();

	ItemModel findById(Integer id);

	ItemModel findbyName(String name);

	public Boolean isItemExist(ItemModel item);

	void saveItem(ItemModel item);

	void updateItem(ItemModel item);

}