/**
 *
 */
package com.nishant.managers;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

	public static final Logger LOGGER = LogManager.getLogger(RepoItemManager.class);
	@Autowired
	private RepoItemService repoItemService;

	@Override
	public List<RepoItemEntity> findAllRepoItems() {
		return this.repoItemService.findAllRepoItems();
	}

	@Override
	public void saveItem(RepoItemEntity repoItem) {
		this.repoItemService.saveRepoItem(repoItem);
		if (repoItem.getrId() != null) {
			LOGGER.debug("Following Item was saved successfully" + repoItem);
		} else {
			LOGGER.debug("Following Item saved failed" + repoItem);
		}

	}

}
