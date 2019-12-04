package com.nishant.managers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nishant.models.Item;
import com.nishant.services.ItemService;

@Service
public class ItemManagerImpl implements ItemManager{
	
	@Autowired
	private ItemService itemService;

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
		Boolean flag = itemService.saveItem(item);
		if(flag == Boolean.TRUE) {
			System.out.println("Manager: Following Item was saved successfully"+item);
		}
		else {
			System.out.println("Manager: Following Item saved failed"+item);
		}
		
	}

	@Override
	public void updateItem(Item item) {
		Boolean flag = itemService.updateItem(item);
		if(flag == Boolean.TRUE) {
			System.out.println("Manager: Following Item was updated successfully"+item);
		}
		else {
			System.out.println("Manager: Following Item update failed"+item);
		}
		
	}

	@Override
	public void deleteItemById(Integer id) {
		Integer deletedCountManager = itemService.deleteItemById(id);
		System.out.println("Manager: Number of items deleted successfully = "+deletedCountManager);
		
	}

	@Override
	public List<Item> findAllItems() {
		return itemService.findAllItems();
	}

	@Override
	public void deleteAllItems() {
		Integer deletedCountManager = itemService.deleteAllItems();
		System.out.println("Manager: Number of items deleted successfully = "+deletedCountManager);
	}

	@Override
	public Boolean isItemExist(Item item) {
		return itemService.isItemExist(item);
	}

}
