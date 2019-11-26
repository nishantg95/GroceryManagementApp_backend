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
	private ItemDao dao;
	
	@Override
	public Item findbyName(String name) {
		return dao.findByName(name);
	}

	@Override
	public void saveItem(Item item) {
		dao.saveItem(item);
		
	}

	@Override
	public void updateItem(Item item) {
		dao.updateItem(item);
		
	}

	@Override
	public List<Item> findAllItems() {
		return dao.findAllItems();
	}

	@Override
	public Item findById(Integer id) {
		return dao.findById(id);
	}

	@Override
	public void deleteItemById(Integer id) {
		dao.deleteItemById(id);
		
	}

	@Override
	public void deleteAllItems() {
		dao.deleteAllItems();
		
	}

	@Override
	public boolean isItemExist(Item item) {
		return dao.isItemExist(item);
	}
	
	

}
