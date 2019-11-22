/**
 * 
 */
package com.nishant.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nishant.models.Item;

/**
 * @author nishant.b.grover
 *
 */

@Repository
public class ItemDaoImpl implements ItemDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	protected Session getSession() {
		return sessionFactory.getCurrentSession();		
	}

	@Override
	public void saveItem(Item item) {
		getSession().persist(item);
		
	}

	@Override
	public List<Item> findAllItems() {
		Criteria criteria = getSession().createCriteria(Item.class);
		return criteria.list();
	}

	@Override
	public void deleteItemByName(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Item findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateItem(Item item) {
		// TODO Auto-generated method stub
		
	}

}
