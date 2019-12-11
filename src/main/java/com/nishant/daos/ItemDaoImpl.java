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

import com.nishant.entities.ItemEntity;

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
	public List<ItemEntity> findAllItems() {
		Criteria criteria = this.getSession().createCriteria(ItemEntity.class);
		System.out.println(criteria.list());
		return criteria.list();
	}

	@Override
	public ItemEntity findById(Integer id) {
		Criteria criteria = this.getSession().createCriteria(ItemEntity.class);
		criteria.add(Restrictions.eq("id", id));
		return (ItemEntity) criteria.uniqueResult();
	}

	@Override
	public ItemEntity findByName(String name) {
		Criteria criteria = this.getSession().createCriteria(ItemEntity.class);
		criteria.add(Restrictions.eq("name", name));
		return (ItemEntity) criteria.uniqueResult();
	}

	protected Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public Boolean isItemExist(ItemEntity itemEntity) {
		if (itemEntity != null) {
			ItemEntity returnItem = this.findByName(itemEntity.getName());
			if (returnItem != null) {
				return true;
			}
		}
		return false;
	}

	@Override
	public ItemEntity saveItem(ItemEntity itemEntity) {
		this.getSession().persist(itemEntity);
		return itemEntity;
	}

	@Override
	public ItemEntity updateItem(ItemEntity itemEntity) {
		this.getSession().update(itemEntity);
		return itemEntity;
	}
}
