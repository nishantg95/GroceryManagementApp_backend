package com.nishant.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nishant.daos.ItemDao;
import com.nishant.models.Item;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemDao itemDao;

	@Override
	public Integer deleteItemById(Integer id) {
		return this.itemDao.deleteItemById(id);

	}

	@Override
	public List<Item> findAllItems() {
		return this.itemDao.findAllItems();
	}

	@Override
	public Item findById(Integer id) {
		return this.itemDao.findById(id);
	}

	@Override
	public Item findbyName(String name) {
		return this.itemDao.findByName(name);
	}

	@Override
	public Boolean isItemExist(Item item) {
		return this.itemDao.isItemExist(item);
	}

	@Override
	public Item saveItem(Item item) {
		return this.itemDao.saveItem(item);

	}

	@Override
	public Item updateItem(Item item) {
		return this.itemDao.updateItem(item);
	}

}
