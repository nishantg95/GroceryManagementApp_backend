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
	
	void saveItem(Item item);
	
	List<Item> findAllItems();
	
	void deleteItemByName(String name);
	
	Item findByName(String name);
	
	void updateItem(Item item);

	Item findById(Integer id);

	void deleteItemById(Integer id);

	void deleteAllItems();

	boolean isItemExist(Item item);
	
}
