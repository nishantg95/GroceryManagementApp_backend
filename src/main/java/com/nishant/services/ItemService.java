package com.nishant.services;

import java.util.List;

import com.nishant.entities.ItemEntity;

public interface ItemService {

	Integer deleteItemById(Integer id);

	List<ItemEntity> findAllItems();

//	ItemEntity findById(Integer id);
//
//	ItemEntity findbyName(String name);
//
//	public Boolean isItemExist(ItemEntity item);
//
//	ItemEntity saveItem(ItemEntity item);
//
//	ItemEntity updateItem(ItemEntity item);

}
