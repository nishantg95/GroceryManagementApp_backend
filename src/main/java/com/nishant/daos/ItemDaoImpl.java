/**
 *
 */
package com.nishant.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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

//
//	@Override
//	public ItemModel findById(Integer id) {
//		Criteria criteria = this.getSession().createCriteria(ItemModel.class);
//		criteria.add(Restrictions.eq("id", id));
//		return (ItemModel) criteria.uniqueResult();
//	}
//
//	@Override
//	public ItemModel findByName(String name) {
//		Criteria criteria = this.getSession().createCriteria(ItemModel.class);
//		criteria.add(Restrictions.eq("name", name));
//		return (ItemModel) criteria.uniqueResult();
//	}
//
	protected Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}
//
//	@Override
//	public Boolean isItemExist(ItemModel item) {
//		if (item != null) {
//			ItemModel returnItem = this.findByName(item.getName());
//			if (returnItem != null) {
//				return true;
//			}
//		}
//		return false;
//	}
//
//	@Override
//	public ItemModel saveItem(ItemModel item) {
//		this.getSession().persist(item);
//		return item;
//	}
//
//	@Override
//	public ItemModel updateItem(ItemModel item) {
//		this.getSession().update(item);
//		return item;
//	}
}
