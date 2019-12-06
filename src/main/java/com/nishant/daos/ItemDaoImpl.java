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

	@Override
	public Integer deleteItemById(Integer id) {
		Query query = this.getSession().createSQLQuery("delete from Item where id = :id");
		query.setInteger("id", id);
		Integer deletedCountDao = query.executeUpdate();
		return deletedCountDao;
	}

	@Override
	public List<Item> findAllItems() {
		Criteria criteria = this.getSession().createCriteria(Item.class);
		return criteria.list();
	}

	@Override
	public Item findById(Integer id) {
		Criteria criteria = this.getSession().createCriteria(Item.class);
		criteria.add(Restrictions.eq("id", id));
		return (Item) criteria.uniqueResult();
	}

	@Override
	public Item findByName(String name) {
		Criteria criteria = this.getSession().createCriteria(Item.class);
		criteria.add(Restrictions.eq("name", name));
		return (Item) criteria.uniqueResult();
	}

	protected Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public Boolean isItemExist(Item item) {
		if (item != null) {
			Item returnItem = this.findByName(item.getName());
			if (returnItem != null) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Item saveItem(Item item) {
		this.getSession().persist(item);
		return item;
	}

	@Override
	public Item updateItem(Item item) {
		this.getSession().update(item);
		return item;
	}
}
