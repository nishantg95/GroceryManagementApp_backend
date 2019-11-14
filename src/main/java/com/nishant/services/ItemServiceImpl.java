package com.nishant.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Service;
import com.nishant.models.Item;


@Service("itemService")
public class ItemServiceImpl implements ItemService {
	
	private static final AtomicLong counter = new AtomicLong();
	private static List<Item> items = populateDummyItems();

	@Override
	public Item findById(Long id) {

		return null;
	}

	private static List<Item> populateDummyItems() {
		List<Item> dummyItems = new ArrayList<Item>();
		dummyItems.add(new Item(counter.incrementAndGet(),"Onions", "14 days"));
		dummyItems.add(new Item(counter.incrementAndGet(),"Uncooked Pork Chops", "5 days"));
		dummyItems.add(new Item(counter.incrementAndGet(),"Asparagus", "7 days"));
		return dummyItems;
	}

	@Override
	public Item findbyName(String name) {
		for(Item i: items) {
			if(i.getName().equalsIgnoreCase(name))
				return i;
		}
		return null;
	}

	@Override
	public void saveItem(Item item) {
		item.setId(counter.incrementAndGet());
		items.add(item);

		
	}

	@Override
	public void updateItem(Item item) {
		//TODO : add implementation
		
	}

	@Override
	public void deleteItemById(long id) {
		//TODO : add implementation
		
	}

	@Override
	public List<Item> findAllItems() {
		return items;
	}

	@Override
	public void deleteAllItems() {
		//TODO : add implementation
		
	}

	@Override
	public boolean isItemExist(Item item) {

		return findbyName(item.getName())!=null;
	}

}
