package com.nishant.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
	public Boolean saveItem(Item item) {
		return dao.saveItem(item);
		
	}

	@Override
	public Boolean updateItem(Item item) {
		return dao.updateItem(item);
		
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
	public Integer deleteItemById(Integer id) {
		return dao.deleteItemById(id);
		
	}

	@Override
	public Integer deleteAllItems() {
		return dao.deleteAllItems();
		
	}

	@Override
	public Boolean isItemExist(Item item) {
		return dao.isItemExist(item);
	}
	
	

}
