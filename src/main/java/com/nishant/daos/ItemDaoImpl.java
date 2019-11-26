/**
 * 
 */
package com.nishant.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.hibernate.Query;
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
		return (List<Item>) criteria.list();
	}

	@Override
	public void deleteItemByName(String name) {
		Query query = getSession().createSQLQuery("delete from Item where name = :name");
		query.setString("name", name);
		query.executeUpdate();
			
	}

	@Override
	public Item findByName(String name) {
		Criteria criteria = getSession().createCriteria(Item.class);
		criteria.add(Restrictions.eq("name", name));
		return (Item) criteria.uniqueResult();
	}

	@Override
	public void updateItem(Item item) {
		getSession().update(item);
		
	}

	@Override
	public Item findById(Integer id) {
		Criteria criteria = getSession().createCriteria(Item.class);
		criteria.add(Restrictions.eq("id", id));
		return (Item) criteria.uniqueResult();
	}

	@Override
	public void deleteItemById(Integer id) {
		Query query = getSession().createSQLQuery("delete from Item where id = :id");
		query.setInteger("id",id);
		query.executeUpdate();
		
	}

	@Override
	public void deleteAllItems() {
		Query query = getSession().createSQLQuery("delete from Item");
		query.executeUpdate();
	}

	@Override
	public boolean isItemExist(Item item) {
		Item checker =  findByName(item.getName());
		if(checker.equals(null))
			return false;
		return true;
	}

}
