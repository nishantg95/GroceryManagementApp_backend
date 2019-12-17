/**
 *
 */
package com.nishant.managers;

import java.util.List;
import java.util.logging.Logger;

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

	private static final Logger LOGGER = Logger.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());

	@Autowired
	private RepoItemService repoItemService;

	@Override
	public List<RepoItemEntity> findAllRepoItems() {
		return this.repoItemService.findAllRepoItems();
	}

}
