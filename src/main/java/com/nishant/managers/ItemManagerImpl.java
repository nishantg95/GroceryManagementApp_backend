package com.nishant.managers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nishant.entities.ItemEntity;
import com.nishant.models.ItemModel;
import com.nishant.services.ItemService;
import com.nishant.views.ItemView;

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
	public List<ItemView> findAllItems() {
		List<ItemView> itemViewList = new ArrayList<>();
		System.out.println("Manager");
		List<ItemEntity> itementityList = this.itemService.findAllItems();
		System.out.println(itementityList);
		for (ItemEntity itemEntity : itementityList) {
			ItemView itemView = new ItemView();
			BeanUtils.copyProperties(itemEntity, itemView);
			itemViewList.add(itemView);
		}
		System.out.println(itemViewList);

		return itemViewList;
	}

	@Override
	public ItemModel findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemModel findbyName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean isItemExist(ItemModel item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveItem(ItemModel item) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateItem(ItemModel item) {
		// TODO Auto-generated method stub

	}

//	@Override
//	public ItemModel findById(Integer id) {
//		return this.itemService.findById(id);
//	}
//
//	@Override
//	public ItemModel findbyName(String name) {
//		return this.itemService.findbyName(name);
//	}
//
//	@Override
//	public Boolean isItemExist(ItemModel item) {
//		return this.itemService.isItemExist(item);
//	}
//
//	@Override
//	public void saveItem(ItemModel item) {
//		ItemModel savedItem = this.itemService.saveItem(item);
//		if (savedItem.getId() != null) {
//			System.out.println("Manager: Following Item was saved successfully" + item);
//		} else {
//			System.out.println("Manager: Following Item saved failed" + item);
//		}
//	}
//
//	@Override
//	public void updateItem(ItemModel item) {
//		ItemModel updatedItem = this.itemService.updateItem(item);
//		if (!updatedItem.equals(item)) {
//			System.out
//					.println("Manager: Following Item update failed" + item + "; updatedItem recieved " + updatedItem);
//		} else {
//			System.out.println("Manager: Following Item was updated successfully" + item + " to " + updatedItem);
//		}
//	}

}
