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
		List<ItemEntity> itemEntityList = this.itemService.findAllItems();
		System.out.println(itemEntityList);
		for (ItemEntity itemEntity : itemEntityList) {
			ItemView itemView = new ItemView();
			BeanUtils.copyProperties(itemEntity, itemView, ItemModel.class);
			itemViewList.add(itemView);
		}
		System.out.println(itemViewList);

		return itemViewList;
	}

	@Override
	public ItemView findById(Integer id) {
		ItemEntity itemEntity = this.itemService.findById(id);
		ItemView itemView = new ItemView();
		BeanUtils.copyProperties(itemEntity, itemView);
		return itemView;
	}

	@Override
	public ItemView findByName(String name) {
		ItemEntity itemEntity = this.itemService.findByName(name);
		ItemView itemView = new ItemView();
		BeanUtils.copyProperties(itemEntity, itemView);
		return itemView;
	}

	@Override
	public Boolean isItemExist(ItemView item) {
		return this.isItemExist(item);
	}

	@Override
	public void saveItem(ItemView item) {
		ItemEntity itemEntity = new ItemEntity();
		BeanUtils.copyProperties(item, itemEntity);
		itemEntity = this.itemService.saveItem(itemEntity);
		if (savedItem.getId() != null) {
			System.out.println("Manager: Following Item was saved successfully" + item);
		} else {
			System.out.println("Manager: Following Item saved failed" + item);
		}

	}

	@Override
	public void updateItem(ItemView item) {
		// TODO Auto-generated method stub

	}

//	@Override
//	public ItemModel findById(Integer id) {
//		return this.itemService.findById(id);
//	}
//
//	@Override
//	public ItemModel findByName(String name) {
//		return this.itemService.findByName(name);
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
