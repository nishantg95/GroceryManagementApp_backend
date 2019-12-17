/**
 *
 */
package com.nishant.daos;

import java.util.List;

import com.nishant.entities.RepoItemEntity;

/**
 * @author nishant.b.grover
 *
 */
public interface RepoItemDao {

	List<RepoItemEntity> findAllRepoItems();

}
