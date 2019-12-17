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

import com.nishant.entities.RepoItemEntity;

/**
 * @author nishant.b.grover
 *
 */
@Repository
public class RepoItemDaoImpl implements RepoItemDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<RepoItemEntity> findAllRepoItems() {
		Criteria criteria = this.getSession().createCriteria(RepoItemEntity.class);
		return criteria.list();
	}

	protected Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

}
