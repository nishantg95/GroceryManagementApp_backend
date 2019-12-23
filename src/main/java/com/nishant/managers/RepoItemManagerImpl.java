/**
 *
 */
package com.nishant.managers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nishant.entities.RepoItemEntity;
import com.nishant.services.RepoItemService;

/**
 * @author nishant.b.grover
 *
 */
@Service
public class RepoItemManagerImpl implements RepoItemManager {

	@Autowired
	private RepoItemService repoItemService;

	@Override
	public List<RepoItemEntity> findAllRepoItems() {
		return this.repoItemService.findAllRepoItems();
	}

}
