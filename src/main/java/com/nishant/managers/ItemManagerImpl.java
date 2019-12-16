package com.nishant.managers;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nishant.entities.ItemEntity;
import com.nishant.models.ItemModel;
import com.nishant.services.ItemService;
import com.nishant.views.ItemView;

@Service
public class ItemManagerImpl implements ItemManager {

	private static final Logger LOGGER = Logger.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());

	@Autowired
	private ItemService itemService;

	@Override
	public void deleteItemById(Integer id) {
		Integer deletedCountManager = this.itemService.deleteItemById(id);
		LOGGER.info("Number of items deleted successfully = " + deletedCountManager);
	}

	@Override
	public List<ItemView> findAllItems() {
		List<ItemView> itemViewList = new ArrayList<>();
		List<ItemEntity> itemEntityList = this.itemService.findAllItems();
		for (ItemEntity itemEntity : itemEntityList) {
			ItemView itemView = new ItemView();
			BeanUtils.copyProperties(itemEntity, itemView, ItemModel.class);
			itemViewList.add(itemView);
		}
		LOGGER.info("Returning all items fetched");
		return itemViewList;
	}

	@Override
	public ItemView findById(Integer id) {
		ItemEntity itemEntity = this.itemService.findById(id);
		ItemView itemView = new ItemView();
		BeanUtils.copyProperties(itemEntity, itemView, ItemModel.class);
		return itemView;
	}

	@Override
	public ItemView findByName(String name) {
		ItemEntity itemEntity = this.itemService.findByName(name);
		ItemView itemView = new ItemView();
		BeanUtils.copyProperties(itemEntity, itemView, ItemModel.class);
		return itemView;
	}

	@Override
	public Boolean isItemExist(ItemView item) {
		ItemEntity itemEntity = new ItemEntity();
		BeanUtils.copyProperties(item, itemEntity, ItemModel.class);
		return this.itemService.isItemExist(itemEntity);
	}

	@Override
	public void saveItem(ItemView item) {
		ItemEntity itemEntity = new ItemEntity();
		BeanUtils.copyProperties(item, itemEntity, ItemModel.class);
		itemEntity = this.itemService.saveItem(itemEntity);
		if (itemEntity.getId() != null) {
			LOGGER.info("Following Item was saved successfully" + item);
		} else {
			LOGGER.info("Following Item saved failed" + item);
		}

	}

	@Override
	public void updateItem(ItemView item) {
		ItemEntity itemEntity = new ItemEntity();
		BeanUtils.copyProperties(item, itemEntity, ItemModel.class);
		itemEntity = this.itemService.updateItem(itemEntity);
		if (!itemEntity.equals(item)) {
			LOGGER.info("Following Item update failed" + item + "; updatedItem recieved " + itemEntity);
		} else {
			LOGGER.info("Following Item was updated successfully" + item + " to " + itemEntity);
		}

	}

}
