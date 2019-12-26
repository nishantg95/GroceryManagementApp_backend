/**
 *
 */
package com.nishant.services;

import java.util.List;

import com.nishant.entities.RepoItemEntity;

/**
 * @author nishant.b.grover
 *
 */
public interface RepoItemService {

	List<RepoItemEntity> findAllRepoItems();

	/**
	 * @param repoItem
	 * @return
	 */
	RepoItemEntity saveRepoItem(RepoItemEntity repoItem);

}
