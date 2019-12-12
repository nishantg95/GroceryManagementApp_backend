/**
 *
 */
package com.nishant.daos;

import java.util.List;

import com.nishant.entities.ItemEntity;

/**
 * @author nishant.b.grover
 *
 */
public interface ItemDao {

	Integer deleteItemById(Integer id);

	List<ItemEntity> findAllItems();

	ItemEntity findById(Integer id);

	ItemEntity findByName(String name);

	Boolean isItemExist(ItemEntity item);

	ItemEntity saveItem(ItemEntity item);

	ItemEntity updateItem(ItemEntity item);

}
