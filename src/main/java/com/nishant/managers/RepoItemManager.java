/**
 *
 */
package com.nishant.managers;

import java.util.List;

import com.nishant.entities.RepoItemEntity;

/**
 * @author nishant.b.grover
 *
 */
public interface RepoItemManager {

	List<RepoItemEntity> findAllRepoItems();

	/**
	 * @param repoItem
	 * @return
	 */
	RepoItemEntity saveItem(RepoItemEntity repoItem);

}
