/**
 *
 */
package com.nishant.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nishant.entities.RepoItemEntity;

/**
 * @author nishant.b.grover
 *
 */
@Repository
public class RepoItemDaoImpl implements RepoItemDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<RepoItemEntity> findAllRepoItems() {
		Criteria criteria = this.getSession().createCriteria(RepoItemEntity.class);
		criteria.addOrder(Order.desc("rId"));
		return criteria.list();
	}

	protected Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public RepoItemEntity saveRepoItem(RepoItemEntity repoItem) {
		this.getSession().persist(repoItem);
		return repoItem;
	}
}
