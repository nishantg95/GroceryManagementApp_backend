/**
 * 
 */
package com.nishant.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
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
	public Boolean saveItem(Item item) {
		try {
			//Try updating, if successful, return TRUE
			getSession().persist(item);
			return Boolean.TRUE;
			
		} catch (Exception e) {

			System.out.println("Unable to save the item from DAO session");
			e.printStackTrace();
		}
		return Boolean.FALSE;
		
	}

	@Override
	public List<Item> findAllItems() {
		Criteria criteria = getSession().createCriteria(Item.class);
		return (List<Item>) criteria.list();
	}


	@Override
	public Item findByName(String name) {
		Criteria criteria = getSession().createCriteria(Item.class);
		criteria.add(Restrictions.eq("name", name));
		return (Item) criteria.uniqueResult();
	}

	@Override
	public Boolean updateItem(Item item) {
		try {
			//Try updating, if successful, return TRUE
			getSession().update(item);
			return Boolean.TRUE;
			
		} catch (Exception e) {

			System.out.println("Unable to update the item from DAO session");
			e.printStackTrace();
		}
		return Boolean.FALSE;
		
	}

	@Override
	public Item findById(Integer id) {
		Criteria criteria = getSession().createCriteria(Item.class);
		criteria.add(Restrictions.eq("id", id));
		return (Item) criteria.uniqueResult();
	}

	@Override
	public Integer deleteItemById(Integer id) {
		Query query = getSession().createSQLQuery("delete from Item where id = :id");
		query.setInteger("id",id);
		Integer deletedCountDao = query.executeUpdate();
		return deletedCountDao;
		
	}

	@Override
	public Integer deleteAllItems() {
		Query query = getSession().createSQLQuery("delete from Item");
		Integer deletedCountDao = query.executeUpdate();
		return deletedCountDao;
	}

	@Override
	public Boolean isItemExist(Item item) {
		if(item != null) {
			Item returnItem = findByName(item.getName());
			if (returnItem != null) {
				return true;
			}
		}
		return false;
	}
}
