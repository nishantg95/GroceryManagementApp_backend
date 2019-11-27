package com.nishant.managers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nishant.models.Item;
import com.nishant.services.ItemService;

@Service
public class ItemManagerImpl implements ItemManager{
	
	@Autowired
	ItemService itemService;

	@Override
	public Item findById(Integer id) {
		return itemService.findById(id);
	}

	@Override
	public Item findbyName(String name) {
		return itemService.findbyName(name);
	}

	@Override
	public void saveItem(Item item) {
		itemService.saveItem(item);
		
	}

	@Override
	public void updateItem(Item item) {
		itemService.updateItem(item);
		
	}

	@Override
	public void deleteItemById(Integer id) {
		itemService.deleteItemById(id);
		
	}

	@Override
	public List<Item> findAllItems() {
		return itemService.findAllItems();
	}

	@Override
	public void deleteAllItems() {
		itemService.deleteAllItems();
	}

	@Override
	public boolean isItemExist(Item item) {
		return itemService.isItemExist(item);
	}

}
