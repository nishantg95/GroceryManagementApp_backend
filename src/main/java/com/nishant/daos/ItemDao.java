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

	Integer deleteItemById(Integer id);

	List<Item> findAllItems();

	Item findById(Integer id);

	Item findByName(String name);

	Boolean isItemExist(Item item);

	Item saveItem(Item item);

	Item updateItem(Item item);

}
