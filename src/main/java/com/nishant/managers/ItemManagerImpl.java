package com.nishant.managers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nishant.models.Item;
import com.nishant.services.ItemService;

@Service
public class ItemManagerImpl implements ItemManager {

	@Autowired
	private ItemService itemService;

	@Override
	public void deleteItemById(Integer id) {
		Integer deletedCountManager = this.itemService.deleteItemById(id);
		System.out.println("Manager: Number of items deleted successfully = " + deletedCountManager);
	}

	@Override
	public List<Item> findAllItems() {
		return this.itemService.findAllItems();
	}

	@Override
	public Item findById(Integer id) {
		return this.itemService.findById(id);
	}

	@Override
	public Item findbyName(String name) {
		return this.itemService.findbyName(name);
	}

	@Override
	public Boolean isItemExist(Item item) {
		return this.itemService.isItemExist(item);
	}

	@Override
	public void saveItem(Item item) {
		Item savedItem = this.itemService.saveItem(item);
		if (savedItem.getId() != null) {
			System.out.println("Manager: Following Item was saved successfully" + item);
		} else {
			System.out.println("Manager: Following Item saved failed" + item);
		}
	}

	@Override
	public void updateItem(Item item) {
		Item updatedItem = this.itemService.updateItem(item);
		if (!updatedItem.equals(item)) {
			System.out
					.println("Manager: Following Item update failed" + item + "; updatedItem recieved " + updatedItem);
		} else {
			System.out.println("Manager: Following Item was updated successfully" + item + " to " + updatedItem);
		}
	}

}
