/**
 * 
 */
package com.nishant.daos;

import java.util.List;

import com.nishant.models.Item;

/**
 * @author nishant.b.grover
 *
 */
public interface ItemDao {
	
	Boolean saveItem(Item item);
	
	List<Item> findAllItems();
	
	Item findByName(String name);
	
	Boolean updateItem(Item item);

	Item findById(Integer id);

	Integer deleteItemById(Integer id);

	Integer deleteAllItems();

	Boolean isItemExist(Item item);
	
}
